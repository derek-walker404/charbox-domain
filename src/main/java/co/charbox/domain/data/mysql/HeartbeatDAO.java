package co.charbox.domain.data.mysql;

import java.util.List;

import org.elasticsearch.common.collect.Lists;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.SelectWhereStep;
import org.jooq.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.jooq.tables.Devices;
import co.charbox.domain.data.jooq.tables.Heartbeat;
import co.charbox.domain.data.jooq.tables.records.HeartbeatRecord;
import co.charbox.domain.model.HeartbeatModel;

import com.tpofof.core.data.dao.context.SimpleSearchContext;
import com.tpofof.core.data.dao.jdbc.AbstractSimpleJooqDAO;

@Component
public class HeartbeatDAO extends AbstractSimpleJooqDAO<HeartbeatModel, Integer, SimpleSearchContext> {

	public static final String ALIAS = "hb";
	
	@Autowired private DaoProvider daoProvider;
	
	private final Heartbeat hb = Heartbeat.HEARTBEAT.as(ALIAS);
	private final Devices d = Devices.DEVICES.as(DeviceDAO.ALIAS);
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
		}
		return fields;
	}

	@Override
	protected SelectWhereStep<Record> getBaseQuery() {
		return db().select(fields).from(hb)
				.join(d).on(d.ID.eq(hb.DEVICE_ID));
	}
	
	public HeartbeatModel findByDeviceId(Integer deviceId) {
		return convert(getBaseQuery().where(hb.DEVICE_ID.eq(deviceId)).fetchOne());
	}

	@Override
	protected Record convert(HeartbeatModel model) {
		return new HeartbeatRecord(model.getId(), model.getDevice().getId(), safe(model.getTime()));
	}

	@Override
	public HeartbeatModel convert(Record rec) {
		return rec == null ? null : HeartbeatModel.builder()
				.id(rec.getValue(hb.ID))
				.time(safeToDateTime(rec.getValue(hb.TIME)))
				.device(daoProvider.getDeviceDAO().convert(rec))
				.build();
	}
}
