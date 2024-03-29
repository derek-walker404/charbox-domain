package co.charbox.domain.model.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.mysql.DeviceDAO;
import co.charbox.domain.data.mysql.DeviceVersionDAO;
import co.charbox.domain.model.DeviceConfigurationModel;
import co.charbox.domain.model.DeviceModel;
import co.charbox.domain.model.DeviceVersionModel;

import com.google.common.collect.Maps;

@Component
public class DeviceConfigurationModelProvider implements CharbotModelProvider<DeviceConfigurationModel> {

	@Autowired private DeviceDAO deviceDao;
	@Autowired private DeviceModelProvider devicePro;
	@Autowired private DeviceVersionDAO verDao;
	@Autowired private DeviceVersionModelProvider verPro;
	private DeviceVersionModel version;
	
	@Autowired
	public DeviceConfigurationModelProvider(DeviceVersionDAO verDao, DeviceVersionModelProvider verPro) {
	}
	
	@Override
	public DeviceConfigurationModel getModel(Integer id) {
		DeviceModel device = deviceDao.insert(devicePro.getModel(null));
		return DeviceConfigurationModel.builder()
				.device(device)
				.id(id)
				.registered(true)
				.schedules(Maps.<String, String>newHashMap())
				.version(getDeviceVersion().getId())
				.build();
	}
	
	public DeviceVersionModel getDeviceVersion() {
		if (version == null) {
			version = verDao.insert(verPro.getModel(null));
		}
		return version;
	}
}
