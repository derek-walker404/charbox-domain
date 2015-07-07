package co.charbox.domain.providers;

import org.springframework.stereotype.Component;

import co.charbox.domain.model.DeviceVersionModel;

@Component
public class DeviceVersionModelProvider implements CharbotModelProvider<DeviceVersionModel> {

	@Override
	public DeviceVersionModel getModel(Integer id) {
		return DeviceVersionModel.builder()
				.id(id)
				.installScriptUrl("https://cdn.aws.com/install/scripts/test.sh")
				.version("0.0.0")
				.build();
	}
}
