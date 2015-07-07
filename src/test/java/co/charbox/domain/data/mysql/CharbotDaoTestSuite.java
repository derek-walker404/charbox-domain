package co.charbox.domain.data.mysql;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import co.charbox.domain.data.mysql.auth.DeviceAuthDAOTest;
import co.charbox.domain.data.mysql.auth.ServerAuthDAOTest;
import co.charbox.domain.data.mysql.auth.TokenAuthDAOTest;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.jdbc.JooqConnectionProvider;

@RunWith(Suite.class)
@SuiteClasses({ ConnectionDAOTest.class, ConnectionInfoDAOTest.class,
		DeviceDAOTest.class, DeviceVersionDAOTest.class,
		HeartbeatDAOTest.class, LocationDAOTest.class, OutageDAOTest.class,
		PingResultsDAOTest.class, SimpleLocationDaoTest.class,
		SstResultsDAOTest.class, DeviceAuthDAOTest.class,
		ServerAuthDAOTest.class, TokenAuthDAOTest.class,
		DeviceConfigurationDAOTest.class })
public class CharbotDaoTestSuite {

	private static JooqConnectionProvider connPro;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		connPro = App.getContext().getBean(JooqConnectionProvider.class);
		connPro.configure("jdbc:mysql://localhost:3306/", 
				"test" + System.currentTimeMillis(), 
				"root", 
				"");
		
	}
	
	@AfterClass
	public static void cleanUpAfterClass() {
		connPro.dropDatabase();
	}
}
