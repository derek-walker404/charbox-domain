package co.charbox.domain.data.mysql;

import java.util.List;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.springframework.beans.factory.annotation.Autowired;

import co.charbox.domain.data.jooq.tables.Users;
import co.charbox.domain.data.jooq.tables.records.UsersRecord;
import co.charbox.domain.model.UserModel;

import com.google.common.collect.Lists;

public class UserDAO extends CharbotJooqDao<UserModel> {

	public static final String ALIAS = "u";
	
	@Autowired private UserDeviceDAO udevDao;
	
	private final Users u = Users.USERS.as(ALIAS);
	private final List<Field<?>> fields = Lists.newArrayList(u.fields());
	
	@Override
	protected Table<?> getTable() {
		return u;
	}

	@Override
	protected Table<?> getRawTable() {
		return Users.USERS;
	}

	@Override
	protected Field<Integer> getPk() {
		return u.ID;
	}

	@Override
	public List<Field<?>> getFields() {
		return fields;
	}
	
	@Override
	protected Record convert(UserModel model) {
		return new UsersRecord(model.getId(), model.getEmail(), model.getPasswordHash(), model.getName());
	}

	@Override
	public UserModel convert(Record rec) {
		return convert(rec, true);
	}

	public UserModel convert(Record rec, boolean setRoles) {
		
		Integer id = rec.getValue(u.ID);
		return rec == null ? null : UserModel.builder()
				.id(id)
				.email(rec.getValue(u.EMAIL))
				.name(rec.getValue(u.NAME))
				.passwordHash(rec.getValue(u.PASS_HASH))
				.roles(udevDao.getRolesByUserId(id))
				.build();
	}
}
