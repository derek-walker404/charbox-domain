package co.charbox.domain.data.mysql;

import org.junit.BeforeClass;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.mm.LocationModel;
import co.charbox.domain.providers.LocationModelProvider;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.test.IModelProvider;

@Component
public class LocationDAOTest extends CharbotSimpleJooqDaoTest<LocationModel> {

	private static LocationDAO dao;
	private static LocationModelProvider pro;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(LocationDAO.class);
		pro = App.getContext().getBean(LocationModelProvider.class);
	}

	@Override
	protected LocationDAO getDao() {
		return dao;
	}

	@Override
	public IModelProvider<LocationModel, Integer> getProvider() {
		return pro;
	}

}
