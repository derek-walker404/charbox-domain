package co.charbox.domain.data.mysql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.elasticsearch.common.collect.Sets;
import org.junit.BeforeClass;
import org.junit.Test;

import co.charbox.domain.model.SstResultsModel;
import co.charbox.domain.providers.SstResultsModelProvider;

import com.tpofof.core.App;
import com.tpofof.core.data.dao.ResultsSet;

public class SstResultsDAOTest extends CharbotSimpleJooqDaoTest<SstResultsModel> {

	private static SstResultsDAO dao;
	private static SstResultsModelProvider pro;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = App.getContext().getBean(SstResultsDAO.class);
		pro = App.getContext().getBean(SstResultsModelProvider.class);
	}

	@Override
	protected SstResultsDAO getDao() {
		return dao;
	}
	
	@Override
	public SstResultsModelProvider getProvider() {
		return pro;
	}
	
	@Test
	public void testFindByDeviceIdEmpty() {
		assertEquals(0, getDao().count(getContext()));
		
		ResultsSet<SstResultsModel> res = getDao().findByDeviceId(getContext(), getProvider().getDevice().getId());
		assertEquals(0, res.getTotal().intValue());
		assertEquals(0, res.getResults().size());
	}
	
	@Test
	public void testFindByDeviceIdSingle() {
		assertEquals(0, getDao().count(getContext()));
		
		SstResultsModel expected = getDao().insert(getProvider().getModel(null));
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
			SstResultsModel expected = getDao().insert(getProvider().getModel(null));
			assertNotNull(expected);
			expectedIds.add(expected.getId());
		}
		
		ResultsSet<SstResultsModel> res = getDao().findByDeviceId(getContext(), getProvider().getDevice().getId());
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
