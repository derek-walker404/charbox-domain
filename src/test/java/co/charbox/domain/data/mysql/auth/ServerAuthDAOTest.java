package co.charbox.domain.data.mysql.auth;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import co.charbox.domain.data.mysql.CharbotSimpleJooqDaoTest;
import co.charbox.domain.model.auth.ServerAuthModel;
import co.charbox.domain.model.test.ServerAuthModelProvider;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.test.IModelProvider;

public class ServerAuthDAOTest extends CharbotSimpleJooqDaoTest<ServerAuthModel> {

	private static ServerAuthDAO dao;
	private static ServerAuthModelProvider pro;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(ServerAuthDAO.class);
		pro = App.getContext().getBean(ServerAuthModelProvider.class);
	}

	@Override
	protected ServerAuthDAO getDao() {
		return dao;
	}
	
	@Override
	public IModelProvider<ServerAuthModel, Integer> getProvider() {
		return pro;
	}
	
	@Test
	public void validateAuth() {
		assertEquals(0, getDao().count(getContext()));
		
		ServerAuthModel expected = getDao().insert(getProvider().getModel(null));
		assertNotNull(expected);
		
		ServerAuthModel searchModel = ServerAuthModel.builder()
				.key(expected.getKey())
				.serverId(expected.getServerId())
				.serviceName(expected.getServiceName())
				.build();
		ServerAuthModel actual = getDao().find(searchModel);
		
		assertEquals(expected, actual);
		
		assertTrue(getDao().delete(expected.getId()));
		
		assertNull(getDao().find(searchModel));
	}
}
