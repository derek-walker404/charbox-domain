package co.charbox.domain.data.mysql;

import org.junit.BeforeClass;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.DeviceVersionModel;
import co.charbox.domain.model.test.DeviceVersionModelProvider;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.context.SimpleSearchContext;
import com.tpofof.core.data.dao.jdbc.AbstractSimpleJooqDAO;
import com.tpofof.core.data.dao.test.IModelProvider;

@Component
public class DeviceVersionDAOTest extends CharbotSimpleJooqDaoTest<DeviceVersionModel> {

	private static DeviceVersionDAO dao;
	private static DeviceVersionModelProvider pro;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(DeviceVersionDAO.class);
		pro = App.getContext().getBean(DeviceVersionModelProvider.class);
	}

	@Override
	protected AbstractSimpleJooqDAO<DeviceVersionModel, Integer, SimpleSearchContext> getDao() {
		return dao;
	}

	@Override
	public IModelProvider<DeviceVersionModel, Integer> getProvider() {
		return pro;
	}
}
