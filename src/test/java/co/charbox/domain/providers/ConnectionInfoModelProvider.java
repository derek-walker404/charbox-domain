package co.charbox.domain.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.charbox.domain.model.mm.ConnectionInfoModel;

@Component
public class ConnectionInfoModelProvider implements CharbotModelProvider<ConnectionInfoModel> {

	@Autowired private ConnectionModelProvider connPro;
	@Autowired private LocationModelProvider locPro;
	
	@Override
	public ConnectionInfoModel getModel(Integer id) {
		return ConnectionInfoModel.builder()
				.id(id)
				.connection(connPro.getModel(null))
				.location(locPro.getModel(null))
				.build();
	}
}
