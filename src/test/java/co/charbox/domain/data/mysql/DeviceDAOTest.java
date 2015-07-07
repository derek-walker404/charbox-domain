package co.charbox.domain.data.mysql;

import org.junit.BeforeClass;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.DeviceModel;

import com.tpofof.core.App;

@Component
public class DeviceDAOTest extends CharbotSimpleJooqDaoTest<DeviceModel> {

	private static DeviceDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(DeviceDAO.class);
	}

	@Override
	public DeviceModel getModel(Integer id) {
		return DeviceModel.builder()
				.id(id)
				.name("testName")
				.build();
	}

	@Override
	protected DeviceDAO getDao() {
		return dao;
	}
}
