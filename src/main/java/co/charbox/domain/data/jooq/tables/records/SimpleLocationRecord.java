/**
 * This class is generated by jOOQ
 */
package co.charbox.domain.data.jooq.tables.records;


import co.charbox.domain.data.jooq.tables.SimpleLocation;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row;
import org.jooq.Row4;
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
public class SimpleLocationRecord extends UpdatableRecordImpl<SimpleLocationRecord> implements Record4<Integer, String, Double, Double> {

	private static final long serialVersionUID = -1588597728;

	/**
	 * Setter for <code>charbot_0_1_0.simple_location.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.simple_location.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>charbot_0_1_0.simple_location.ip</code>.
	 */
	public void setIp(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.simple_location.ip</code>.
	 */
	public String getIp() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>charbot_0_1_0.simple_location.lat</code>.
	 */
	public void setLat(Double value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.simple_location.lat</code>.
	 */
	public Double getLat() {
		return (Double) getValue(2);
	}

	/**
	 * Setter for <code>charbot_0_1_0.simple_location.lon</code>.
	 */
	public void setLon(Double value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.simple_location.lon</code>.
	 */
	public Double getLon() {
		return (Double) getValue(3);
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
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, String, Double, Double> fieldsRow() {
		return (Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<Integer, String, Double, Double> valuesRow() {
		return (Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return SimpleLocation.SIMPLE_LOCATION.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return SimpleLocation.SIMPLE_LOCATION.IP;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Double> field3() {
		return SimpleLocation.SIMPLE_LOCATION.LAT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Double> field4() {
		return SimpleLocation.SIMPLE_LOCATION.LON;
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
		return getIp();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double value3() {
		return getLat();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double value4() {
		return getLon();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SimpleLocationRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SimpleLocationRecord value2(String value) {
		setIp(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SimpleLocationRecord value3(Double value) {
		setLat(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SimpleLocationRecord value4(Double value) {
		setLon(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SimpleLocationRecord values(Integer value1, String value2, Double value3, Double value4) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached SimpleLocationRecord
	 */
	public SimpleLocationRecord() {
		super(SimpleLocation.SIMPLE_LOCATION);
	}

	/**
	 * Create a detached, initialised SimpleLocationRecord
	 */
	public SimpleLocationRecord(Integer id, String ip, Double lat, Double lon) {
		super(SimpleLocation.SIMPLE_LOCATION);

		setValue(0, id);
		setValue(1, ip);
		setValue(2, lat);
		setValue(3, lon);
	}
}
