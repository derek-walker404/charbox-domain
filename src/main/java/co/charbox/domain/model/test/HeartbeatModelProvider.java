package co.charbox.domain.model.test;

import java.sql.Timestamp;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.mysql.DeviceDAO;
import co.charbox.domain.model.DeviceModel;
import co.charbox.domain.model.HeartbeatModel;

@Component
public class HeartbeatModelProvider implements CharbotModelProvider<HeartbeatModel> {

	private DeviceModel device;
	@Autowired private DeviceDAO deviceDao;
	@Autowired private DeviceModelProvider devicePro;
	@Autowired private ConnectionInfoModelProvider ciPro;
	
	@Override
	public HeartbeatModel getModel(Integer id) {
		if (device == null || deviceDao.find(device.getId()) == null) {
			device = deviceDao.insert(devicePro.getModel(null));
		}
		DateTime time = new DateTime(new Timestamp(System.currentTimeMillis()));
		time = time.minusMillis((int)time.getMillisOfSecond());
		return HeartbeatModel.builder()
				.id(id)
				.device(device)
				.time(time)
				.connection(ciPro.getModel(null))
				.build();
	}
}
