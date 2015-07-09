package co.charbox.domain.data.mysql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.elasticsearch.common.collect.Sets;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.DeviceModel;
import co.charbox.domain.model.OutageModel;
import co.charbox.domain.model.test.OutageModelProvider;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.ResultsSet;

@Component
public class OutageDAOTest extends CharbotSimpleJooqDaoTest<OutageModel> {

	private static OutageDAO dao;
	private static OutageModelProvider pro;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(OutageDAO.class);
		pro = App.getContext().getBean(OutageModelProvider.class);
	}

	@Override
	protected OutageDAO getDao() {
		return dao;
	}

	@Override
	public OutageModelProvider getProvider() {
		return pro;
	}
	
	@Test
	public void testFindByDeviceIdEmpty() {
		assertEquals(0, getDao().count(getContext()));
		
		DeviceModel device = getProvider().getDevice();
		ResultsSet<OutageModel> res = getDao().findByDeviceId(getContext(), device.getId());
		assertEquals(0, res.getTotal().intValue());
		assertEquals(0, res.getResults().size());
	}
	
	@Test
	public void testFindByDeviceIdSingle() {
		assertEquals(0, getDao().count(getContext()));
		
		OutageModel expected = getDao().insert(getProvider().getModel(null));
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
			OutageModel expected = getDao().insert(getProvider().getModel(null));
			assertNotNull(expected);
			expectedIds.add(expected.getId());
		}
		
		ResultsSet<OutageModel> res = getDao().findByDeviceId(getContext(), getProvider().getDevice().getId());
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
