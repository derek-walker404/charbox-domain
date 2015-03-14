package com.pofof.conmon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Heartbeat implements PersistentModel<Heartbeat> {

	private String _id;
	private int deviceId;
	private long time;
	
	@JsonProperty
	public String get_id() {
		return _id;
	}

	@JsonProperty
	public Heartbeat set_id(String id) {
		this._id = id;
		return this;
	}

	@JsonProperty
	public int getDeviceId() {
		return deviceId;
	}

	@JsonProperty
	public Heartbeat setDeviceId(int deviceId) {
		this.deviceId = deviceId;
		return this;
	}

	@JsonProperty
	public long getTime() {
		return time;
	}

	@JsonProperty
	public Heartbeat setTime(long time) {
		this.time = time;
		return this;
	}
}
