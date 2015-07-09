package co.charbox.domain.model.test;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.auth.TokenAuthModel;

@Component
public class TokenAuthModelProvider implements CharbotModelProvider<TokenAuthModel> {

	@Override
	public TokenAuthModel getModel(Integer id) {
		DateTime time = new DateTime();
		time = time.minusMillis(time.getMillisOfSecond());
		return TokenAuthModel.builder()
				.authAssetId(-1)
				.expiration(time)
				.id(id)
				.serviceName("sso")
				.token("token1234")
				.build();
	}

}
