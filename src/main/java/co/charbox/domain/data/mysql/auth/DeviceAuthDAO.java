package co.charbox.domain.data.mysql.auth;

import java.util.List;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.jooq.tables.DeviceAuth;
import co.charbox.domain.data.jooq.tables.records.DeviceAuthRecord;
import co.charbox.domain.data.mysql.CharbotJooqDao;
import co.charbox.domain.model.auth.DeviceAuthModel;

import com.google.common.collect.Lists;

@Component
public class DeviceAuthDAO extends CharbotJooqDao<DeviceAuthModel> {

	public static final String ALIAS = "da";
	
	private final DeviceAuth da = DeviceAuth.DEVICE_AUTH.as(ALIAS);
	private final List<Field<?>> fields = Lists.newArrayList(da.fields());
	
	@Override
	protected Table<?> getTable() {
		return da;
	}

	@Override
	protected Table<?> getRawTable() {
		return DeviceAuth.DEVICE_AUTH;
	}

	@Override
	protected Field<Integer> getPk() {
		return da.ID;
	}
	
	@Override
	public List<Field<?>> getFields() {
		return fields;
	}

	public DeviceAuthModel find(DeviceAuthModel model) {
		return convert(getBaseQuery()
				.where(da.DEVICE_ID.eq(model.getDeviceId())
						.and(da.KEY.eq(model.getKey())))
				.fetchOne());
	}

	@Override
	protected Record convert(DeviceAuthModel model) {
		return new DeviceAuthRecord(model.getId(), 
				model.getDeviceId(), 
				model.getKey(), 
				safeToByte(model.isActivated()));
	}

	@Override
	public DeviceAuthModel convert(Record rec) {
		return rec == null ? null : DeviceAuthModel.builder()
				.activated(safeToBoolean(rec.getValue(da.ACTIVATED)))
				.deviceId(rec.getValue(da.DEVICE_ID))
				.id(rec.getValue(da.ID))
				.key(rec.getValue(da.KEY))
				.build();
	}
}
