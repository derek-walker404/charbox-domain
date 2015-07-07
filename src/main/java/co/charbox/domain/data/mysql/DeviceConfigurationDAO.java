package co.charbox.domain.data.mysql;

import java.util.List;
import java.util.Map;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.SelectWhereStep;
import org.jooq.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.jooq.tables.DeviceConfigs;
import co.charbox.domain.data.jooq.tables.Devices;
import co.charbox.domain.data.jooq.tables.records.DeviceConfigsRecord;
import co.charbox.domain.model.DeviceConfigurationModel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;
import com.tpofof.core.data.dao.context.SimpleSearchContext;
import com.tpofof.core.data.dao.jdbc.AbstractSimpleJooqDAO;
import com.tpofof.core.utils.json.JsonUtils;

@Component
public class DeviceConfigurationDAO extends AbstractSimpleJooqDAO<DeviceConfigurationModel, Integer, SimpleSearchContext> {

	public static final String ALIAS = "dc";
	
	@Autowired private JsonUtils json;
	@Autowired private DaoProvider daoProvider;
	
	private final DeviceConfigs dc = DeviceConfigs.DEVICE_CONFIGS.as(ALIAS);
	private final Devices d = Devices.DEVICES.as(DeviceDAO.ALIAS);
	
	private List<Field<?>> fields;
	
	@Override
	protected Table<?> getTable() {
		return dc;
	}

	@Override
	protected Table<?> getRawTable() {
		return DeviceConfigs.DEVICE_CONFIGS;
	}

	@Override
	protected Field<Integer> getPk() {
		return dc.ID;
	}
	
	@Override
	public List<Field<?>> getFields() {
		if (fields == null) {
			fields = Lists.newArrayList(dc.fields());
			fields.addAll(daoProvider.getDeviceDAO().getFields());
		}
		return fields;
	}
	
	@Override
	protected SelectWhereStep<Record> getBaseQuery() {
		return db().select(getFields()).from(dc)
				.join(d).on(d.ID.eq(dc.DEVICE_ID));
	}
	
	public DeviceConfigurationModel findByDeviceId(Integer deviceId) {
		return convert(getBaseQuery()
				.where(dc.DEVICE_ID.eq(deviceId))
				.fetchOne());
	}
	
	public DeviceConfigurationModel updateRegistered(DeviceConfigurationModel model) {
		db().update(getTable())
				.set(dc.REGISTERED, safeToByte(model.isRegistered()))
				.where(dc.ID.eq(model.getId()))
				.execute();
		return find(model.getId());
	}

	@Override
	protected DeviceConfigsRecord convert(DeviceConfigurationModel model) {
		byte[] schedules = json.toJson(model.getSchedules()).getBytes();
		byte registered = (byte)(model.isRegistered() ? 1 : 0);
		return new DeviceConfigsRecord(model.getId(), model.getDevice().getId(), model.getVersion(), registered, schedules);
	}

	public DeviceConfigurationModel convert(Record rec) {
		return rec == null ? null : DeviceConfigurationModel.builder()
				.id(rec.getValue(dc.ID))
				.registered(safeToBoolean(rec.getValue(dc.REGISTERED)))
				.schedules(json.fromJson(new String(rec.getValue(dc.SCHEDULES)), new TypeReference<Map<String, String>>() { }))
				.version(rec.getValue(dc.VERSION))
				.device(daoProvider.getDeviceDAO().convert(rec))
				.build();
	}
}
