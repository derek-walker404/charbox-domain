package co.charbox.domain.data.mysql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.elasticsearch.common.collect.Sets;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.PingResultModel;
import co.charbox.domain.providers.PingResultsModelProvider;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.ResultsSet;

@Component
public class PingResultsDAOTest extends CharbotSimpleJooqDaoTest<PingResultModel> {

	private static PingResultsDAO dao;
	private static PingResultsModelProvider pro;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		dao = App.getContext().getBean(PingResultsDAO.class);
		pro = App.getContext().getBean(PingResultsModelProvider.class);
	}

	@Override
	protected PingResultsDAO getDao() {
		return dao;
	}

	@Override
	public PingResultsModelProvider getProvider() {
		return pro;
	}
	
	@Test
	public void testFindByDeviceIdEmpty() {
		assertEquals(0, getDao().count(getContext()));
		
		ResultsSet<PingResultModel> res = getDao().findByDeviceId(getContext(), getProvider().getDevice().getId());
		assertEquals(0, res.getTotal().intValue());
		assertEquals(0, res.getResults().size());
	}
	
	@Test
	public void testFindByDeviceIdSingle() {
		assertEquals(0, getDao().count(getContext()));
		
		PingResultModel expected = getDao().insert(getProvider().getModel(null));
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
			PingResultModel expected = getDao().insert(getProvider().getModel(null));
			assertNotNull(expected);
			expectedIds.add(expected.getId());
		}
		
		ResultsSet<PingResultModel> res = getDao().findByDeviceId(getContext(), getProvider().getDevice().getId());
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