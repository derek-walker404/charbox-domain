package co.charbox.domain.data.mysql;

import java.util.List;

import org.elasticsearch.common.collect.Lists;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectWhereStep;
import org.jooq.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.jooq.tables.Connection;
import co.charbox.domain.data.jooq.tables.ConnectionInfo;
import co.charbox.domain.data.jooq.tables.Devices;
import co.charbox.domain.data.jooq.tables.Heartbeat;
import co.charbox.domain.data.jooq.tables.Location;
import co.charbox.domain.data.jooq.tables.records.HeartbeatRecord;
import co.charbox.domain.model.HeartbeatModel;
import co.charbox.domain.model.mm.ConnectionInfoModel;

import com.tpofof.core.data.dao.context.SimpleSearchContext;
import com.tpofof.core.data.dao.jdbc.AbstractSimpleJooqDAO;

@Component
public class HeartbeatDAO extends AbstractSimpleJooqDAO<HeartbeatModel, Integer, SimpleSearchContext> {

	public static final String ALIAS = "hb";
	
	@Autowired private DaoProvider daoProvider;
	
	private final Heartbeat hb = Heartbeat.HEARTBEAT.as(ALIAS);
	private final Devices d = Devices.DEVICES.as(DeviceDAO.ALIAS);
	private final ConnectionInfo ci = ConnectionInfo.CONNECTION_INFO.as("ci");
	private final Connection c = Connection.CONNECTION.as("conn");
	private final Location loc = Location.LOCATION.as("loc");
	private List<Field<?>> fields;
	
	@Override
	protected Table<?> getTable() {
		return hb;
	}
	
	@Override
	protected Table<?> getRawTable() {
		return Heartbeat.HEARTBEAT;
	}

	@Override
	protected Field<Integer> getPk() {
		return hb.ID;
	}
	
	@Override
	public List<Field<?>> getFields() {
		if (fields == null) {
			fields = Lists.newArrayList(hb.fields());
			fields.addAll(daoProvider.getDeviceDAO().getFields());
			fields.addAll(daoProvider.getConnectionInfoDAO().getFields());
		}
		return fields;
	}

	@Override
	protected SelectWhereStep<Record> getBaseQuery() {
		SelectOnConditionStep<Record> sql = db().select(getFields()).from(hb)
				.join(d).on(d.ID.eq(hb.DEVICE_ID))
				.join(ci).on(ci.ID.eq(hb.CI_ID))
				.join(c).on(c.ID.eq(ci.CONNECTION_ID))
				.join(loc).on(loc.ID.eq(ci.LOCATION_ID));
		return sql;
	}
	
	public HeartbeatModel findByDeviceId(Integer deviceId) {
		return convert(getBaseQuery().where(hb.DEVICE_ID.eq(deviceId)).fetchOne());
	}
	
	@Override
	public HeartbeatModel insert(HeartbeatModel model) {
		if (model.getConnection().getId() == null) {
			ConnectionInfoModel conn = daoProvider.getConnectionInfoDAO().insert(model.getConnection());
			if (conn == null) {
				throw new RuntimeException("Could not insert connection info for heartbeat: " + model);
			}
			model.setConnection(conn);
		}
		return super.insert(model);
	}

	@Override
	protected Record convert(HeartbeatModel model) {
		return new HeartbeatRecord(model.getId(), 
				model.getDevice().getId(), 
				safe(model.getTime()), 
				model.getConnection().getId());
	}

	@Override
	public HeartbeatModel convert(Record rec) {
		return rec == null ? null : HeartbeatModel.builder()
				.id(rec.getValue(hb.ID))
				.time(safeToDateTime(rec.getValue(hb.TIME)))
				.device(daoProvider.getDeviceDAO().convert(rec))
				.connection(daoProvider.getConnectionInfoDAO().convert(rec))
				.build();
	}

	public HeartbeatModel updateTime(HeartbeatModel model) {
		db().update(getTable())
				.set(hb.TIME, safe(model.getTime()))
				.where(hb.ID.eq(model.getId()))
				.execute();
		return find(model.getId());
	}
}
