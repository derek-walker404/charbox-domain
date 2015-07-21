package co.charbox.domain.data.mysql;

import java.util.List;
import java.util.Set;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.SelectConditionStep;
import org.jooq.Table;

import co.charbox.domain.data.jooq.tables.Udev;
import co.charbox.domain.data.jooq.tables.records.UdevRecord;
import co.charbox.domain.model.RoleModel;
import co.charbox.domain.model.UserDeviceModel;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class UserDeviceDAO extends CharbotJooqDao<UserDeviceModel> {

	public static final String ALIAS = "udev";
	
	private final Udev udev = Udev.UDEV.as(ALIAS);
	private final List<Field<?>> fields = Lists.newArrayList(udev.fields());
	
	@Override
	protected Table<?> getTable() {
		return udev;
	}

	@Override
	protected Table<?> getRawTable() {
		return Udev.UDEV;
	}

	@Override
	protected Field<Integer> getPk() {
		return udev.ID;
	}

	@Override
	public List<Field<?>> getFields() {
		return fields;
	}
	
	public Set<RoleModel> getRolesByUserId(Integer userId) {
		SelectConditionStep<Record> sql = getBaseQuery().where(udev.USER_ID.eq(userId));
		List<UserDeviceModel> ud = convert(sql.fetch());
		Set<RoleModel> roles = Sets.newHashSet();
		for (UserDeviceModel m : ud) {
			roles.add(RoleModel.getDeviceRole(m.getDeviceId()));
		}
		return roles;
	}

	@Override
	protected Record convert(UserDeviceModel model) {
		return new UdevRecord(model.getId(), model.getDeviceId(), model.getUserId());
	}

	@Override
	public UserDeviceModel convert(Record rec) {
		return UserDeviceModel.builder()
				.deviceId(rec.getValue(udev.DEVICE_ID))
				.id(rec.getValue(udev.ID))
				.userId(rec.getValue(udev.USER_ID))
				.build();
	}
}
