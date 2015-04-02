package co.charbox.domain.model.mm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyCharboxConnection {

	private String isp;
	private String ip;
	private boolean anonProxy;
	private boolean satelliteProvider;
	private String conType = "N/A";
	private double expectedSpeed = 50; // Mbps

	@JsonProperty
	public String getIsp() {
		return isp;
	}

	@JsonProperty
	public MyCharboxConnection setIsp(String isp) {
		this.isp = isp;
		return this;
	}

	@JsonProperty
	public String getIp() {
		return ip;
	}

	@JsonProperty
	public MyCharboxConnection setIp(String ip) {
		this.ip = ip;
		return this;
	}

	@JsonProperty
	public boolean isAnonProxy() {
		return anonProxy;
	}

	@JsonProperty
	public MyCharboxConnection setAnonProxy(boolean anonProxy) {
		this.anonProxy = anonProxy;
		return this;
	}

	@JsonProperty
	public boolean isSatelliteProvider() {
		return satelliteProvider;
	}

	@JsonProperty
	public MyCharboxConnection setSatelliteProvider(boolean satelliteProvider) {
		this.satelliteProvider = satelliteProvider;
		return this;
	}

	@JsonProperty
	public String getConType() {
		return conType;
	}

	@JsonProperty
	public MyCharboxConnection setConType(String type) {
		this.conType = type;
		return this;
	}

	@JsonProperty
	public double getExpectedSpeed() {
		return expectedSpeed;
	}

	@JsonProperty
	public MyCharboxConnection setExpectedSpeed(double expectedSpeed) {
		this.expectedSpeed = expectedSpeed;
		return this;
	}
}
