/**
 * This class is generated by jOOQ
 */
package co.charbox.domain.data.jooq.tables;


import co.charbox.domain.data.jooq.Charbot_0_1_0;
import co.charbox.domain.data.jooq.Keys;
import co.charbox.domain.data.jooq.tables.records.LocationRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Location extends TableImpl<LocationRecord> {

	private static final long serialVersionUID = 134123309;

	/**
	 * The reference instance of <code>charbot_0_1_0.location</code>
	 */
	public static final Location LOCATION = new Location();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<LocationRecord> getRecordType() {
		return LocationRecord.class;
	}

	/**
	 * The column <code>charbot_0_1_0.location.id</code>.
	 */
	public final TableField<LocationRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>charbot_0_1_0.location.continent</code>.
	 */
	public final TableField<LocationRecord, String> CONTINENT = createField("continent", org.jooq.impl.SQLDataType.VARCHAR.length(45), this, "");

	/**
	 * The column <code>charbot_0_1_0.location.country</code>.
	 */
	public final TableField<LocationRecord, String> COUNTRY = createField("country", org.jooq.impl.SQLDataType.VARCHAR.length(45), this, "");

	/**
	 * The column <code>charbot_0_1_0.location.city</code>.
	 */
	public final TableField<LocationRecord, String> CITY = createField("city", org.jooq.impl.SQLDataType.VARCHAR.length(45), this, "");

	/**
	 * The column <code>charbot_0_1_0.location.subdivision</code>.
	 */
	public final TableField<LocationRecord, String> SUBDIVISION = createField("subdivision", org.jooq.impl.SQLDataType.VARCHAR.length(45), this, "");

	/**
	 * The column <code>charbot_0_1_0.location.zip</code>.
	 */
	public final TableField<LocationRecord, String> ZIP = createField("zip", org.jooq.impl.SQLDataType.VARCHAR.length(45), this, "");

	/**
	 * The column <code>charbot_0_1_0.location.lat</code>.
	 */
	public final TableField<LocationRecord, Double> LAT = createField("lat", org.jooq.impl.SQLDataType.FLOAT, this, "");

	/**
	 * The column <code>charbot_0_1_0.location.lon</code>.
	 */
	public final TableField<LocationRecord, Double> LON = createField("lon", org.jooq.impl.SQLDataType.FLOAT, this, "");

	/**
	 * The column <code>charbot_0_1_0.location.timezone</code>.
	 */
	public final TableField<LocationRecord, String> TIMEZONE = createField("timezone", org.jooq.impl.SQLDataType.VARCHAR.length(45), this, "");

	/**
	 * Create a <code>charbot_0_1_0.location</code> table reference
	 */
	public Location() {
		this("location", null);
	}

	/**
	 * Create an aliased <code>charbot_0_1_0.location</code> table reference
	 */
	public Location(String alias) {
		this(alias, LOCATION);
	}

	private Location(String alias, Table<LocationRecord> aliased) {
		this(alias, aliased, null);
	}

	private Location(String alias, Table<LocationRecord> aliased, Field<?>[] parameters) {
		super(alias, Charbot_0_1_0.CHARBOT_0_1_0, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<LocationRecord, Integer> getIdentity() {
		return Keys.IDENTITY_LOCATION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<LocationRecord> getPrimaryKey() {
		return Keys.KEY_LOCATION_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<LocationRecord>> getKeys() {
		return Arrays.<UniqueKey<LocationRecord>>asList(Keys.KEY_LOCATION_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Location as(String alias) {
		return new Location(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Location rename(String name) {
		return new Location(name, null);
	}
}
