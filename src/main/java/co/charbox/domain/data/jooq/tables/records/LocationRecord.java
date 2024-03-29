/**
 * This class is generated by jOOQ
 */
package co.charbox.domain.data.jooq.tables.records;


import co.charbox.domain.data.jooq.tables.Location;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


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
public class LocationRecord extends UpdatableRecordImpl<LocationRecord> implements Record9<Integer, String, String, String, String, String, Double, Double, String> {

	private static final long serialVersionUID = -504860312;

	/**
	 * Setter for <code>charbot_0_1_0.location.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.location.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>charbot_0_1_0.location.continent</code>.
	 */
	public void setContinent(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.location.continent</code>.
	 */
	public String getContinent() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>charbot_0_1_0.location.country</code>.
	 */
	public void setCountry(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.location.country</code>.
	 */
	public String getCountry() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>charbot_0_1_0.location.city</code>.
	 */
	public void setCity(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.location.city</code>.
	 */
	public String getCity() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>charbot_0_1_0.location.subdivision</code>.
	 */
	public void setSubdivision(String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.location.subdivision</code>.
	 */
	public String getSubdivision() {
		return (String) getValue(4);
	}

	/**
	 * Setter for <code>charbot_0_1_0.location.zip</code>.
	 */
	public void setZip(String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.location.zip</code>.
	 */
	public String getZip() {
		return (String) getValue(5);
	}

	/**
	 * Setter for <code>charbot_0_1_0.location.lat</code>.
	 */
	public void setLat(Double value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.location.lat</code>.
	 */
	public Double getLat() {
		return (Double) getValue(6);
	}

	/**
	 * Setter for <code>charbot_0_1_0.location.lon</code>.
	 */
	public void setLon(Double value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.location.lon</code>.
	 */
	public Double getLon() {
		return (Double) getValue(7);
	}

	/**
	 * Setter for <code>charbot_0_1_0.location.timezone</code>.
	 */
	public void setTimezone(String value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.location.timezone</code>.
	 */
	public String getTimezone() {
		return (String) getValue(8);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record9 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row9<Integer, String, String, String, String, String, Double, Double, String> fieldsRow() {
		return (Row9) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row9<Integer, String, String, String, String, String, Double, Double, String> valuesRow() {
		return (Row9) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Location.LOCATION.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Location.LOCATION.CONTINENT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return Location.LOCATION.COUNTRY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return Location.LOCATION.CITY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field5() {
		return Location.LOCATION.SUBDIVISION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field6() {
		return Location.LOCATION.ZIP;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Double> field7() {
		return Location.LOCATION.LAT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Double> field8() {
		return Location.LOCATION.LON;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field9() {
		return Location.LOCATION.TIMEZONE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getContinent();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getCountry();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getCity();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value5() {
		return getSubdivision();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value6() {
		return getZip();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double value7() {
		return getLat();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double value8() {
		return getLon();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value9() {
		return getTimezone();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationRecord value2(String value) {
		setContinent(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationRecord value3(String value) {
		setCountry(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationRecord value4(String value) {
		setCity(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationRecord value5(String value) {
		setSubdivision(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationRecord value6(String value) {
		setZip(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationRecord value7(Double value) {
		setLat(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationRecord value8(Double value) {
		setLon(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationRecord value9(String value) {
		setTimezone(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LocationRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6, Double value7, Double value8, String value9) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		value9(value9);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached LocationRecord
	 */
	public LocationRecord() {
		super(Location.LOCATION);
	}

	/**
	 * Create a detached, initialised LocationRecord
	 */
	public LocationRecord(Integer id, String continent, String country, String city, String subdivision, String zip, Double lat, Double lon, String timezone) {
		super(Location.LOCATION);

		setValue(0, id);
		setValue(1, continent);
		setValue(2, country);
		setValue(3, city);
		setValue(4, subdivision);
		setValue(5, zip);
		setValue(6, lat);
		setValue(7, lon);
		setValue(8, timezone);
	}
}
