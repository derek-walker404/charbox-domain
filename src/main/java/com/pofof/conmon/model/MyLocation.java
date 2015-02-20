package com.pofof.conmon.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyLocation {

	private double lat;
	private double lon;

	@JsonProperty
	public double getLat() {
		return lat;
	}

	@JsonProperty
	public MyLocation setLat(double lat) {
		this.lat = lat;
		return this;
	}

	@JsonProperty
	public double getLon() {
		return lon;
	}

	@JsonProperty
	public MyLocation setLon(double lon) {
		this.lon = lon;
		return this;
	}
}
