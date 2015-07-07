package co.charbox.domain.providers;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.mysql.DeviceDAO;
import co.charbox.domain.model.DeviceModel;
import co.charbox.domain.model.PingResultModel;

@Component
public class PingResultsModelProvider implements CharbotModelProvider<PingResultModel> {

	private DeviceModel device;
	@Autowired private DeviceDAO deviceDao;
	@Autowired private DeviceModelProvider devicePro;
	@Autowired private ConnectionInfoModelProvider ciPro;
	@Autowired private SimpleLocationModelProvider slPro;
	
	@Override
	public PingResultModel getModel(Integer id) {
		DateTime time = new DateTime();
		time = time.minusMillis(time.getMillisOfSecond());
		return PingResultModel.builder()
				.avgLatency(15.12)
				.connectionInfo(ciPro.getModel(null))
				.device(getDevice())
				.id(id)
				.maxLatency(214.34)
				.minLatency(4.66)
				.packetLoss(0.0)
				.serverLocation(slPro.getModel(null))
				.startTime(time)
				.uri("https://www.google.com")
				.build();
	}
	
	public DeviceModel getDevice() {
		if (device == null || deviceDao.find(device.getId()) == null) {
			device = deviceDao.insert(devicePro.getModel(null));
		}
		return device;
	}
}
