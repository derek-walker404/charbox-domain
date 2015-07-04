/**
 * This class is generated by jOOQ
 */
package co.charbox.domain.data.jooq.tables.records;


import co.charbox.domain.data.jooq.tables.ServerAuth;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row;
import org.jooq.Row5;
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
public class ServerAuthRecord extends UpdatableRecordImpl<ServerAuthRecord> implements Record5<Integer, String, String, String, Byte> {

	private static final long serialVersionUID = -627271910;

	/**
	 * Setter for <code>charbot_0_1_0.server_auth.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.server_auth.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>charbot_0_1_0.server_auth.server_id</code>.
	 */
	public void setServerId(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.server_auth.server_id</code>.
	 */
	public String getServerId() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>charbot_0_1_0.server_auth.service_name</code>.
	 */
	public void setServiceName(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.server_auth.service_name</code>.
	 */
	public String getServiceName() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>charbot_0_1_0.server_auth.key</code>.
	 */
	public void setKey(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.server_auth.key</code>.
	 */
	public String getKey() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>charbot_0_1_0.server_auth.activated</code>.
	 */
	public void setActivated(Byte value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>charbot_0_1_0.server_auth.activated</code>.
	 */
	public Byte getActivated() {
		return (Byte) getValue(4);
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
	// Record5 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row5<Integer, String, String, String, Byte> fieldsRow() {
		return (Row5) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row5<Integer, String, String, String, Byte> valuesRow() {
		return (Row5) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return ServerAuth.SERVER_AUTH.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return ServerAuth.SERVER_AUTH.SERVER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return ServerAuth.SERVER_AUTH.SERVICE_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return ServerAuth.SERVER_AUTH.KEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Byte> field5() {
		return ServerAuth.SERVER_AUTH.ACTIVATED;
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
		return getServerId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getServiceName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getKey();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Byte value5() {
		return getActivated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ServerAuthRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ServerAuthRecord value2(String value) {
		setServerId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ServerAuthRecord value3(String value) {
		setServiceName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ServerAuthRecord value4(String value) {
		setKey(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ServerAuthRecord value5(Byte value) {
		setActivated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ServerAuthRecord values(Integer value1, String value2, String value3, String value4, Byte value5) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached ServerAuthRecord
	 */
	public ServerAuthRecord() {
		super(ServerAuth.SERVER_AUTH);
	}

	/**
	 * Create a detached, initialised ServerAuthRecord
	 */
	public ServerAuthRecord(Integer id, String serverId, String serviceName, String key, Byte activated) {
		super(ServerAuth.SERVER_AUTH);

		setValue(0, id);
		setValue(1, serverId);
		setValue(2, serviceName);
		setValue(3, key);
		setValue(4, activated);
	}
}
