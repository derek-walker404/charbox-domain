package co.charbox.domain.data.mysql;

import org.jooq.Record;
import org.jooq.SelectWhereStep;

import co.charbox.domain.data.CharbotSearchContext;

import com.tpofof.core.data.IPersistentModel;
import com.tpofof.core.data.dao.jdbc.AbstractSimpleJooqDAO;

public abstract class CharbotJooqDao<ModelT extends IPersistentModel<ModelT, Integer>> extends AbstractSimpleJooqDAO<ModelT, Integer, CharbotSearchContext> {

	@Override
	protected SelectWhereStep<Record> getBaseQuery() {
		return db().select(getFields()).from(getTable());
	}
}
