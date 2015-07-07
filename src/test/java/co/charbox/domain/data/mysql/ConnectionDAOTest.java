package co.charbox.domain.data.mysql;

import org.junit.BeforeClass;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.mm.ConnectionModel;

import com.tpofof.core.App;

@Component
public class ConnectionDAOTest extends CharbotSimpleJooqDaoTest<ConnectionModel> {

	private static ConnectionDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(ConnectionDAO.class);
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
