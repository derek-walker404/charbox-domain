package co.charbox.domain.data.mysql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.elasticsearch.common.collect.Sets;
import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.DeviceModel;
import co.charbox.domain.model.PingResultModel;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.ResultsSet;

@Component
public class PingResultsDAOTest extends CharbotSimpleJooqDaoTest<PingResultModel> {

	private static DaoProvider daoProvider;
	private static PingResultsDAO dao;
	private static DeviceModel device;
	private static ConnectionInfoDAOTest ciDaoTest;
	private static SimpleLocationDaoTest slDaoTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoProvider = App.getContext().getBean(DaoProvider.class);
		dao = daoProvider.getPingResultsDAO();
		
		device = App.getContext().getBean(DeviceDAOTest.class).getModel(null);
		device = daoProvider.getDeviceDAO().insert(device);
		if (device == null || device.getId() == null) {
			throw new RuntimeException("Cannot insert device to test ping results");
		}
		
		ConnectionInfoDAOTest.setUpBeforeClass();
		ciDaoTest = App.getContext().getBean(ConnectionInfoDAOTest.class);
		
		SimpleLocationDaoTest.setUpBeforeClass();;
		slDaoTest = App.getContext().getBean(SimpleLocationDaoTest.class);
	}

	@Override
	public PingResultModel getModel(Integer id) {
		DateTime time = new DateTime();
		time = time.minusMillis(time.getMillisOfSecond());
		return PingResultModel.builder()
				.avgLatency(15.12)
				.connectionInfo(ciDaoTest.getModel(null))
				.device(device)
				.id(id)
				.maxLatency(214.34)
				.minLatency(4.66)
				.packetLoss(0.0)
				.serverLocation(slDaoTest.getModel(null))
				.startTime(time)
				.uri("https://www.google.com")
				.build();
	}

	@Override
	protected PingResultsDAO getDao() {
		return dao;
	}
	
	@Test
	public void testFindByDeviceIdEmpty() {
		assertEquals(0, getDao().count(getContext()));
		
		ResultsSet<PingResultModel> res = getDao().findByDeviceId(getContext(), device.getId());
		assertEquals(0, res.getTotal().intValue());
		assertEquals(0, res.getResults().size());
	}
	
	@Test
	public void testFindByDeviceIdSingle() {
		assertEquals(0, getDao().count(getContext()));
		
		PingResultModel expected = getDao().insert(getModel(null));
		assertNotNull(expected);
		
		ResultsSet<PingResultModel> res = getDao().findByDeviceId(getContext(), expected.getDevice().getId());
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
			PingResultModel expected = getDao().insert(getModel(null));
			assertNotNull(expected);
			expectedIds.add(expected.getId());
		}
		
		ResultsSet<PingResultModel> res = getDao().findByDeviceId(getContext(), device.getId());
		assertEquals(10, res.getTotal().intValue());
		assertEquals(10, res.getResults().size());
		Set<Integer> actualIds = Sets.newHashSet();
		for (PingResultModel m : res.getResults()) {
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