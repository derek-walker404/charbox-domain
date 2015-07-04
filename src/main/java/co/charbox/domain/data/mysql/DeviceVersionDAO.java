package co.charbox.domain.data.mysql;

import java.util.List;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.SelectWhereStep;
import org.jooq.Table;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.jooq.tables.Versions;
import co.charbox.domain.data.jooq.tables.records.VersionsRecord;
import co.charbox.domain.model.DeviceVersionModel;

import com.google.common.collect.Lists;
import com.tpofof.core.data.dao.context.SimpleSearchContext;
import com.tpofof.core.data.dao.jdbc.AbstractSimpleJooqDAO;

@Component
public class DeviceVersionDAO extends AbstractSimpleJooqDAO<DeviceVersionModel, Integer, SimpleSearchContext> {

	public static final String ALIAS = "v";
	
	private final Versions v = Versions.VERSIONS.as(ALIAS);
	private final List<Field<?>> fields = Lists.newArrayList(v.fields());
	
	@Override
	protected Table<?> getTable() {
		return v;
	}
	
	@Override
	protected Table<?> getRawTable() {
		return Versions.VERSIONS;
	}

	@Override
	protected Field<Integer> getPk() {
		return v.ID;
	}

	@Override
	public List<Field<?>> getFields() {
		return fields;
	}

	@Override
	protected SelectWhereStep<Record> getBaseQuery() {
		return db().select(getTable().fields()).from(getTable());
	}

	@Override
	protected Record convert(DeviceVersionModel model) {
		return new VersionsRecord(model.getId(), model.getVersion(), model.getVersionSort(), model.getInstallScriptUrl());
	}

	@Override
	public DeviceVersionModel convert(Record rec) {
		return DeviceVersionModel.builder()
				.id(rec.getValue(v.ID))
				.installScriptUrl(rec.getValue(v.INSTALL_SCRIPT_URL))
				.version(rec.getValue(v.VERSION))
				.versionSort(rec.getValue(v.SORT))
				.build();
	}
}
