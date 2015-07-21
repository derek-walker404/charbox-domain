package co.charbox.domain.data.mysql;

import java.util.List;
import java.util.Map;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.jooq.tables.Versions;
import co.charbox.domain.data.jooq.tables.records.VersionsRecord;
import co.charbox.domain.model.DeviceVersionModel;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Component
public class DeviceVersionDAO extends CharbotJooqDao<DeviceVersionModel> {

	public static final String ALIAS = "v";
	
	private final Versions v = Versions.VERSIONS.as(ALIAS);
	private final List<Field<?>> fields = Lists.newArrayList(v.fields());
	private Map<String, Field<?>> sortMapping;
	
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
	public Map<String, Field<?>> getSortMapping() {
		if (sortMapping == null) {
			sortMapping = Maps.newHashMap();
			sortMapping.put("versionSort", v.SORT);
		}
		return sortMapping;
	}

	@Override
	public List<Field<?>> getFields() {
		return fields;
	}

	@Override
	protected Record convert(DeviceVersionModel model) {
		return new VersionsRecord(model.getId(), model.getVersion(), model.getVersionSort(), model.getInstallScriptUrl());
	}

	@Override
	public DeviceVersionModel convert(Record rec) {
		return rec == null ? null : DeviceVersionModel.builder()
				.id(rec.getValue(v.ID))
				.installScriptUrl(rec.getValue(v.INSTALL_SCRIPT_URL))
				.version(rec.getValue(v.VERSION))
				.versionSort(rec.getValue(v.SORT))
				.build();
	}
}
