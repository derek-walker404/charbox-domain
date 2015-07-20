package co.charbox.domain.data.mysql;

import java.util.List;
import java.util.Map;

import org.elasticsearch.common.collect.Lists;
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
import co.charbox.domain.data.jooq.tables.SimpleLocation;
import co.charbox.domain.data.jooq.tables.Sst;
import co.charbox.domain.data.jooq.tables.records.SstRecord;
import co.charbox.domain.model.SstResultsModel;
import co.charbox.domain.model.mm.ConnectionInfoModel;
import co.charbox.domain.model.mm.SimpleLocationModel;

import com.google.common.collect.Maps;
import com.tpofof.core.data.dao.ResultsSet;
import com.tpofof.core.data.dao.context.PrincipalSearchContext;

@Component
public class SstResultsDAO extends CharbotJooqDao<SstResultsModel> {

	public static final String ALIAS = "sst";
	
	private final Sst sst = Sst.SST.as(ALIAS);
	private final Devices d = Devices.DEVICES.as(DeviceDAO.ALIAS);
	private final ConnectionInfo ci = ConnectionInfo.CONNECTION_INFO.as(ConnectionInfoDAO.ALIAS);
	private final Connection c = Connection.CONNECTION.as(ConnectionDAO.ALIAS);
	private final Location loc = Location.LOCATION.as(LocationDAO.ALIAS);
	private final SimpleLocation sl = SimpleLocation.SIMPLE_LOCATION.as(SimpleLocationDAO.ALIAS);
	
	@Autowired private DaoProvider daoProvider;
	private List<Field<?>> fields;
	private Map<String, Field<?>> sortMapping;
	
	@Override
	protected Table<?> getTable() {
		return sst;
	}

	@Override
	protected Table<?> getRawTable() {
		return Sst.SST;
	}

	@Override
	protected Field<Integer> getPk() {
		return sst.ID;
	}
	
	@Override
	public Map<String, Field<?>> getSortMapping() {
		if (sortMapping == null) {
			sortMapping = Maps.newHashMap();
			sortMapping.put("startTime", sst.START_TIME);
			sortMapping.put("downloadSpeed", sst.DOWN_SPEED);
			sortMapping.put("uploadSpeed", sst.UP_SPEED);
			sortMapping.put("pingDuration", sst.PING_DURATION);
		}
		return sortMapping;
	}

	@Override
	protected SelectWhereStep<Record> getBaseQuery() {
		return db().select(getFields()).from(sst)
				.join(d).on(d.ID.eq(sst.DEVICE_ID))
				.join(ci).on(ci.ID.eq(sst.DEVICE_CONN_ID))
				.join(c).on(c.ID.eq(ci.CONNECTION_ID))
				.join(loc).on(loc.ID.eq(ci.LOCATION_ID))
				.join(sl).on(sl.ID.eq(sst.SERVER_LOC_ID));
	}
	
	@Override
	public List<Field<?>> getFields() {
		if (fields == null) {
			fields = Lists.newArrayList(sst.fields());
			fields.addAll(daoProvider.getDeviceDAO().getFields());
			fields.addAll(daoProvider.getConnectionInfoDAO().getFields());
			fields.addAll(daoProvider.getSimpleLocationDAO().getFields());
		}
		return fields;
	}

	public ResultsSet<SstResultsModel> findByDeviceId(PrincipalSearchContext context, Integer deviceId) {
		SelectConditionStep<Record> sql = getBaseQuery().where(sst.DEVICE_ID.eq(deviceId));
		addSearchMeta(sql, context, false);
		return convert(sql.fetch(), context);
	}
	
	@Override
	public SstResultsModel insert(SstResultsModel model) {
		if (model.getDeviceInfo().getId() == null) {
			ConnectionInfoModel connInfo = daoProvider.getConnectionInfoDAO().insert(model.getDeviceInfo());
			if (connInfo == null || connInfo.getId() == null) {
				throw new RuntimeException("Cannot insert connection info for sst result.");
			} else {
				model.setDeviceInfo(connInfo);
			}
		}
		if (model.getServerLocation().getId() == null) {
			SimpleLocationModel serverLoc = daoProvider.getSimpleLocationDAO().insert(model.getServerLocation());
			if (serverLoc == null || serverLoc.getId() == null) {
				throw new RuntimeException("Cannot insert server location info for sst result.");
			} else {
				model.setServerLocation(serverLoc);
			}
		}
		return super.insert(model);
	}
	
	@Override
	protected Record convert(SstResultsModel model) {
		return model == null ? null : new SstRecord(model.getId(),
				model.getDevice().getId(), 
				model.getDeviceToken(), 
				safe(model.getStartTime()), 
				model.getDownloadSize(), 
				model.getDownloadDuration(), 
				model.getDownloadSpeed(), 
				model.getUploadSize(), 
				model.getUploadDuration(), 
				model.getUploadSpeed(), 
				model.getPingDuration(), 
				model.getDeviceInfo().getId(), 
				model.getServerLocation().getId());
	}

	@Override
	public SstResultsModel convert(Record rec) {
		return rec == null ? null : SstResultsModel.builder()
				.device(daoProvider.getDeviceDAO().convert(rec))
				.deviceInfo(daoProvider.getConnectionInfoDAO().convert(rec))
				.deviceToken(rec.getValue(sst.TOKEN))
				.downloadDuration(rec.getValue(sst.DOWN_DURATION))
				.downloadSize(rec.getValue(sst.DOWN_SIZE))
				.downloadSpeed(rec.getValue(sst.DOWN_SPEED))
				.id(rec.getValue(sst.ID))
				.pingDuration(rec.getValue(sst.PING_DURATION))
				.serverLocation(daoProvider.getSimpleLocationDAO().convert(rec))
				.startTime(safeToDateTime(rec.getValue(sst.START_TIME)))
				.uploadDuration(rec.getValue(sst.UP_DURATION))
				.uploadSize(rec.getValue(sst.UP_SIZE))
				.uploadSpeed(rec.getValue(sst.UP_SPEED))
				.build();
	}
}
