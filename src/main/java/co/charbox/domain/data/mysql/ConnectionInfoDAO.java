package co.charbox.domain.data.mysql;

import java.util.List;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.SelectConditionStep;
import org.jooq.SelectWhereStep;
import org.jooq.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.CharbotSearchContext;
import co.charbox.domain.data.jooq.tables.Connection;
import co.charbox.domain.data.jooq.tables.ConnectionInfo;
import co.charbox.domain.data.jooq.tables.Location;
import co.charbox.domain.data.jooq.tables.records.ConnectionInfoRecord;
import co.charbox.domain.model.mm.ConnectionInfoModel;
import co.charbox.domain.model.mm.ConnectionModel;
import co.charbox.domain.model.mm.LocationModel;

import com.google.common.collect.Lists;

@Component
public class ConnectionInfoDAO extends CharbotJooqDao<ConnectionInfoModel> {

	public static final String ALIAS = "ci";
	
	@Autowired private DaoProvider daoProvider;
	private ConnectionDAO connDao;
	private LocationDAO locDao;
	
	private final ConnectionInfo ci = ConnectionInfo.CONNECTION_INFO.as(ALIAS);
	private final Connection c = Connection.CONNECTION.as(ConnectionDAO.ALIAS);
	private final Location loc = Location.LOCATION.as(LocationDAO.ALIAS);
	private List<Field<?>> fields;

	protected ConnectionDAO getConnDao() {
		if (connDao == null) {
			connDao = daoProvider.getConnectionDAO();
		}
		return connDao;
	}
	
	protected LocationDAO getLocDao() {
		if (locDao == null) {
			locDao = daoProvider.getLocationDAO();
		}
		return locDao;
	}
	
	@Override
	protected Table<?> getTable() {
		return ci;
	}
	
	@Override
	protected Table<?> getRawTable() {
		return ConnectionInfo.CONNECTION_INFO;
	}

	@Override
	protected Field<Integer> getPk() {
		return ci.ID;
	}
	
	@Override
	public List<Field<?>> getFields() {
		if (fields == null) {
			fields = Lists.newArrayList(ci.fields());
			fields.addAll(getLocDao().getFields());
			fields.addAll(getConnDao().getFields());
		}
		return fields;
	}

	@Override
	protected SelectWhereStep<Record> getBaseQuery() {
		return db().select(getFields()).from(ci)
				.join(c).on(c.ID.eq(ci.CONNECTION_ID))
				.join(loc).on(loc.ID.eq(ci.LOCATION_ID));
	}
	
	@Override
	public ConnectionInfoModel insert(ConnectionInfoModel model) {
		if (model.getLocation().getId() == null) {
			LocationModel location = getLocDao().insert(model.getLocation());
			if (location == null || location.getId() == null) {
				throw new RuntimeException("Could not insert location data for connection info.");
			} else {
				model.setLocation(location);
			}
		}
		if (model.getConnection().getId() == null) {
			ConnectionModel connection= getConnDao().insert(model.getConnection());
			if (connection == null || connection.getId() == null) {
				throw new RuntimeException("Could not insert connection data for connection info.");
			} else {
				model.setConnection(connection);
			}
		}
		return super.insert(model);
	}
	
	public ConnectionInfoModel find(CharbotSearchContext context, String ip, Double lat, Double lon) {
		SelectConditionStep<Record> sql = getBaseQuery().where(c.IP.eq(ip)
				.and(loc.LAT.eq(lat))
				.and(loc.LON.eq(lon)));
		return convert(sql.fetchOne());
	}

	@Override
	protected Record convert(ConnectionInfoModel model) {
		return new ConnectionInfoRecord(model.getId(), model.getConnection().getId(), model.getLocation().getId());
	}

	@Override
	public ConnectionInfoModel convert(Record rec) {
		return rec == null ? null : ConnectionInfoModel.builder()
				.id(rec.getValue(ci.ID))
				.connection(getConnDao().convert(rec))
				.location(getLocDao().convert(rec))
				.build();
	}

}
