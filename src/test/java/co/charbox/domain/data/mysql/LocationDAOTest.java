package co.charbox.domain.data.mysql;

import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.mm.LocationModel;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.context.SearchWindow;
import com.tpofof.core.data.dao.context.SimpleSearchContext;

@Component
public class LocationDAOTest extends AbstractSimpleJooqDaoTest<LocationModel, Integer, LocationDAO, SimpleSearchContext> {

	private static LocationDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(LocationDAO.class);
	}

	@Before
	public void setUp() throws Exception {
		dao.truncate();
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
	public LocationModel getModel(Integer id) {
		return LocationModel.builder()
				.id(id)
				.city("Atlanta")
				.continent("North America")
				.country("United States")
				.lat(100.0)
				.lon(-100.0)
				.subdivision("Georgia")
				.timeZone("Eastern")
				.zip("30361")
				.build();
	}

	@Override
	protected LocationDAO getDao() {
		return dao;
	}

}
