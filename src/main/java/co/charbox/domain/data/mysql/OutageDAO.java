package co.charbox.domain.data.mysql;

import java.util.List;

import org.elasticsearch.common.collect.Lists;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.SelectWhereStep;
import org.jooq.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.jooq.tables.Connection;
import co.charbox.domain.data.jooq.tables.ConnectionInfo;
import co.charbox.domain.data.jooq.tables.Devices;
import co.charbox.domain.data.jooq.tables.Location;
import co.charbox.domain.data.jooq.tables.Outage;
import co.charbox.domain.data.jooq.tables.records.OutageRecord;
import co.charbox.domain.model.OutageModel;
import co.charbox.domain.model.mm.ConnectionInfoModel;

import com.tpofof.core.data.dao.context.SimpleSearchContext;
import com.tpofof.core.data.dao.jdbc.AbstractSimpleJooqDAO;

@Component
public class OutageDAO extends AbstractSimpleJooqDAO<OutageModel, Integer, SimpleSearchContext> {

	public static final String ALIAS = "o";
	
	@Autowired private DaoProvider daoProvider;
	
	private final Outage o = Outage.OUTAGE.as(ALIAS);
	private final Devices d = Devices.DEVICES.as("d");
	private final ConnectionInfo ci = ConnectionInfo.CONNECTION_INFO.as("ci");
	private final Connection c = Connection.CONNECTION.as("conn");
	private final Location loc = Location.LOCATION.as("loc");
	
	private List<Field<?>> fields;
	
	@Override
	protected Table<?> getTable() {
		return o;
	}

	@Override
	protected Table<?> getRawTable() {
		return Outage.OUTAGE;
	}

	@Override
	protected Field<Integer> getPk() {
		return o.ID;
	}

	@Override
	public List<Field<?>> getFields() {
		if (fields == null) {
			fields = Lists.newArrayList(o.fields());
			fields.addAll(daoProvider.getDeviceDAO().getFields());
			fields.addAll(daoProvider.getConnectionInfoDAO().getFields());
		}
		return fields;
	}
	
	@Override
	public OutageModel insert(OutageModel model) {
		if (model.getConnectionInfo().getId() == null) {
			ConnectionInfoModel connInfo = daoProvider.getConnectionInfoDAO().insert(model.getConnectionInfo());
			if (connInfo == null || connInfo.getId() == null) {
				throw new RuntimeException("Cannot insert connection info for outage");
			} else {
				model.setConnectionInfo(connInfo);
			}
		}
		return super.insert(model);
	}

	@Override
	protected SelectWhereStep<Record> getBaseQuery() {
		return db().select(getFields()).from(getTable())
				.join(d).on(d.ID.eq(o.DEVICE_ID))
				.join(ci).on(ci.ID.eq(o.CONNECTION_INFO_ID))
				.join(c).on(c.ID.eq(ci.CONNECTION_ID))
				.join(loc).on(loc.ID.eq(ci.LOCATION_ID));
	}

	@Override
	protected Record convert(OutageModel model) {
		return new OutageRecord(model.getId(), 
				model.getDevice().getId(), 
				safe(model.getStartTime()), 
				safe(model.getEndTime()), 
				safeToInt(model.getDuration()), 
				safeToByte(model.isConfirmed()), 
				model.getType(), 
				model.getConnectionInfo().getId());
	}

	@Override
	public OutageModel convert(Record rec) {
		return rec == null ? null : OutageModel.builder()
				.confirmed(safeToBoolean(rec.getValue(o.CONFIRMED)))
				.connectionInfo(daoProvider.getConnectionInfoDAO().convert(rec))
				.device(daoProvider.getDeviceDAO().convert(rec))
				.duration(rec.getValue(o.DURATION))
				.endTime(safeToDateTime(rec.getValue(o.END_TIME)))
				.id(rec.getValue(o.ID))
				.startTime(safeToDateTime(rec.getValue(o.START_TIME)))
				.type(rec.getValue(o.TYPE))
				.build();
	}
}
