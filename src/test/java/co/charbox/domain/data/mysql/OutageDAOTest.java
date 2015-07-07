package co.charbox.domain.data.mysql;

import static org.junit.Assert.*;

import java.util.Set;

import org.elasticsearch.common.collect.Sets;
import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.DeviceModel;
import co.charbox.domain.model.OutageModel;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.ResultsSet;

@Component
public class OutageDAOTest extends CharbotSimpleJooqDaoTest<OutageModel> {

	private static DaoProvider daoProvider;
	private static OutageDAO dao;
	private static DeviceModel device;
	private static ConnectionInfoDAOTest ciDaoTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoProvider = App.getContext().getBean(DaoProvider.class);
		dao = App.getContext().getBean(OutageDAO.class);
		
		DeviceDAOTest.setUpBeforeClass();
		DeviceDAOTest deviceDaoTest = App.getContext().getBean(DeviceDAOTest.class);
		device = daoProvider.getDeviceDAO().insert(deviceDaoTest.getModel(null));
		
		ConnectionInfoDAOTest.setUpBeforeClass();
		ciDaoTest = App.getContext().getBean(ConnectionInfoDAOTest.class);
		
	}

	@Override
	public OutageModel getModel(Integer id) {
		DateTime time = new DateTime();
		time = time.minusMillis(time.getMillisOfSecond());
		return OutageModel.builder()
				.confirmed(false)
				.connectionInfo(ciDaoTest.getModel(null))
				.device(device)
				.duration(10)
				.endTime(time)
				.id(id)
				.startTime(time)
				.type("unknown")
				.build();
	}

	@Override
	protected OutageDAO getDao() {
		return dao;
	}
	
	@Test
	public void testFindByDeviceIdEmpty() {
		assertEquals(0, getDao().count(getContext()));
		
		ResultsSet<OutageModel> res = getDao().findByDeviceId(getContext(), device.getId());
		assertEquals(0, res.getTotal().intValue());
		assertEquals(0, res.getResults().size());
	}
	
	@Test
	public void testFindByDeviceIdSingle() {
		assertEquals(0, getDao().count(getContext()));
		
		OutageModel expected = getDao().insert(getModel(null));
		assertNotNull(expected);
		
		ResultsSet<OutageModel> res = getDao().findByDeviceId(getContext(), expected.getDevice().getId());
		assertEquals(1, res.getTotal().intValue());
		assertEquals(1, res.getResults().size());
		assertEquals(expected, res.getResults().get(0));
		
		getDao().delete(expected.getId());
		res = getDao().findByDeviceId(getContext(), expected.getDevice().getId());
		assertEquals(0, res.getTotal().intValue());
		assertEquals(0, res.getResults().size());
	}
	
	@Test
	public void testFindByDeviceIdMultiple() {
		assertEquals(0, getDao().count(getContext()));
		
		Set<Integer> expectedIds = Sets.newHashSet();
		for (int i=0;i<10;i++) {
			OutageModel expected = getDao().insert(getModel(null));
			assertNotNull(expected);
			expectedIds.add(expected.getId());
		}
		
		ResultsSet<OutageModel> res = getDao().findByDeviceId(getContext(), device.getId());
		assertEquals(10, res.getTotal().intValue());
		assertEquals(10, res.getResults().size());
		Set<Integer> actualIds = Sets.newHashSet();
		for (OutageModel m : res.getResults()) {
			assertNotNull(m);
			actualIds.add(m.getId());
		}
		
		assertEquals(expectedIds.size(), actualIds.size());
		String errorMessage = "expected: " + expectedIds + " actual: " + actualIds;
		for (Integer id : expectedIds) {
			assertTrue(errorMessage, actualIds.contains(id));
		}
	}
}
