package co.charbox.domain.data.mysql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.HeartbeatModel;
import co.charbox.domain.providers.HeartbeatModelProvider;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.test.IModelProvider;

@Component
public class HeartbeatDAOTest extends CharbotSimpleJooqDaoTest<HeartbeatModel> {

	private static HeartbeatDAO dao;
	private static HeartbeatModelProvider pro;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(HeartbeatDAO.class);
		pro = App.getContext().getBean(HeartbeatModelProvider.class);
	}

	@Override
	protected HeartbeatDAO getDao() {
		return dao;
	}

	@Override
	public IModelProvider<HeartbeatModel, Integer> getProvider() {
		return pro;
	}
	
	@Test
	public void testFindByDeviceId() {
		Assert.assertEquals(0, getDao().count(getContext()));
		
		HeartbeatModel model = getProvider().getModel(null);
		HeartbeatModel expected = getDao().insert(model);
		assertNotNull(expected);
		
		HeartbeatModel actual = getDao().findByDeviceId(expected.getDevice().getId());
		assertEquals(expected, actual);
		
		assertTrue(getDao().delete(expected.getId()));
		assertNull(getDao().findByDeviceId(expected.getDevice().getId()));
	}
}
