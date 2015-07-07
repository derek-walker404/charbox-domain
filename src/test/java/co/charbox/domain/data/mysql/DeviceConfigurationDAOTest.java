package co.charbox.domain.data.mysql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import co.charbox.domain.model.DeviceConfigurationModel;
import co.charbox.domain.providers.DeviceConfigurationModelProvider;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.test.IModelProvider;

public class DeviceConfigurationDAOTest extends CharbotSimpleJooqDaoTest<DeviceConfigurationModel> {

	private static DeviceConfigurationDAO dao;
	private static DeviceConfigurationModelProvider pro;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(DeviceConfigurationDAO.class);
		pro = App.getContext().getBean(DeviceConfigurationModelProvider.class);
	}

	@Override
	protected DeviceConfigurationDAO getDao() {
		return dao;
	}
	
	@Override
	public IModelProvider<DeviceConfigurationModel, Integer> getProvider() {
		return pro;
	}
	
	@Test
	public void testFindByDeviceId() {
		assertEquals(0, getDao().count(getContext()));
		
		DeviceConfigurationModel expected = getDao().insert(getProvider().getModel(null));
		assertNotNull(expected);
		
		DeviceConfigurationModel actual = getDao().findByDeviceId(expected.getDevice().getId());
		assertEquals(expected, actual);
		
		assertTrue(getDao().delete(expected.getId()));
		assertNull(getDao().findByDeviceId(expected.getDevice().getId()));
	}
	
	@Test
	public void testUpdateRegistered() {
		assertEquals(0, getDao().count(getContext()));
		
		DeviceConfigurationModel expected = getDao().insert(getProvider().getModel(null));
		assertNotNull(expected);
		
		boolean registered = expected.isRegistered();
		expected.setRegistered(!registered);
		DeviceConfigurationModel updated = getDao().updateRegistered(expected);
		
		assertNotNull(updated);
		assertEquals(!registered, updated.isRegistered());
		assertEquals(expected, updated);
	}
}
