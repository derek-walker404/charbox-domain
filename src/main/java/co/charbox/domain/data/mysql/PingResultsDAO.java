package co.charbox.domain.data.mysql;

import java.util.List;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.SelectConditionStep;
import org.jooq.SelectWhereStep;
import org.jooq.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.jooq.tables.Connection;
import co.charbox.domain.data.jooq.tables.ConnectionInfo;
import co.charbox.domain.data.jooq.tables.Devices;
import co.charbox.domain.data.jooq.tables.Location;
import co.charbox.domain.data.jooq.tables.Ping;
import co.charbox.domain.data.jooq.tables.SimpleLocation;
import co.charbox.domain.data.jooq.tables.records.PingRecord;
import co.charbox.domain.model.PingResultModel;
import co.charbox.domain.model.mm.ConnectionInfoModel;
import co.charbox.domain.model.mm.SimpleLocationModel;

import com.google.common.collect.Lists;
import com.tpofof.core.data.dao.ResultsSet;
import com.tpofof.core.data.dao.context.SimpleSearchContext;
import com.tpofof.core.data.dao.jdbc.AbstractSimpleJooqDAO;

@Component
public class PingResultsDAO extends AbstractSimpleJooqDAO<PingResultModel, Integer, SimpleSearchContext> {

	public static final String ALIAS = "p";
	
	private final Ping p = Ping.PING.as(ALIAS);
	private final Devices d = Devices.DEVICES.as(DeviceDAO.ALIAS);
	private final ConnectionInfo ci = ConnectionInfo.CONNECTION_INFO.as(ConnectionInfoDAO.ALIAS);
	private final Connection c = Connection.CONNECTION.as(ConnectionDAO.ALIAS);
	private final Location loc = Location.LOCATION.as(LocationDAO.ALIAS);
	private final SimpleLocation sl = SimpleLocation.SIMPLE_LOCATION.as(SimpleLocationDAO.ALIAS);

	@Autowired private DaoProvider daoProvider;
	private List<Field<?>> fields;
	
	@Override
	protected Table<?> getTable() {
		return p;
	}

	@Override
	protected Table<?> getRawTable() {
		return Ping.PING;
	}

	@Override
	protected Field<Integer> getPk() {
		return p.ID;
	}

	@Override
	protected SelectWhereStep<Record> getBaseQuery() {
		return db().select(getFields()).from(p)
				.join(d).on(d.ID.eq(p.DEVICE_ID))
				.join(ci).on(ci.ID.eq(p.CONNECTION_ID))
				.join(c).on(c.ID.eq(ci.CONNECTION_ID))
				.join(loc).on(loc.ID.eq(ci.LOCATION_ID))
				.join(sl).on(sl.ID.eq(p.SERVER_LOCATION_ID));
	}

	@Override
	public List<Field<?>> getFields() {
		if (fields == null) {
			fields = Lists.newArrayList(p.fields());
			fields.addAll(daoProvider.getDeviceDAO().getFields());
			fields.addAll(daoProvider.getConnectionInfoDAO().getFields());
			fields.addAll(daoProvider.getSimpleLocationDAO().getFields());
		}
		return fields;
	}
	
	public ResultsSet<PingResultModel> findByDeviceId(SimpleSearchContext context, Integer deviceId) {
		SelectConditionStep<Record> sql = getBaseQuery().where(p.DEVICE_ID.eq(deviceId));
		addSearchMeta(sql, context, false);
		return convert(sql.fetch(), context);
	}
	
	@Override
	public PingResultModel insert(PingResultModel model) {
		if (model.getConnectionInfo().getId() == null) {
			ConnectionInfoModel connInfo = daoProvider.getConnectionInfoDAO().insert(model.getConnectionInfo());
			if (connInfo == null || connInfo.getId() == null) {
				throw new RuntimeException("Cannot insert connection info for ping result.");
			} else {
				model.setConnectionInfo(connInfo);
			}
		}
		if (model.getServerLocation().getId() == null) {
			SimpleLocationModel serverLoc = daoProvider.getSimpleLocationDAO().insert(model.getServerLocation());
			if (serverLoc == null || serverLoc.getId() == null) {
				throw new RuntimeException("Cannot insert server location for ping result.");
			} else {
				model.setServerLocation(serverLoc);
			}
		}
		return super.insert(model);
	}

	@Override
	protected Record convert(PingResultModel model) {
		return new PingRecord(model.getId(), 
				model.getDevice().getId(), 
				model.getConnectionInfo().getId(), 
				model.getServerLocation().getId(), 
				safe(model.getStartTime()), 
				model.getUri(), 
				model.getPacketLoss(), 
				model.getMinLatency(), 
				model.getAvgLatency(), 
				model.getMaxLatency());
	}

	@Override
	public PingResultModel convert(Record rec) {
		return rec == null ? null : PingResultModel.builder()
				.avgLatency(rec.getValue(p.AVG_LATENCY))
				.connectionInfo(daoProvider.getConnectionInfoDAO().convert(rec))
				.device(daoProvider.getDeviceDAO().convert(rec))
				.id(rec.getValue(p.ID))
				.maxLatency(rec.getValue(p.MAX_LATENCY))
				.minLatency(rec.getValue(p.MIN_LATENCY))
				.packetLoss(rec.getValue(p.PACKET_LOSS))
				.serverLocation(daoProvider.getSimpleLocationDAO().convert(rec))
				.startTime(safeToDateTime(rec.getValue(p.START_TIME)))
				.uri(rec.getValue(p.URL))
				.build();
	}

}
