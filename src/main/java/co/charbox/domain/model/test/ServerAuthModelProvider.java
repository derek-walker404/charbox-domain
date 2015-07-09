package co.charbox.domain.model.test;

import org.springframework.stereotype.Component;

import co.charbox.domain.model.auth.ServerAuthModel;

@Component
public class ServerAuthModelProvider implements CharbotModelProvider<ServerAuthModel> {

	@Override
	public ServerAuthModel getModel(Integer id) {
		return ServerAuthModel.builder()
				.activated(true)
				.id(id)
				.key("key1234")
				.serverId("sso_east_" + System.currentTimeMillis())
				.serviceName("sso")
				.build();
	}
}
