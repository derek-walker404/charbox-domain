package co.charbox.domain.data.mysql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.elasticsearch.common.collect.Sets;
import org.joda.time.DateTime;
import org.junit.BeforeClass;
import org.junit.Test;

import co.charbox.domain.model.DeviceModel;
import co.charbox.domain.model.SstResultsModel;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.ResultsSet;

public class SstResultsDAOTest extends CharbotSimpleJooqDaoTest<SstResultsModel> {

	private static DaoProvider daoProvider;
	private static SstResultsDAO dao;
	private static DeviceModel device;
	private static ConnectionInfoDAOTest ciDaoTest;
	private static SimpleLocationDaoTest slDaoTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoProvider = App.getContext().getBean(DaoProvider.class);
		dao = daoProvider.getSstResultsDAO();
		
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
	public SstResultsModel getModel(Integer id) {
		DateTime time = new DateTime();
		time = time.minusMillis(time.getMillisOfSecond());
		return SstResultsModel.builder()
				.device(device)
				.deviceInfo(ciDaoTest.getModel(null))
				.deviceToken("ASDGSDFHG%ERG!#$$FQERG!#QFQ")
				.downloadDuration(3001)
				.downloadSize(87567653425L)
				.downloadSpeed(56.234)
				.id(id)
				.pingDuration(28)
				.serverLocation(slDaoTest.getModel(null))
				.startTime(time)
				.uploadDuration(3002)
				.uploadSize(34524323466L)
				.uploadSpeed(12.544)
				.build();
	}

	@Override
	protected SstResultsDAO getDao() {
		return dao;
	}
	
	@Test
	public void testFindByDeviceIdEmpty() {
		assertEquals(0, getDao().count(getContext()));
		
		ResultsSet<SstResultsModel> res = getDao().findByDeviceId(getContext(), device.getId());
		assertEquals(0, res.getTotal().intValue());
		assertEquals(0, res.getResults().size());
	}
	
	@Test
	public void testFindByDeviceIdSingle() {
		assertEquals(0, getDao().count(getContext()));
		
		SstResultsModel expected = getDao().insert(getModel(null));
		assertNotNull(expected);
		
		ResultsSet<SstResultsModel> res = getDao().findByDeviceId(getContext(), expected.getDevice().getId());
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
			SstResultsModel expected = getDao().insert(getModel(null));
			assertNotNull(expected);
			expectedIds.add(expected.getId());
		}
		
		ResultsSet<SstResultsModel> res = getDao().findByDeviceId(getContext(), device.getId());
		assertEquals(10, res.getTotal().intValue());
		assertEquals(10, res.getResults().size());
		Set<Integer> actualIds = Sets.newHashSet();
		for (SstResultsModel m : res.getResults()) {
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
