/**
 * This class is generated by jOOQ
 */
package co.charbox.domain.data.jooq.tables.records;


import co.charbox.domain.data.jooq.tables.Udev;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row;
import org.jooq.Row3;
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
public class UdevRecord extends UpdatableRecordImpl<UdevRecord> implements Record3<Integer, Integer, Integer> {

	private static final long serialVersionUID = -1493532519;

	/**
	 * Setter for <code>charbot_0_1_0.udev.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.udev.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>charbot_0_1_0.udev.device_id</code>.
	 */
	public void setDeviceId(Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.udev.device_id</code>.
	 */
	public Integer getDeviceId() {
		return (Integer) getValue(1);
	}

	/**
	 * Setter for <code>charbot_0_1_0.udev.user_id</code>.
	 */
	public void setUserId(Integer value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.udev.user_id</code>.
	 */
	public Integer getUserId() {
		return (Integer) getValue(2);
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
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row3<Integer, Integer, Integer> fieldsRow() {
		return (Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row3<Integer, Integer, Integer> valuesRow() {
		return (Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Udev.UDEV.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return Udev.UDEV.DEVICE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field3() {
		return Udev.UDEV.USER_ID;
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
	public Integer value3() {
		return getUserId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UdevRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UdevRecord value2(Integer value) {
		setDeviceId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UdevRecord value3(Integer value) {
		setUserId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UdevRecord values(Integer value1, Integer value2, Integer value3) {
		value1(value1);
		value2(value2);
		value3(value3);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached UdevRecord
	 */
	public UdevRecord() {
		super(Udev.UDEV);
	}

	/**
	 * Create a detached, initialised UdevRecord
	 */
	public UdevRecord(Integer id, Integer deviceId, Integer userId) {
		super(Udev.UDEV);

		setValue(0, id);
		setValue(1, deviceId);
		setValue(2, userId);
	}
}
