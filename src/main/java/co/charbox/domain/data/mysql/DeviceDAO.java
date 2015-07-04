package co.charbox.domain.data.mysql;

import java.util.List;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.SelectWhereStep;
import org.jooq.Table;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.jooq.tables.Devices;
import co.charbox.domain.data.jooq.tables.records.DevicesRecord;
import co.charbox.domain.model.DeviceModel;

import com.google.common.collect.Lists;
import com.tpofof.core.data.dao.context.SimpleSearchContext;
import com.tpofof.core.data.dao.jdbc.AbstractSimpleJooqDAO;

@Component
public class DeviceDAO extends AbstractSimpleJooqDAO<DeviceModel, Integer, SimpleSearchContext> {

	public static final String ALIAS = "d";
	
	private final Devices d = Devices.DEVICES.as(ALIAS);
	private final List<Field<?>> fields = Lists.newArrayList(d.fields());

	@Override
	protected Table<?> getTable() {
		return d;
	}
	
	@Override
	protected Table<?> getRawTable() {
		return Devices.DEVICES;
	}

	@Override
	protected Field<Integer> getPk() {
		return d.ID;
	}
	
	@Override
	public List<Field<?>> getFields() {
		return fields;
	}
	
	@Override
	protected SelectWhereStep<Record> getBaseQuery() {
		return db().select(getFields()).from(getTable());
	}
	
	protected DevicesRecord convert(DeviceModel model) {
		return new DevicesRecord(model.getId(), model.getName());
	}
	
	public DeviceModel convert(Record rec) {
		return rec == null 
				? null 
				: DeviceModel.builder()
					.id(rec.getValue(d.ID))
					.name(rec.getValue(d.NAME))
					.build();
	}
}
