package co.charbox.domain.data.mysql;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.DeviceModel;
import co.charbox.domain.model.OutageModel;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.context.SearchWindow;
import com.tpofof.core.data.dao.context.SimpleSearchContext;

@Component
public class OutageDAOTest extends AbstractSimpleJooqDaoTest<OutageModel, Integer, OutageDAO, SimpleSearchContext> {

	private static DaoProvider daoProvider;
	private static OutageDAO dao;
	private static DeviceModel device;
	private static ConnectionInfoDAOTest ciDaoTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoProvider = App.getContext().getBean(DaoProvider.class);
		dao = App.getContext().getBean(OutageDAO.class);
		
		DeviceDaoTest.setUpBeforeClass();
		DeviceDaoTest deviceDaoTest = App.getContext().getBean(DeviceDaoTest.class);
		device = daoProvider.getDeviceDAO().insert(deviceDaoTest.getModel(null));
		
		ConnectionInfoDAOTest.setUpBeforeClass();
		ciDaoTest = App.getContext().getBean(ConnectionInfoDAOTest.class);
		
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
		return (int)(Math.random() * 100000000);
	}

	@Override
	public OutageModel getModel(Integer id) {
		DateTime time = new DateTime();
		time = time.minusMillis(time.getMillisOfSecond());
		return OutageModel.builder()
				.confirmed(false)
				.connectionInfo(ciDaoTest.getModel(null))
				.device(device)
				.duration(10)
				.endTime(time)
				.id(id)
				.startTime(time)
				.type("unknown")
				.build();
	}

	@Override
	protected OutageDAO getDao() {
		return dao;
	}
}
