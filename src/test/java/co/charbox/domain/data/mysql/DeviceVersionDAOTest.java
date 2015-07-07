package co.charbox.domain.data.mysql;

import org.junit.BeforeClass;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.DeviceVersionModel;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.context.SimpleSearchContext;
import com.tpofof.core.data.dao.jdbc.AbstractSimpleJooqDAO;

@Component
public class DeviceVersionDAOTest extends CharbotSimpleJooqDaoTest<DeviceVersionModel> {

	private static DeviceVersionDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(DeviceVersionDAO.class);
	}

	@Override
	public DeviceVersionModel getModel(Integer id) {
		return DeviceVersionModel.builder()
				.id(id)
				.installScriptUrl("https://cdn.aws.com/install/scripts/test.sh")
				.version("0.0.0")
				.build();
	}

	@Override
	protected AbstractSimpleJooqDAO<DeviceVersionModel, Integer, SimpleSearchContext> getDao() {
		return dao;
	}
}
