package co.charbox.domain.data.mysql;

import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.mm.ConnectionInfoModel;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.context.SearchWindow;
import com.tpofof.core.data.dao.context.SimpleSearchContext;

@Component
public class ConnectionInfoDAOTest extends AbstractSimpleJooqDaoTest<ConnectionInfoModel, Integer, ConnectionInfoDAO, SimpleSearchContext> {

	@Autowired private static DaoProvider daoProvider;
	@Autowired private static ConnectionInfoDAO dao;
	@Autowired private static ConnectionDAOTest connDaoTest;
	@Autowired private static LocationDAOTest locDaoTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoProvider = App.getContext().getBean(DaoProvider.class);
		dao = daoProvider.getConnectionInfoDAO();
		
		ConnectionDAOTest.setUpBeforeClass();
		connDaoTest = App.getContext().getBean(ConnectionDAOTest.class);
		
		LocationDAOTest.setUpBeforeClass();
		locDaoTest = App.getContext().getBean(LocationDAOTest.class);
	}

	@Before
	public void setUp() throws Exception {
		dao.truncate();
		daoProvider.getConnectionDAO().truncate();
		daoProvider.getLocationDAO().truncate();
	}

	@Override
	protected SimpleSearchContext getContext(int limit, int offset) {
		return SimpleSearchContext.builder()
				.window(SearchWindow.builder()
						.limit(limit)
						.offset(offset)
						.build())
				.build();
	}

	@Override
	public Integer getRandomPk() {
		return (int)(Math.random() * 10000000);
	}

	@Override
	public ConnectionInfoModel getModel(Integer id) {
		return ConnectionInfoModel.builder()
				.id(id)
				.connection(connDaoTest.getModel(null))
				.location(locDaoTest.getModel(null))
				.build();
	}

	@Override
	protected ConnectionInfoDAO getDao() {
		return dao;
	}

}
