package co.charbox.domain.data.mysql;

import java.util.List;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.SelectWhereStep;
import org.jooq.Table;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.jooq.tables.SimpleLocation;
import co.charbox.domain.data.jooq.tables.records.SimpleLocationRecord;
import co.charbox.domain.model.mm.SimpleLocationModel;

import com.google.common.collect.Lists;
import com.tpofof.core.data.dao.context.SimpleSearchContext;
import com.tpofof.core.data.dao.jdbc.AbstractSimpleJooqDAO;

@Component
public class SimpleLocationDAO extends AbstractSimpleJooqDAO<SimpleLocationModel, Integer, SimpleSearchContext> {

	public static final String ALIAS = "sl";
	
	private SimpleLocation sl = SimpleLocation.SIMPLE_LOCATION.as(ALIAS);
	private final List<Field<?>> fields = Lists.newArrayList(sl.fields());
	
	@Override
	protected Table<?> getTable() {
		return sl;
	}
	
	@Override
	protected Table<?> getRawTable() {
		return SimpleLocation.SIMPLE_LOCATION;
	}

	@Override
	protected Field<Integer> getPk() {
		return sl.ID;
	}

	@Override
	public List<Field<?>> getFields() {
		return fields;
	}

	@Override
	protected SelectWhereStep<Record> getBaseQuery() {
		return db().select(sl.fields()).from(sl);
	}

	@Override
	protected Record convert(SimpleLocationModel model) {
		return new SimpleLocationRecord(model.getId(), model.getIp(), model.getLat(), model.getLon());
	}

	@Override
	public SimpleLocationModel convert(Record rec) {
		return rec == null ? null 
				: SimpleLocationModel.builder()
					.id(rec.getValue(sl.ID))
					.ip(rec.getValue(sl.IP))
					.lat(rec.getValue(sl.LAT))
					.lon(rec.getValue(sl.LON))
					.build();
	}
}
