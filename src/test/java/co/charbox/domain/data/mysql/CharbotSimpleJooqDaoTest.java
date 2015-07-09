package co.charbox.domain.data.mysql;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.tpofof.core.App;
import com.tpofof.core.data.IPersistentModel;
import com.tpofof.core.data.dao.context.SearchWindow;
import com.tpofof.core.data.dao.context.SimpleSearchContext;
import com.tpofof.core.data.dao.jdbc.AbstractSimpleJooqDAO;
import com.tpofof.core.data.dao.jdbc.JooqConnectionProvider;
import com.tpofof.core.data.dao.test.AbstractSimpleJooqDaoTest;
import com.tpofof.core.utils.Config;

public abstract class CharbotSimpleJooqDaoTest<ModelT extends IPersistentModel<ModelT, Integer>> 
		extends AbstractSimpleJooqDaoTest<ModelT, Integer, AbstractSimpleJooqDAO<ModelT, Integer, SimpleSearchContext>, SimpleSearchContext> {

	private static JooqConnectionProvider connPro;
	private static Config config;
	
	@BeforeClass
	public static void abstractSetUpBeforeClass() {
		config = App.getContext().getBean(Config.class);
		connPro = App.getContext().getBean(JooqConnectionProvider.class);
		System.out.println("db.url: " + config.getString("db.url"));
		System.out.println("db.test.name: " + config.getString("db.test.name"));
		connPro.configure(config.getString("db.test.url.base"), 
				config.getString("db.test.name"),
				config.getString("db.params"),
				config.getString("db.test.username"), 
				config.getString("db.test.password"));
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
	
	@AfterClass
	public static void cleanUpAfterClass() {
		connPro.dropDatabase();
	}
}
