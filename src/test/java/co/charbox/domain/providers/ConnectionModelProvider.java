package co.charbox.domain.providers;

import org.springframework.stereotype.Component;

import co.charbox.domain.model.mm.ConnectionModel;

@Component
public class ConnectionModelProvider implements CharbotModelProvider<ConnectionModel> {

	@Override
	public ConnectionModel getModel(Integer id) {
		return ConnectionModel.builder()
				.expectedSpeed(50.0)
				.id(id)
				.ip("127.0.0.1")
				.isp("Comcast Communications")
				.build();
	}
}
