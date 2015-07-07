package co.charbox.domain.data.mysql;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import co.charbox.domain.model.DeviceConfigurationModel;
import co.charbox.domain.model.DeviceModel;
import co.charbox.domain.model.DeviceVersionModel;

import com.google.common.collect.Maps;
import com.tpofof.core.App;

public class DeviceConfigurationDAOTest extends CharbotSimpleJooqDaoTest<DeviceConfigurationModel> {

	private static DeviceConfigurationDAO dao;
	private static DeviceDAOTest deviceTest;
	private static DeviceDAO deviceDao;
	private static DeviceVersionModel version;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(DeviceConfigurationDAO.class);
		
		DeviceDAOTest.setUpBeforeClass();
		deviceTest = App.getContext().getBean(DeviceDAOTest.class);
		deviceDao = App.getContext().getBean(DeviceDAO.class);
		
		DeviceVersionDAOTest verTest = App.getContext().getBean(DeviceVersionDAOTest.class);
		version = App.getContext().getBean(DeviceVersionDAO.class)
				.insert(verTest.getModel(null));
	}

	@Override
	public DeviceConfigurationModel getModel(Integer id) {
		DeviceModel device = deviceDao.insert(deviceTest.getModel(null));
		return DeviceConfigurationModel.builder()
				.device(device)
				.id(id)
				.registered(true)
				.schedules(Maps.<String, String>newHashMap())
				.version(version.getId())
				.build();
	}

	@Override
	protected DeviceConfigurationDAO getDao() {
		return dao;
	}
	
	@Test
	public void testFindByDeviceId() {
		assertEquals(0, getDao().count(getContext()));
		
		DeviceConfigurationModel expected = getDao().insert(getModel(null));
		assertNotNull(expected);
		
		DeviceConfigurationModel actual = getDao().findByDeviceId(expected.getDevice().getId());
		assertEquals(expected, actual);
		
		assertTrue(getDao().delete(expected.getId()));
		assertNull(getDao().findByDeviceId(expected.getDevice().getId()));
	}
	
	@Test
	public void testUpdateRegistered() {
		assertEquals(0, getDao().count(getContext()));
		
		DeviceConfigurationModel expected = getDao().insert(getModel(null));
		assertNotNull(expected);
		
		boolean registered = expected.isRegistered();
		expected.setRegistered(!registered);
		DeviceConfigurationModel updated = getDao().updateRegistered(expected);
		
		assertNotNull(updated);
		assertEquals(!registered, updated.isRegistered());
		assertEquals(expected, updated);
	}
}
