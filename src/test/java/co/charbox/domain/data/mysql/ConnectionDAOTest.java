package co.charbox.domain.data.mysql;

import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.mm.ConnectionModel;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.context.SearchWindow;
import com.tpofof.core.data.dao.context.SimpleSearchContext;

@Component
public class ConnectionDAOTest extends AbstractSimpleJooqDaoTest<ConnectionModel, Integer, ConnectionDAO, SimpleSearchContext> {

	private static ConnectionDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(ConnectionDAO.class);
	}

	@Before
	public void setUp() throws Exception {
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
		return (int)(Math.random() * 100000);
	}

	@Override
	public ConnectionModel getModel(Integer id) {
		return ConnectionModel.builder()
				.expectedSpeed(50.0)
				.id(id)
				.ip("127.0.0.1")
				.isp("Comcast Communications")
				.build();
	}

	@Override
	protected ConnectionDAO getDao() {
		return dao;
	}

}
