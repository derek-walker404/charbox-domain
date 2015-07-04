/**
 * This class is generated by jOOQ
 */
package co.charbox.domain.data.jooq.tables;


import co.charbox.domain.data.jooq.Charbot_0_1_0;
import co.charbox.domain.data.jooq.Keys;
import co.charbox.domain.data.jooq.tables.records.VersionsRecord;

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
public class Versions extends TableImpl<VersionsRecord> {

	private static final long serialVersionUID = 466334354;

	/**
	 * The reference instance of <code>charbot_0_1_0.versions</code>
	 */
	public static final Versions VERSIONS = new Versions();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<VersionsRecord> getRecordType() {
		return VersionsRecord.class;
	}

	/**
	 * The column <code>charbot_0_1_0.versions.id</code>.
	 */
	public final TableField<VersionsRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>charbot_0_1_0.versions.version</code>.
	 */
	public final TableField<VersionsRecord, String> VERSION = createField("version", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

	/**
	 * The column <code>charbot_0_1_0.versions.sort</code>.
	 */
	public final TableField<VersionsRecord, Long> SORT = createField("sort", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>charbot_0_1_0.versions.install_script_url</code>.
	 */
	public final TableField<VersionsRecord, String> INSTALL_SCRIPT_URL = createField("install_script_url", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

	/**
	 * Create a <code>charbot_0_1_0.versions</code> table reference
	 */
	public Versions() {
		this("versions", null);
	}

	/**
	 * Create an aliased <code>charbot_0_1_0.versions</code> table reference
	 */
	public Versions(String alias) {
		this(alias, VERSIONS);
	}

	private Versions(String alias, Table<VersionsRecord> aliased) {
		this(alias, aliased, null);
	}

	private Versions(String alias, Table<VersionsRecord> aliased, Field<?>[] parameters) {
		super(alias, Charbot_0_1_0.CHARBOT_0_1_0, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<VersionsRecord, Integer> getIdentity() {
		return Keys.IDENTITY_VERSIONS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<VersionsRecord> getPrimaryKey() {
		return Keys.KEY_VERSIONS_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<VersionsRecord>> getKeys() {
		return Arrays.<UniqueKey<VersionsRecord>>asList(Keys.KEY_VERSIONS_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Versions as(String alias) {
		return new Versions(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Versions rename(String name) {
		return new Versions(name, null);
	}
}
