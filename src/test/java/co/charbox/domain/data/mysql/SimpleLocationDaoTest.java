package co.charbox.domain.data.mysql;

import org.junit.BeforeClass;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.mm.SimpleLocationModel;
import co.charbox.domain.providers.SimpleLocationModelProvider;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.test.IModelProvider;

@Component
public class SimpleLocationDaoTest extends CharbotSimpleJooqDaoTest<SimpleLocationModel> {

	private static SimpleLocationDAO dao;
	private static SimpleLocationModelProvider pro;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		dao = App.getContext().getBean(SimpleLocationDAO.class);
		pro = App.getContext().getBean(SimpleLocationModelProvider.class);
	}

	@Override
	protected SimpleLocationDAO getDao() {
		return dao;
	}

	@Override
	public IModelProvider<SimpleLocationModel, Integer> getProvider() {
		return pro;
	}
}
