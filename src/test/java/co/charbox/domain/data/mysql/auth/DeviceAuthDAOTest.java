package co.charbox.domain.data.mysql.auth;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import co.charbox.domain.data.mysql.CharbotSimpleJooqDaoTest;
import co.charbox.domain.model.auth.DeviceAuthModel;
import co.charbox.domain.providers.DeviceAuthModelProvider;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.test.IModelProvider;

public class DeviceAuthDAOTest extends CharbotSimpleJooqDaoTest<DeviceAuthModel> {

	private static DeviceAuthDAO dao;
	private static DeviceAuthModelProvider pro;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(DeviceAuthDAO.class);
		pro = App.getContext().getBean(DeviceAuthModelProvider.class);
	}

	@Override
	protected DeviceAuthDAO getDao() {
		return dao;
	}

	@Override
	public IModelProvider<DeviceAuthModel, Integer> getProvider() {
		return pro;
	}
	
	@Test
	public void testValidateAuth() {
		assertEquals(0, getDao().count(getContext()));
		
		DeviceAuthModel expected = getDao().insert(getProvider().getModel(null));
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
