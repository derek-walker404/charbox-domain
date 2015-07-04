/**
 * This class is generated by jOOQ
 */
package co.charbox.domain.data.jooq.tables.records;


import co.charbox.domain.data.jooq.tables.Sst;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record13;
import org.jooq.Row;
import org.jooq.Row13;
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
public class SstRecord extends UpdatableRecordImpl<SstRecord> implements Record13<Integer, Integer, String, Timestamp, Long, Integer, Double, Long, Integer, Double, Integer, Integer, Integer> {

	private static final long serialVersionUID = -2043746481;

	/**
	 * Setter for <code>charbot_0_1_0.sst.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.sst.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>charbot_0_1_0.sst.device_id</code>.
	 */
	public void setDeviceId(Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.sst.device_id</code>.
	 */
	public Integer getDeviceId() {
		return (Integer) getValue(1);
	}

	/**
	 * Setter for <code>charbot_0_1_0.sst.token</code>.
	 */
	public void setToken(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.sst.token</code>.
	 */
	public String getToken() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>charbot_0_1_0.sst.start_time</code>.
	 */
	public void setStartTime(Timestamp value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.sst.start_time</code>.
	 */
	public Timestamp getStartTime() {
		return (Timestamp) getValue(3);
	}

	/**
	 * Setter for <code>charbot_0_1_0.sst.down_size</code>.
	 */
	public void setDownSize(Long value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.sst.down_size</code>.
	 */
	public Long getDownSize() {
		return (Long) getValue(4);
	}

	/**
	 * Setter for <code>charbot_0_1_0.sst.down_duration</code>.
	 */
	public void setDownDuration(Integer value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.sst.down_duration</code>.
	 */
	public Integer getDownDuration() {
		return (Integer) getValue(5);
	}

	/**
	 * Setter for <code>charbot_0_1_0.sst.down_speed</code>.
	 */
	public void setDownSpeed(Double value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.sst.down_speed</code>.
	 */
	public Double getDownSpeed() {
		return (Double) getValue(6);
	}

	/**
	 * Setter for <code>charbot_0_1_0.sst.up_size</code>.
	 */
	public void setUpSize(Long value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.sst.up_size</code>.
	 */
	public Long getUpSize() {
		return (Long) getValue(7);
	}

	/**
	 * Setter for <code>charbot_0_1_0.sst.up_duration</code>.
	 */
	public void setUpDuration(Integer value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.sst.up_duration</code>.
	 */
	public Integer getUpDuration() {
		return (Integer) getValue(8);
	}

	/**
	 * Setter for <code>charbot_0_1_0.sst.up_speed</code>.
	 */
	public void setUpSpeed(Double value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.sst.up_speed</code>.
	 */
	public Double getUpSpeed() {
		return (Double) getValue(9);
	}

	/**
	 * Setter for <code>charbot_0_1_0.sst.ping_duration</code>.
	 */
	public void setPingDuration(Integer value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.sst.ping_duration</code>.
	 */
	public Integer getPingDuration() {
		return (Integer) getValue(10);
	}

	/**
	 * Setter for <code>charbot_0_1_0.sst.device_conn_id</code>.
	 */
	public void setDeviceConnId(Integer value) {
		setValue(11, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.sst.device_conn_id</code>.
	 */
	public Integer getDeviceConnId() {
		return (Integer) getValue(11);
	}

	/**
	 * Setter for <code>charbot_0_1_0.sst.server_loc_id</code>.
	 */
	public void setServerLocId(Integer value) {
		setValue(12, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.sst.server_loc_id</code>.
	 */
	public Integer getServerLocId() {
		return (Integer) getValue(12);
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
	// Record13 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row13<Integer, Integer, String, Timestamp, Long, Integer, Double, Long, Integer, Double, Integer, Integer, Integer> fieldsRow() {
		return (Row13) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row13<Integer, Integer, String, Timestamp, Long, Integer, Double, Long, Integer, Double, Integer, Integer, Integer> valuesRow() {
		return (Row13) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Sst.SST.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return Sst.SST.DEVICE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return Sst.SST.TOKEN;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field4() {
		return Sst.SST.START_TIME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field5() {
		return Sst.SST.DOWN_SIZE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field6() {
		return Sst.SST.DOWN_DURATION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Double> field7() {
		return Sst.SST.DOWN_SPEED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field8() {
		return Sst.SST.UP_SIZE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field9() {
		return Sst.SST.UP_DURATION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Double> field10() {
		return Sst.SST.UP_SPEED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field11() {
		return Sst.SST.PING_DURATION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field12() {
		return Sst.SST.DEVICE_CONN_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field13() {
		return Sst.SST.SERVER_LOC_ID;
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
	public Integer value2() {
		return getDeviceId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getToken();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value4() {
		return getStartTime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long value5() {
		return getDownSize();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value6() {
		return getDownDuration();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double value7() {
		return getDownSpeed();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long value8() {
		return getUpSize();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value9() {
		return getUpDuration();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double value10() {
		return getUpSpeed();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value11() {
		return getPingDuration();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value12() {
		return getDeviceConnId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value13() {
		return getServerLocId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SstRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SstRecord value2(Integer value) {
		setDeviceId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SstRecord value3(String value) {
		setToken(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SstRecord value4(Timestamp value) {
		setStartTime(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SstRecord value5(Long value) {
		setDownSize(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SstRecord value6(Integer value) {
		setDownDuration(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SstRecord value7(Double value) {
		setDownSpeed(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SstRecord value8(Long value) {
		setUpSize(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SstRecord value9(Integer value) {
		setUpDuration(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SstRecord value10(Double value) {
		setUpSpeed(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SstRecord value11(Integer value) {
		setPingDuration(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SstRecord value12(Integer value) {
		setDeviceConnId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SstRecord value13(Integer value) {
		setServerLocId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SstRecord values(Integer value1, Integer value2, String value3, Timestamp value4, Long value5, Integer value6, Double value7, Long value8, Integer value9, Double value10, Integer value11, Integer value12, Integer value13) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		value9(value9);
		value10(value10);
		value11(value11);
		value12(value12);
		value13(value13);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached SstRecord
	 */
	public SstRecord() {
		super(Sst.SST);
	}

	/**
	 * Create a detached, initialised SstRecord
	 */
	public SstRecord(Integer id, Integer deviceId, String token, Timestamp startTime, Long downSize, Integer downDuration, Double downSpeed, Long upSize, Integer upDuration, Double upSpeed, Integer pingDuration, Integer deviceConnId, Integer serverLocId) {
		super(Sst.SST);

		setValue(0, id);
		setValue(1, deviceId);
		setValue(2, token);
		setValue(3, startTime);
		setValue(4, downSize);
		setValue(5, downDuration);
		setValue(6, downSpeed);
		setValue(7, upSize);
		setValue(8, upDuration);
		setValue(9, upSpeed);
		setValue(10, pingDuration);
		setValue(11, deviceConnId);
		setValue(12, serverLocId);
	}
}
