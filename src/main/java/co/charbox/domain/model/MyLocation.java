package co.charbox.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyLocation {

	private String ip;
	private double[] location = new double[2];

	@JsonProperty
	public String getIp() {
		return ip;
	}

	@JsonProperty
	public MyLocation setIp(String ip) {
		this.ip = ip;
		return this;
	}

	@JsonProperty
	public double[] getLocation() {
		return location;
	}

	@JsonProperty
	public MyLocation setLocation(double[] location) {
		this.location = location;
		return this;
	}

	public MyLocation setLat(double lat) {
		getLocation()[0] = lat;
		return this;
	}

	public MyLocation setLon(double lon) {
		getLocation()[1] = lon;
		return this;
	}
}
