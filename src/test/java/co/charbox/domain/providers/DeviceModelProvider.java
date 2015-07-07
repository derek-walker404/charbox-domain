package co.charbox.domain.providers;

import org.springframework.stereotype.Component;

import co.charbox.domain.model.DeviceModel;

@Component
public class DeviceModelProvider implements CharbotModelProvider<DeviceModel> {

	@Override
	public DeviceModel getModel(Integer id) {
		return DeviceModel.builder()
				.id(id)
				.name("testName")
				.build();
	}
}
