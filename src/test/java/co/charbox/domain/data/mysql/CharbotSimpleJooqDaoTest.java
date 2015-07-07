package co.charbox.domain.data.mysql;

import org.junit.Before;

import com.tpofof.core.data.IPersistentModel;
import com.tpofof.core.data.dao.context.SearchWindow;
import com.tpofof.core.data.dao.context.SimpleSearchContext;
import com.tpofof.core.data.dao.jdbc.AbstractSimpleJooqDAO;
import com.tpofof.core.data.dao.test.AbstractSimpleJooqDaoTest;

public abstract class CharbotSimpleJooqDaoTest<ModelT extends IPersistentModel<ModelT, Integer>> 
		extends AbstractSimpleJooqDaoTest<ModelT, Integer, AbstractSimpleJooqDAO<ModelT, Integer, SimpleSearchContext>, SimpleSearchContext> {

	@Before
	public void setUp() throws Exception {
		getDao().truncate();
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
		return (int)(Math.random() * Integer.MAX_VALUE);
	}
}
