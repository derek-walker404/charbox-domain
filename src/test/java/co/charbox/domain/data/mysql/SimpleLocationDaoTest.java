package co.charbox.domain.data.mysql;

import org.junit.BeforeClass;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.mm.SimpleLocationModel;

import com.tpofof.core.App;

@Component
public class SimpleLocationDaoTest extends CharbotSimpleJooqDaoTest<SimpleLocationModel> {

	private static SimpleLocationDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		dao = App.getContext().getBean(SimpleLocationDAO.class);
	}
	@Override
	public SimpleLocationModel getModel(Integer id) {
		return SimpleLocationModel.builder()
				.id(id)
				.ip("127.0.0.1")
				.lat(100.0)
				.lon(-100.0)
				.build();
	}

	@Override
	protected SimpleLocationDAO getDao() {
		return dao;
	}
}
