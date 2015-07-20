package co.charbox.domain.data.mysql;

import java.util.List;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.jooq.tables.Connection;
import co.charbox.domain.data.jooq.tables.records.ConnectionRecord;
import co.charbox.domain.model.mm.ConnectionModel;

import com.google.common.collect.Lists;

@Component
public class ConnectionDAO extends CharbotJooqDao<ConnectionModel> {

	public static final String ALIAS = "conn";
	
	private final Connection c = Connection.CONNECTION.as(ALIAS);
	private final List<Field<?>> fields = Lists.newArrayList(c.fields());
	
	@Override
	protected Table<?> getTable() {
		return c;
	}

	@Override
	protected Table<?> getRawTable() {
		return Connection.CONNECTION;
	}

	@Override
	protected Field<Integer> getPk() {
		return c.ID;
	}
	
	@Override
	public List<Field<?>> getFields() {
		return fields;
	}

	@Override
	protected Record convert(ConnectionModel model) {
		return new ConnectionRecord(model.getId(), model.getIsp(), model.getIp(), model.getExpectedSpeed());
	}

	@Override
	public ConnectionModel convert(Record rec) {
		return rec == null ? null : ConnectionModel.builder()
				.id(rec.getValue(c.ID))
				.isp(rec.getValue(c.ISP))
				.ip(rec.getValue(c.IP))
				.expectedSpeed(rec.getValue(c.EXP_SPEED))
				.build();
	}

}
