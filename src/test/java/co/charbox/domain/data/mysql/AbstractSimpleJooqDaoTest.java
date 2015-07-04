package co.charbox.domain.data.mysql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.Serializable;

import org.apache.commons.lang.NotImplementedException;
import org.junit.Before;
import org.junit.Test;

import com.tpofof.core.data.IPersistentModel;
import com.tpofof.core.data.dao.ResultsSet;
import com.tpofof.core.data.dao.context.ISearchContext;
import com.tpofof.core.data.dao.jdbc.AbstractSimpleJooqDAO;

public abstract class AbstractSimpleJooqDaoTest<ModelT extends IPersistentModel<ModelT, PrimaryKeyT>, PrimaryKeyT extends Serializable, ModelDaoT extends AbstractSimpleJooqDAO<ModelT, PrimaryKeyT, SearchContextT>, SearchContextT extends ISearchContext> {

	protected SearchContextT getContext() {
		return getContext(100, 0);
	}
	
	protected abstract SearchContextT getContext(int limit, int offset);
	
	public abstract PrimaryKeyT getRandomPk();
	
	public abstract ModelT getModel(PrimaryKeyT id);
	
	protected abstract ModelDaoT getDao();
	
	@Before
	public void beforeTest() {
		getDao().truncate();
	}
	
	@Test
	public void testCount() {
		assertEquals(0, getDao().count(getContext()));
		assertNotNull(getDao().insert(getModel(null)));
		
		assertEquals(1, getDao().count(getContext()));
		
		assertNotNull(getDao().insert(getModel(null)));
		assertNotNull(getDao().insert(getModel(null)));
		
		assertEquals(3, getDao().count(getContext()));
	}

	@Test
	public void testFindPrimaryKeyT() {
		PrimaryKeyT id = getRandomPk();
		assertNull(getDao().find(id));
		
		assertNotNull(getDao().insert(getModel(id)));
		
		assertNotNull(getDao().find(id));
	}

	@Test
	public void testFindSearchContextT() {
		SearchContextT context = getContext();
		ResultsSet<ModelT> res = getDao().find(context);
		assertNotNull(res);
		assertNotNull(res.getResults());
		assertTrue(res.getResults().isEmpty());
		assertEquals(context.getWindow().getLimit(), (int)res.getLimit());
		assertEquals(context.getWindow().getOffset(), (int)res.getOffset());
		assertEquals(0, (long)res.getTotal());
		
		assertNotNull(getDao().insert(getModel(getRandomPk())));
		assertNotNull(getDao().insert(getModel(getRandomPk())));
		assertNotNull(getDao().insert(getModel(getRandomPk())));
		assertNotNull(getDao().insert(getModel(getRandomPk())));
		
		res = getDao().find(context);
		assertNotNull(res);
		assertNotNull(res.getResults());
		assertEquals(4, res.getResults().size());
		assertEquals(4, (long)res.getTotal());
		
		context = getContext(3, 0);
		res = getDao().find(context);
		assertNotNull(res);
		assertNotNull(res.getResults());
		assertEquals(3, res.getResults().size());
		assertEquals(context.getWindow().getLimit(), (int)res.getLimit());
		assertEquals(context.getWindow().getOffset(), (int)res.getOffset());
		assertEquals(4, (long)res.getTotal());
		
		context = getContext(3, 3);
		res = getDao().find(context);
		assertNotNull(res);
		assertNotNull(res.getResults());
		assertEquals(1, res.getResults().size());
		assertEquals(context.getWindow().getLimit(), (int)res.getLimit());
		assertEquals(context.getWindow().getOffset(), (int)res.getOffset());
		assertEquals(4, (long)res.getTotal());
		
		context = getContext(3, 6);
		res = getDao().find(context);
		assertNotNull(res);
		assertNotNull(res.getResults());
		assertEquals(0, res.getResults().size());
		assertEquals(context.getWindow().getLimit(), (int)res.getLimit());
		assertEquals(context.getWindow().getOffset(), (int)res.getOffset());
		assertEquals(4, (long)res.getTotal());
	}

	@Test
	public void testInsert() {
		assertEquals(0, getDao().count(getContext()));
		ModelT model = getModel(null);
		ModelT inserted = getDao().insert(model);
		assertEquals(1, getDao().count(getContext()));
		assertNotNull(inserted);
		assertNotNull(inserted.getId());
		model.setId(inserted.getId());
		assertEquals(model, inserted);
		assertEquals(model, getDao().find(inserted.getId()));
		
		model = getModel(getRandomPk());
		inserted = getDao().insert(model);
		assertNotNull(inserted);
		assertEquals(model, inserted);
		assertEquals(model, getDao().find(inserted.getId()));
	}

	@SuppressWarnings("deprecation")
	@Test(expected=NotImplementedException.class)
	public void testUpdate() {
		getDao().update(null);
	}

	@Test
	public void testDelete() {
		assertEquals(0, getDao().count(getContext()));
		for (int i=0;i<10;i++) {
			assertNotNull(getDao().insert(getModel(null)));
		}
		assertEquals(10, getDao().count(getContext()));
		ResultsSet<ModelT> res = getDao().find(getContext());
		for (ModelT m : res.getResults()) {
			assertNotNull(getDao().find(m.getId()));
			assertTrue(getDao().delete(m.getId()));
			assertNull(getDao().find(m.getId()));
		}
		assertEquals(0, getDao().count(getContext()));
	}

	@Test
	public void testTruncate() {
		assertEquals(0, getDao().count(getContext()));
		for (int i=0;i<10;i++) {
			assertNotNull(getDao().insert(getModel(null)));
		}
		assertEquals(10, getDao().count(getContext()));
		getDao().truncate();
		assertEquals(0, getDao().count(getContext()));
	}
}
