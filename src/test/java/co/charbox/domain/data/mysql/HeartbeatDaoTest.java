package co.charbox.domain.data.mysql;

import java.sql.Timestamp;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.HeartbeatModel;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.context.SearchWindow;
import com.tpofof.core.data.dao.context.SimpleSearchContext;

@Component
public class HeartbeatDaoTest extends AbstractSimpleJooqDaoTest<HeartbeatModel, Integer, HeartbeatDAO, SimpleSearchContext> {

	private static DaoProvider daoProvider;
	private static Integer deviceId;
	private static DeviceDaoTest deviceDaoTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoProvider = App.getContext().getBean(DaoProvider.class);
		deviceDaoTest = App.getContext().getBean(DeviceDaoTest.class);
		deviceId = daoProvider.getDeviceDAO().insert(deviceDaoTest.getModel(null)).getId();
	}

	@Before
	public void setUp() throws Exception {
		daoProvider.getHeartbeatDAO().truncate();
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
	public HeartbeatModel getModel(Integer id) {
		DateTime time = new DateTime(new Timestamp(System.currentTimeMillis()));
		time = time.minusMillis((int)time.getMillisOfSecond());
		return HeartbeatModel.builder()
				.id(id)
				.device(deviceDaoTest.getModel(deviceId))
				.time(time)
				.build();
	}

	@Override
	protected HeartbeatDAO getDao() {
		return daoProvider.getHeartbeatDAO();
	}
}
