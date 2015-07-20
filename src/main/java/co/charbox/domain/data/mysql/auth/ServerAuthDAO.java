package co.charbox.domain.data.mysql.auth;

import java.util.List;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.jooq.tables.ServerAuth;
import co.charbox.domain.data.jooq.tables.records.ServerAuthRecord;
import co.charbox.domain.data.mysql.CharbotJooqDao;
import co.charbox.domain.model.auth.ServerAuthModel;

import com.google.common.collect.Lists;

@Component
public class ServerAuthDAO extends CharbotJooqDao<ServerAuthModel> {

	public static final String ALIAS = "sa";
	
	private final ServerAuth sa = ServerAuth.SERVER_AUTH.as(ALIAS);
	private final List<Field<?>> fields = Lists.newArrayList(sa.fields());
	
	@Override
	protected Table<?> getTable() {
		return sa;
	}

	@Override
	protected Table<?> getRawTable() {
		return ServerAuth.SERVER_AUTH;
	}

	@Override
	protected Field<Integer> getPk() {
		return sa.ID;
	}
	
	@Override
	public List<Field<?>> getFields() {
		return fields;
	}

	public ServerAuthModel find(ServerAuthModel model) {
		return convert(getBaseQuery()
				.where(sa.SERVER_ID.eq(model.getServerId())
						.and(sa.SERVICE_NAME.eq(model.getServiceName()))
						.and(sa.KEY.eq(model.getKey())))
				.fetchOne());
	}

	@Override
	protected Record convert(ServerAuthModel model) {
		return new ServerAuthRecord(model.getId(), 
				model.getServerId(), 
				model.getServiceName(), 
				model.getKey(), 
				safeToByte(model.isActivated()));
	}

	@Override
	public ServerAuthModel convert(Record rec) {
		return rec == null ? null : ServerAuthModel.builder()
				.activated(safeToBoolean(rec.getValue(sa.ACTIVATED)))
				.id(rec.getValue(sa.ID))
				.key(rec.getValue(sa.KEY))
				.serverId(rec.getValue(sa.SERVER_ID))
				.serviceName(rec.getValue(sa.SERVICE_NAME))
				.build();
	}

}
