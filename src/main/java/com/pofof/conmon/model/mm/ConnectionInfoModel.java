package com.pofof.conmon.model.mm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maxmind.geoip2.model.InsightsResponse;

public class ConnectionInfoModel {
	
	private MyCharboxLocation location;
	private MyCharboxConnection connection;
	
	public ConnectionInfoModel() { }
	
	public ConnectionInfoModel(InsightsResponse insights) {
		this.location = new MyCharboxLocation()
			.setContinent(insights.getContinent().getName())
			.setCountry(insights.getCountry().getName())
			.setSubdivision(insights.getMostSpecificSubdivision().getName())
			.setZip(insights.getPostal().getCode())
			.setCity(insights.getCity().getName())
			.setLocation(new double[]{ insights.getLocation().getLatitude(), insights.getLocation().getLongitude() })
			.setTimeZone(insights.getLocation().getTimeZone());
		
		this.connection = new MyCharboxConnection()
			.setIp(insights.getTraits().getIpAddress())
			.setIsp(insights.getTraits().getIsp())
			.setAnonProxy(insights.getTraits().isAnonymousProxy())
			.setSatelliteProvider(insights.getTraits().isSatelliteProvider());
	}
	
	@JsonProperty
	public MyCharboxLocation getLocation() {
		return location;
	}

	@JsonProperty
	public ConnectionInfoModel setLocation(MyCharboxLocation location) {
		this.location = location;
		return this;
	}

	@JsonProperty
	public MyCharboxConnection getConnection() {
		return connection;
	}

	@JsonProperty
	public ConnectionInfoModel setConnection(MyCharboxConnection connection) {
		this.connection = connection;
		return this;
	}
}
