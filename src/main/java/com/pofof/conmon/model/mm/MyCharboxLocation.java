package com.pofof.conmon.model.mm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyCharboxLocation {

	private String continent;
	private String country;
	private String city;
	private String subdivision;
	private String zip;
	private double[] location;
	private String timeZone;
	
	@JsonProperty
	public String getContinent() {
		return continent;
	}

	@JsonProperty
	public MyCharboxLocation setContinent(String continent) {
		this.continent = continent;
		return this;
	}

	@JsonProperty
	public String getCountry() {
		return country;
	}

	@JsonProperty
	public MyCharboxLocation setCountry(String country) {
		this.country = country;
		return this;
	}

	@JsonProperty
	public String getCity() {
		return city;
	}

	@JsonProperty
	public MyCharboxLocation setCity(String city) {
		this.city = city;
		return this;
	}

	@JsonProperty
	public String getSubdivision() {
		return subdivision;
	}

	@JsonProperty
	public MyCharboxLocation setSubdivision(String subdivision) {
		this.subdivision = subdivision;
		return this;
	}

	@JsonProperty
	public String getZip() {
		return zip;
	}

	@JsonProperty
	public MyCharboxLocation setZip(String zip) {
		this.zip = zip;
		return this;
	}

	@JsonProperty
	public double[] getLocation() {
		return location;
	}

	@JsonProperty
	public MyCharboxLocation setLocation(double[] location) {
		this.location = location;
		return this;
	}

	@JsonProperty
	public String getTimeZone() {
		return timeZone;
	}

	@JsonProperty
	public MyCharboxLocation setTimeZone(String timeZone) {
		this.timeZone = timeZone;
		return this;
	}
}
