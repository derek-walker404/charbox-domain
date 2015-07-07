package co.charbox.domain.providers;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.mysql.DeviceDAO;
import co.charbox.domain.model.DeviceModel;
import co.charbox.domain.model.OutageModel;

@Component
public class OutageModelProvider implements CharbotModelProvider<OutageModel> {

	private DeviceModel device;
	@Autowired private DeviceDAO deviceDao;
	@Autowired private DeviceModelProvider devicePro;
	@Autowired private ConnectionInfoModelProvider ciPro;
	
	@Override
	public OutageModel getModel(Integer id) {
		DateTime time = new DateTime();
		time = time.minusMillis(time.getMillisOfSecond());
		return OutageModel.builder()
				.confirmed(false)
				.connectionInfo(ciPro.getModel(null))
				.device(getDevice())
				.duration(10)
				.endTime(time)
				.id(id)
				.startTime(time)
				.type("unknown")
				.build();
	}
	
	public DeviceModel getDevice() {
		if (device == null || deviceDao.find(device.getId()) == null) {
			device = deviceDao.insert(devicePro.getModel(null));
		}
		return device;
	}
}
