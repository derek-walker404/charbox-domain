package co.charbox.domain.data.mysql;

import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.mm.SimpleLocationModel;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.context.SearchWindow;
import com.tpofof.core.data.dao.context.SimpleSearchContext;

@Component
public class SimpleLocationDaoTest extends AbstractSimpleJooqDaoTest<SimpleLocationModel, Integer, SimpleLocationDAO, SimpleSearchContext> {

	private static SimpleLocationDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		dao = App.getContext().getBean(SimpleLocationDAO.class);
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
	public SimpleLocationModel getModel(Integer id) {
		return SimpleLocationModel.builder()
				.id(id)
				.ip("127.0.0.1")
				.lat(100.0)
				.lon(-100.0)
				.build();
	}

	@Before
	public void beforeTest() {
		dao.truncate();
	}

	@Override
	public Integer getRandomPk() {
		return (int)(Math.random() * 10000000);
	}

	@Override
	protected SimpleLocationDAO getDao() {
		return dao;
	}
}
