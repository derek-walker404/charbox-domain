package co.charbox.domain.data.mysql.auth;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;

import co.charbox.domain.data.mysql.CharbotSimpleJooqDaoTest;
import co.charbox.domain.model.auth.TokenAuthModel;

import com.tpofof.core.App;

public class TokenAuthDAOTest extends CharbotSimpleJooqDaoTest<TokenAuthModel> {

	private static TokenAuthDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(TokenAuthDAO.class);
	}

	@Override
	public TokenAuthModel getModel(Integer id) {
		DateTime time = new DateTime();
		time = time.minusMillis(time.getMillisOfSecond());
		return TokenAuthModel.builder()
				.authAssetId(-1)
				.expiration(time)
				.id(id)
				.serviceName("sso")
				.token("token1234")
				.build();
	}

	@Override
	protected TokenAuthDAO getDao() {
		return dao;
	}
	
	@Test
	public void testValidateAuth() {
		assertEquals(0, getDao().count(getContext()));
		
		TokenAuthModel expected = getDao().insert(getModel(null));
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
