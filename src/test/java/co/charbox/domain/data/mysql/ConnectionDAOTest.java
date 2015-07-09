package co.charbox.domain.data.mysql;

import org.junit.BeforeClass;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.mm.ConnectionModel;
import co.charbox.domain.model.test.ConnectionModelProvider;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.test.IModelProvider;

@Component
public class ConnectionDAOTest extends CharbotSimpleJooqDaoTest<ConnectionModel> {

	private static ConnectionDAO dao;
	private static ConnectionModelProvider pro;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(ConnectionDAO.class);
		pro = App.getContext().getBean(ConnectionModelProvider.class);
	}
	
	@Override
	public IModelProvider<ConnectionModel, Integer> getProvider() {
		return pro;
	}

	@Override
	protected ConnectionDAO getDao() {
		return dao;
	}
}
