package co.charbox.domain.data.mysql.auth;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import co.charbox.domain.data.mysql.CharbotSimpleJooqDaoTest;
import co.charbox.domain.model.auth.TokenAuthModel;
import co.charbox.domain.model.test.TokenAuthModelProvider;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.test.IModelProvider;

public class TokenAuthDAOTest extends CharbotSimpleJooqDaoTest<TokenAuthModel> {

	private static TokenAuthDAO dao;
	private static TokenAuthModelProvider pro;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(TokenAuthDAO.class);
		pro = App.getContext().getBean(TokenAuthModelProvider.class);
	}

	@Override
	protected TokenAuthDAO getDao() {
		return dao;
	}
	
	@Override
	public IModelProvider<TokenAuthModel, Integer> getProvider() {
		return pro;
	}
	
	@Test
	public void testValidateAuth() {
		assertEquals(0, getDao().count(getContext()));
		
		TokenAuthModel expected = getDao().insert(getProvider().getModel(null));
		assertNotNull(expected);
		
		TokenAuthModel searchModel = TokenAuthModel.builder()
				.authAssetId(expected.getAuthAssetId())
				.serviceName(expected.getServiceName())
				.token(expected.getToken())
				.build();
		TokenAuthModel actual = getDao().find(searchModel);
		
		assertEquals(expected, actual);
		
		assertTrue(getDao().delete(expected.getId()));
		
		assertNull(getDao().find(searchModel));
	}
}
