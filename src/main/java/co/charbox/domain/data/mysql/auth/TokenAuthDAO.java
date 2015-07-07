package co.charbox.domain.data.mysql.auth;

import java.util.List;

import org.joda.time.DateTime;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.SelectWhereStep;
import org.jooq.Table;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.jooq.tables.TokenAuth;
import co.charbox.domain.data.jooq.tables.records.TokenAuthRecord;
import co.charbox.domain.model.auth.TokenAuthModel;

import com.google.common.collect.Lists;
import com.tpofof.core.data.dao.ResultsSet;
import com.tpofof.core.data.dao.context.SimpleSearchContext;
import com.tpofof.core.data.dao.jdbc.AbstractSimpleJooqDAO;

@Component
public class TokenAuthDAO extends AbstractSimpleJooqDAO<TokenAuthModel, Integer, SimpleSearchContext> {

	public static final String ALIAS = "ta";
	
	private final TokenAuth ta = TokenAuth.TOKEN_AUTH.as(ALIAS);
	private final List<Field<?>> fields = Lists.newArrayList(ta.fields());
	
	@Override
	protected Table<?> getTable() {
		return ta;
	}

	@Override
	protected Table<?> getRawTable() {
		return TokenAuth.TOKEN_AUTH;
	}

	@Override
	protected Field<Integer> getPk() {
		return ta.ID;
	}
	
	@Override
	public List<Field<?>> getFields() {
		return fields;
	}

	@Override
	protected SelectWhereStep<Record> getBaseQuery() {
		return db().select(getFields()).from(ta);
	}
	
	public TokenAuthModel find(TokenAuthModel model) {
		return convert(getBaseQuery()
				.where(ta.ASSET_ID.eq(model.getAuthAssetId())
						.and(ta.SERVICE_NAME.eq(model.getServiceName()))
						.and(ta.TOKEN.eq(model.getToken())))
				.fetchOne());
	}
	
	public TokenAuthModel findByToken(String token) {
		return convert(getBaseQuery()
				.where(ta.TOKEN.eq(token))
				.fetchOne());
	}
	
	public ResultsSet<TokenAuthModel> findExpired(SimpleSearchContext context) {
		return convert(getBaseQuery()
				.where(ta.EXPIRATION.lt(safe(new DateTime())))
				.fetch(), context);
	}

	@Override
	protected Record convert(TokenAuthModel model) {
		return new TokenAuthRecord(model.getId(), 
				safe(model.getExpiration()), 
				model.getToken(), 
				model.getAuthAssetId(), 
				model.getServiceName());
	}

	@Override
	public TokenAuthModel convert(Record rec) {
		return rec == null ? null : TokenAuthModel.builder()
				.authAssetId(rec.getValue(ta.ASSET_ID))
				.expiration(safeToDateTime(rec.getValue(ta.EXPIRATION)))
				.id(rec.getValue(ta.ID))
				.serviceName(rec.getValue(ta.SERVICE_NAME))
				.token(rec.getValue(ta.TOKEN))
				.build();
	}
}
