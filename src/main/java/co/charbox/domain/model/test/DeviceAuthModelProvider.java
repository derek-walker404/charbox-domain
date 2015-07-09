package co.charbox.domain.model.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.mysql.DeviceDAO;
import co.charbox.domain.model.DeviceModel;
import co.charbox.domain.model.auth.DeviceAuthModel;

@Component
public class DeviceAuthModelProvider implements CharbotModelProvider<DeviceAuthModel> {

	@Autowired private DeviceModelProvider devicePro; // TODO
	@Autowired private DeviceDAO deviceDao;
	
	@Override
	public DeviceAuthModel getModel(Integer id) {
		DeviceModel device = deviceDao.insert(devicePro.getModel(null));
		return DeviceAuthModel.builder()
				.activated(true)
				.deviceId(device.getId())
				.id(id)
				.key("key1234")
				.build();
	}
}
