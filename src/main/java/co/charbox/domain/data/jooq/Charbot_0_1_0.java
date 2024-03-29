/**
 * This class is generated by jOOQ
 */
package co.charbox.domain.data.jooq;


import co.charbox.domain.data.jooq.tables.Connection;
import co.charbox.domain.data.jooq.tables.ConnectionInfo;
import co.charbox.domain.data.jooq.tables.DeviceAuth;
import co.charbox.domain.data.jooq.tables.DeviceConfigs;
import co.charbox.domain.data.jooq.tables.Devices;
import co.charbox.domain.data.jooq.tables.Heartbeat;
import co.charbox.domain.data.jooq.tables.Location;
import co.charbox.domain.data.jooq.tables.Outage;
import co.charbox.domain.data.jooq.tables.Ping;
import co.charbox.domain.data.jooq.tables.ServerAuth;
import co.charbox.domain.data.jooq.tables.SimpleLocation;
import co.charbox.domain.data.jooq.tables.Sst;
import co.charbox.domain.data.jooq.tables.TokenAuth;
import co.charbox.domain.data.jooq.tables.Udev;
import co.charbox.domain.data.jooq.tables.Users;
import co.charbox.domain.data.jooq.tables.Versions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Charbot_0_1_0 extends SchemaImpl {

	private static final long serialVersionUID = -941169636;

	/**
	 * The reference instance of <code>charbot_0_1_0</code>
	 */
	public static final Charbot_0_1_0 CHARBOT_0_1_0 = new Charbot_0_1_0();

	/**
	 * No further instances allowed
	 */
	private Charbot_0_1_0() {
		super("charbot_0_1_0");
	}

	@Override
	public final List<Table<?>> getTables() {
		List result = new ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final List<Table<?>> getTables0() {
		return Arrays.<Table<?>>asList(
			Connection.CONNECTION,
			ConnectionInfo.CONNECTION_INFO,
			Devices.DEVICES,
			DeviceAuth.DEVICE_AUTH,
			DeviceConfigs.DEVICE_CONFIGS,
			Heartbeat.HEARTBEAT,
			Location.LOCATION,
			Outage.OUTAGE,
			Ping.PING,
			ServerAuth.SERVER_AUTH,
			SimpleLocation.SIMPLE_LOCATION,
			Sst.SST,
			TokenAuth.TOKEN_AUTH,
			Udev.UDEV,
			Users.USERS,
			Versions.VERSIONS);
	}
}
