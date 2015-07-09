package co.charbox.domain.model.test;

import org.springframework.stereotype.Component;

import co.charbox.domain.model.mm.SimpleLocationModel;

@Component
public class SimpleLocationModelProvider implements CharbotModelProvider<SimpleLocationModel> {

	@Override
	public SimpleLocationModel getModel(Integer id) {
		return SimpleLocationModel.builder()
				.id(id)
				.ip("127.0.0.1")
				.lat(100.0)
				.lon(-100.0)
				.build();
	}
}
