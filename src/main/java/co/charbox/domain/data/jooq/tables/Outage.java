/**
 * This class is generated by jOOQ
 */
package co.charbox.domain.data.jooq.tables;


import co.charbox.domain.data.jooq.Charbot_0_1_0;
import co.charbox.domain.data.jooq.Keys;
import co.charbox.domain.data.jooq.tables.records.OutageRecord;

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
public class Outage extends TableImpl<OutageRecord> {

	private static final long serialVersionUID = -1746248394;

	/**
	 * The reference instance of <code>charbot_0_1_0.outage</code>
	 */
	public static final Outage OUTAGE = new Outage();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<OutageRecord> getRecordType() {
		return OutageRecord.class;
	}

	/**
	 * The column <code>charbot_0_1_0.outage.id</code>.
	 */
	public final TableField<OutageRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>charbot_0_1_0.outage.device_id</code>.
	 */
	public final TableField<OutageRecord, Integer> DEVICE_ID = createField("device_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>charbot_0_1_0.outage.start_time</code>.
	 */
	public final TableField<OutageRecord, Timestamp> START_TIME = createField("start_time", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

	/**
	 * The column <code>charbot_0_1_0.outage.end_time</code>.
	 */
	public final TableField<OutageRecord, Timestamp> END_TIME = createField("end_time", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

	/**
	 * The column <code>charbot_0_1_0.outage.duration</code>.
	 */
	public final TableField<OutageRecord, Integer> DURATION = createField("duration", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>charbot_0_1_0.outage.confirmed</code>.
	 */
	public final TableField<OutageRecord, Byte> CONFIRMED = createField("confirmed", org.jooq.impl.SQLDataType.TINYINT, this, "");

	/**
	 * The column <code>charbot_0_1_0.outage.type</code>.
	 */
	public final TableField<OutageRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR.length(45), this, "");

	/**
	 * The column <code>charbot_0_1_0.outage.connection_info_id</code>.
	 */
	public final TableField<OutageRecord, Integer> CONNECTION_INFO_ID = createField("connection_info_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * Create a <code>charbot_0_1_0.outage</code> table reference
	 */
	public Outage() {
		this("outage", null);
	}

	/**
	 * Create an aliased <code>charbot_0_1_0.outage</code> table reference
	 */
	public Outage(String alias) {
		this(alias, OUTAGE);
	}

	private Outage(String alias, Table<OutageRecord> aliased) {
		this(alias, aliased, null);
	}

	private Outage(String alias, Table<OutageRecord> aliased, Field<?>[] parameters) {
		super(alias, Charbot_0_1_0.CHARBOT_0_1_0, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<OutageRecord, Integer> getIdentity() {
		return Keys.IDENTITY_OUTAGE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<OutageRecord> getPrimaryKey() {
		return Keys.KEY_OUTAGE_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<OutageRecord>> getKeys() {
		return Arrays.<UniqueKey<OutageRecord>>asList(Keys.KEY_OUTAGE_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Outage as(String alias) {
		return new Outage(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Outage rename(String name) {
		return new Outage(name, null);
	}
}
