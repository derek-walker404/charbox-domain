package co.charbox.domain.data.mysql;

import org.junit.BeforeClass;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.mm.ConnectionInfoModel;
import co.charbox.domain.providers.ConnectionInfoModelProvider;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.test.IModelProvider;

@Component
public class ConnectionInfoDAOTest extends CharbotSimpleJooqDaoTest<ConnectionInfoModel> {

	private static ConnectionInfoDAO dao;
	private static ConnectionInfoModelProvider pro;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(ConnectionInfoDAO.class);
		pro = App.getContext().getBean(ConnectionInfoModelProvider.class);
	}

	@Override
	protected ConnectionInfoDAO getDao() {
		return dao;
	}

	@Override
	public IModelProvider<ConnectionInfoModel, Integer> getProvider() {
		return pro;
	}

}
