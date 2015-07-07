package co.charbox.domain.providers;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.charbox.domain.data.mysql.DeviceDAO;
import co.charbox.domain.model.DeviceModel;
import co.charbox.domain.model.SstResultsModel;

@Component
public class SstResultsModelProvider implements CharbotModelProvider<SstResultsModel> {

	private DeviceModel device;
	@Autowired private DeviceDAO deviceDao;
	@Autowired private DeviceModelProvider devicePro;
	@Autowired private ConnectionInfoModelProvider ciPro;
	@Autowired private SimpleLocationModelProvider slPro;
	
	@Override
	public SstResultsModel getModel(Integer id) {
		DateTime time = new DateTime();
		time = time.minusMillis(time.getMillisOfSecond());
		return SstResultsModel.builder()
				.device(device)
				.deviceInfo(ciPro.getModel(null))
				.deviceToken("ASDGSDFHG%ERG!#$$FQERG!#QFQ")
				.downloadDuration(3001)
				.downloadSize(87567653425L)
				.downloadSpeed(56.234)
				.id(id)
				.pingDuration(28)
				.serverLocation(slPro.getModel(null))
				.startTime(time)
				.uploadDuration(3002)
				.uploadSize(34524323466L)
				.uploadSpeed(12.544)
				.build();
	}
	
	public DeviceModel getDevice() {
		if (device == null || deviceDao.find(device.getId()) == null) {
			device = deviceDao.insert(devicePro.getModel(null));
		}
		return device;
	}
}
