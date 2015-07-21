package co.charbox.domain.data.mysql;

import java.util.List;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.jooq.tables.Location;
import co.charbox.domain.data.jooq.tables.records.LocationRecord;
import co.charbox.domain.model.mm.LocationModel;

import com.google.common.collect.Lists;

@Component
public class LocationDAO extends CharbotJooqDao<LocationModel> {

	public static final String ALIAS = "loc";
	
	private final Location loc = Location.LOCATION.as(ALIAS);
	private final List<Field<?>> fields = Lists.newArrayList(loc.fields());
	
	@Override
	protected Table<?> getTable() {
		return loc;
	}

	@Override
	protected Table<?> getRawTable() {
		return Location.LOCATION;
	}

	@Override
	protected Field<Integer> getPk() {
		return loc.ID;
	}

	@Override
	public List<Field<?>> getFields() {
		return fields;
	}

	@Override
	protected Record convert(LocationModel model) {
		return new LocationRecord(model.getId(), 
				model.getContinent(), 
				model.getCountry(), 
				model.getCity(), 
				model.getSubdivision(), 
				model.getZip(), 
				model.getLat(), 
				model.getLon(), 
				model.getTimeZone());
	}

	@Override
	public LocationModel convert(Record rec) {
		return rec == null ? null : LocationModel.builder()
				.id(rec.getValue(loc.ID))
				.continent((rec.getValue(loc.CONTINENT)))
				.country(rec.getValue(loc.COUNTRY))
				.city(rec.getValue(loc.CITY))
				.subdivision(rec.getValue(loc.SUBDIVISION))
				.zip(rec.getValue(loc.ZIP))
				.lat(rec.getValue(loc.LAT))
				.lon(rec.getValue(loc.LON))
				.timeZone(rec.getValue(loc.TIMEZONE))
				.build();
	}

}
