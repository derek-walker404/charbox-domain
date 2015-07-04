package co.charbox.domain.data.mysql;

import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.DeviceModel;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.context.SearchWindow;
import com.tpofof.core.data.dao.context.SimpleSearchContext;

@Component
public class DeviceDaoTest extends AbstractSimpleJooqDaoTest<DeviceModel, Integer, DeviceDAO, SimpleSearchContext> {

	private static DeviceDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(DeviceDAO.class);
	}

	@Before
	public void setUp() throws Exception {
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
