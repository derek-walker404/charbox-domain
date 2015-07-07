package co.charbox.domain.data.mysql;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.HeartbeatModel;

import com.tpofof.core.App;

@Component
public class HeartbeatDAOTest extends CharbotSimpleJooqDaoTest<HeartbeatModel> {

	private static DaoProvider daoProvider;
	private static Integer deviceId;
	private static DeviceDAOTest deviceDaoTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoProvider = App.getContext().getBean(DaoProvider.class);
		deviceDaoTest = App.getContext().getBean(DeviceDAOTest.class);
		deviceId = daoProvider.getDeviceDAO().insert(deviceDaoTest.getModel(null)).getId();
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
	
	@Test
	public void testFindByDeviceId() {
		Assert.assertEquals(0, getDao().count(getContext()));
		
		HeartbeatModel expected = getDao().insert(getModel(null));
		assertNotNull(expected);
		
		HeartbeatModel actual = getDao().findByDeviceId(expected.getDevice().getId());
		assertEquals(expected, actual);
		
		assertTrue(getDao().delete(expected.getId()));
		assertNull(getDao().findByDeviceId(expected.getDevice().getId()));
	}
}
