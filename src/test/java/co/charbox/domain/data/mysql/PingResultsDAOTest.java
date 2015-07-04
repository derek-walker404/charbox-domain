package co.charbox.domain.data.mysql;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.DeviceModel;
import co.charbox.domain.model.PingResults;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.context.SearchWindow;
import com.tpofof.core.data.dao.context.SimpleSearchContext;

@Component
public class PingResultsDAOTest extends AbstractSimpleJooqDaoTest<PingResults, Integer, PingResultsDAO, SimpleSearchContext> {

	private static DaoProvider daoProvider;
	private static PingResultsDAO dao;
	private static DeviceModel device;
	private static ConnectionInfoDAOTest ciDaoTest;
	private static SimpleLocationDaoTest slDaoTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoProvider = App.getContext().getBean(DaoProvider.class);
		dao = daoProvider.getPingResultsDAO();
		
		device = App.getContext().getBean(DeviceDaoTest.class).getModel(null);
		device = daoProvider.getDeviceDAO().insert(device);
		if (device == null || device.getId() == null) {
			throw new RuntimeException("Cannot insert device to test ping results");
		}
		
		ConnectionInfoDAOTest.setUpBeforeClass();
		ciDaoTest = App.getContext().getBean(ConnectionInfoDAOTest.class);
		
		SimpleLocationDaoTest.setUpBeforeClass();;
		slDaoTest = App.getContext().getBean(SimpleLocationDaoTest.class);
	}

	@Before
	public void setUp() throws Exception {
		dao.truncate();
	}

	@Override
	protected SimpleSearchContext getContext(int limit, int offset) {
		return SimpleSearchContext.builder()
				.window(SearchWindow.builder()
						.limit(limit)
						.offset(offset)
						.build())
				.build();
	}

	@Override
	public Integer getRandomPk() {
		return (int)(Math.random() * 100000);
	}

	@Override
	public PingResults getModel(Integer id) {
		DateTime time = new DateTime();
		time = time.minusMillis(time.getMillisOfSecond());
		return PingResults.builder()
				.avgLatency(15.12)
				.connectionInfo(ciDaoTest.getModel(null))
				.device(device)
				.id(id)
				.maxLatency(214.34)
				.minLatency(4.66)
				.packetLoss(0.0)
				.serverLocation(slDaoTest.getModel(null))
				.startTime(time)
				.uri("https://www.google.com")
				.build();
	}

	@Override
	protected PingResultsDAO getDao() {
		return dao;
	}
}