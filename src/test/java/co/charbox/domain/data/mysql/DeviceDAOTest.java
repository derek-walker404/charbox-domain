package co.charbox.domain.data.mysql;

import org.junit.BeforeClass;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.DeviceModel;
import co.charbox.domain.providers.DeviceModelProvider;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.test.IModelProvider;

@Component
public class DeviceDAOTest extends CharbotSimpleJooqDaoTest<DeviceModel> {

	private static DeviceDAO dao;
	private static DeviceModelProvider pro;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(DeviceDAO.class);
		pro = App.getContext().getBean(DeviceModelProvider.class);
	}
	
	@Override
	public IModelProvider<DeviceModel, Integer> getProvider() {
		return pro;
	}

	@Override
	protected DeviceDAO getDao() {
		return dao;
	}
}
