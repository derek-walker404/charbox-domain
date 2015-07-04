package co.charbox.domain.data.mysql;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.BeforeClass;

import co.charbox.domain.model.DeviceModel;
import co.charbox.domain.model.SstResultsModel;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.context.SearchWindow;
import com.tpofof.core.data.dao.context.SimpleSearchContext;

public class SstResultsDAOTest extends AbstractSimpleJooqDaoTest<SstResultsModel, Integer, SstResultsDAO, SimpleSearchContext> {

	private static DaoProvider daoProvider;
	private static SstResultsDAO dao;
	private static DeviceModel device;
	private static ConnectionInfoDAOTest ciDaoTest;
	private static SimpleLocationDaoTest slDaoTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoProvider = App.getContext().getBean(DaoProvider.class);
		dao = daoProvider.getSstResultsDAO();
		
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
	public SstResultsModel getModel(Integer id) {
		DateTime time = new DateTime();
		time = time.minusMillis(time.getMillisOfSecond());
		return SstResultsModel.builder()
				.device(device)
				.deviceInfo(ciDaoTest.getModel(null))
				.deviceToken("ASDGSDFHG%ERG!#$$FQERG!#QFQ")
				.downloadDuration(3001)
				.downloadSize(87567653425L)
				.downloadSpeed(56.234)
				.id(id)
				.pingDuration(28)
				.serverLocation(slDaoTest.getModel(null))
				.startTime(time)
				.uploadDuration(3002)
				.uploadSize(34524323466L)
				.uploadSpeed(12.544)
				.build();
	}

	@Override
	protected SstResultsDAO getDao() {
		return dao;
	}
}
