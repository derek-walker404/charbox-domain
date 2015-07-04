package co.charbox.domain.data.mysql;

import org.springframework.stereotype.Component;

import com.tpofof.core.App;

@Component
public class DaoProvider {

	public DeviceDAO getDeviceDAO() {
		return App.getContext().getBean(DeviceDAO.class);
	}
	
	public DeviceConfigurationDAO getDeviceConfigurationDAO() {
		return App.getContext().getBean(DeviceConfigurationDAO.class);
	}
	
	public DeviceVersionDAO getDeviceVersionDAO() {
		return App.getContext().getBean(DeviceVersionDAO.class);
	}
	
	public HeartbeatDAO getHeartbeatDAO() {
		return App.getContext().getBean(HeartbeatDAO.class);
	}

	public ConnectionInfoDAO getConnectionInfoDAO() {
		return App.getContext().getBean(ConnectionInfoDAO.class);
	}

	public ConnectionDAO getConnectionDAO() {
		return App.getContext().getBean(ConnectionDAO.class);
	}

	public LocationDAO getLocationDAO() {
		return App.getContext().getBean(LocationDAO.class);
	}

	public SimpleLocationDAO getSimpleLocationDAO() {
		return App.getContext().getBean(SimpleLocationDAO.class);
	}

	public PingResultsDAO getPingResultsDAO() {
		return App.getContext().getBean(PingResultsDAO.class);
	}

	public SstResultsDAO getSstResultsDAO() {
		return App.getContext().getBean(SstResultsDAO.class);
	}
}
