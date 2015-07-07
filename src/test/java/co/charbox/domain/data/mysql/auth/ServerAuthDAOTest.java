package co.charbox.domain.data.mysql.auth;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import co.charbox.domain.data.mysql.CharbotSimpleJooqDaoTest;
import co.charbox.domain.model.auth.ServerAuthModel;

import com.tpofof.core.App;

public class ServerAuthDAOTest extends CharbotSimpleJooqDaoTest<ServerAuthModel> {

	private static ServerAuthDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(ServerAuthDAO.class);
	}

	@Override
	public ServerAuthModel getModel(Integer id) {
		return ServerAuthModel.builder()
				.activated(true)
				.id(id)
				.key("key1234")
				.serverId("sso_east_" + System.currentTimeMillis())
				.serviceName("sso")
				.build();
	}

	@Override
	protected ServerAuthDAO getDao() {
		return dao;
	}
	
	@Test
	public void validateAuth() {
		assertEquals(0, getDao().count(getContext()));
		
		ServerAuthModel expected = getDao().insert(getModel(null));
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
