/**
 * This class is generated by jOOQ
 */
package co.charbox.domain.data.jooq.tables;


import co.charbox.domain.data.jooq.Charbot_0_1_0;
import co.charbox.domain.data.jooq.Keys;
import co.charbox.domain.data.jooq.tables.records.HeartbeatRecord;

import java.sql.Timestamp;
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
public class Heartbeat extends TableImpl<HeartbeatRecord> {

	private static final long serialVersionUID = 1939889699;

	/**
	 * The reference instance of <code>charbot_0_1_0.heartbeat</code>
	 */
	public static final Heartbeat HEARTBEAT = new Heartbeat();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<HeartbeatRecord> getRecordType() {
		return HeartbeatRecord.class;
	}

	/**
	 * The column <code>charbot_0_1_0.heartbeat.id</code>.
	 */
	public final TableField<HeartbeatRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>charbot_0_1_0.heartbeat.device_id</code>.
	 */
	public final TableField<HeartbeatRecord, Integer> DEVICE_ID = createField("device_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>charbot_0_1_0.heartbeat.time</code>.
	 */
	public final TableField<HeartbeatRecord, Timestamp> TIME = createField("time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>charbot_0_1_0.heartbeat.ci_id</code>.
	 */
	public final TableField<HeartbeatRecord, Integer> CI_ID = createField("ci_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * Create a <code>charbot_0_1_0.heartbeat</code> table reference
	 */
	public Heartbeat() {
		this("heartbeat", null);
	}

	/**
	 * Create an aliased <code>charbot_0_1_0.heartbeat</code> table reference
	 */
	public Heartbeat(String alias) {
		this(alias, HEARTBEAT);
	}

	private Heartbeat(String alias, Table<HeartbeatRecord> aliased) {
		this(alias, aliased, null);
	}

	private Heartbeat(String alias, Table<HeartbeatRecord> aliased, Field<?>[] parameters) {
		super(alias, Charbot_0_1_0.CHARBOT_0_1_0, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<HeartbeatRecord, Integer> getIdentity() {
		return Keys.IDENTITY_HEARTBEAT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<HeartbeatRecord> getPrimaryKey() {
		return Keys.KEY_HEARTBEAT_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<HeartbeatRecord>> getKeys() {
		return Arrays.<UniqueKey<HeartbeatRecord>>asList(Keys.KEY_HEARTBEAT_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Heartbeat as(String alias) {
		return new Heartbeat(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Heartbeat rename(String name) {
		return new Heartbeat(name, null);
	}
}
