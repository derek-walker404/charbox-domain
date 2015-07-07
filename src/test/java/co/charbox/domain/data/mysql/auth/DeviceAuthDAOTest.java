package co.charbox.domain.data.mysql.auth;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import co.charbox.domain.data.mysql.CharbotSimpleJooqDaoTest;
import co.charbox.domain.data.mysql.DeviceDAO;
import co.charbox.domain.data.mysql.DeviceDAOTest;
import co.charbox.domain.model.DeviceModel;
import co.charbox.domain.model.auth.DeviceAuthModel;

import com.tpofof.core.App;

public class DeviceAuthDAOTest extends CharbotSimpleJooqDaoTest<DeviceAuthModel> {

	private static DeviceAuthDAO dao;
	private static DeviceDAOTest deviceTest;
	private static DeviceDAO deviceDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(DeviceAuthDAO.class);
		
		DeviceDAOTest.setUpBeforeClass();
		deviceTest = App.getContext().getBean(DeviceDAOTest.class);
		deviceDao = App.getContext().getBean(DeviceDAO.class);
	}

	@Override
	public DeviceAuthModel getModel(Integer id) {
		DeviceModel device = deviceDao.insert(deviceTest.getModel(null));
		return DeviceAuthModel.builder()
				.activated(true)
				.deviceId(device.getId())
				.id(id)
				.key("key1234")
				.build();
	}

	@Override
	protected DeviceAuthDAO getDao() {
		return dao;
	}
	
	@Test
	public void testValidateAuth() {
		assertEquals(0, getDao().count(getContext()));
		
		DeviceAuthModel expected = getDao().insert(getModel(null));
		assertNotNull(expected);
		
		DeviceAuthModel searchModel = DeviceAuthModel.builder()
				.deviceId(expected.getDeviceId())
				.key(expected.getKey())
				.build();
		DeviceAuthModel actual = getDao().find(searchModel);
		
		assertEquals(expected, actual);
		
		assertTrue(getDao().delete(expected.getId()));
		
		assertNull(getDao().find(searchModel));
	}
}
