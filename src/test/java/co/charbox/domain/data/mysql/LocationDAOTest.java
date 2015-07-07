package co.charbox.domain.data.mysql;

import org.junit.BeforeClass;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.mm.LocationModel;

import com.tpofof.core.App;

@Component
public class LocationDAOTest extends CharbotSimpleJooqDaoTest<LocationModel> {

	private static LocationDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(LocationDAO.class);
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
