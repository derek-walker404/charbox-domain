package com.pofof.conmon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tpofof.utils.JsonUtils;

public class TimerResult implements PersistentModel {

	private String _id = "";
	private long startTime;
	private long duration;
	private long pingDuration;
	private String testCaseId;
	private boolean outage = false;
	private String serverIp = "";
	private long size;
	private int speed;
	private int deviceId;

	@JsonProperty
	public String get_id() {
		return _id;
	}

	@JsonProperty
	public TimerResult set_id(String _id) {
		this._id = _id;
		return this;
	}

	@JsonProperty
	public long getStartTime() {
		return startTime;
	}

	@JsonProperty
	public TimerResult setStartTime(long startTime) {
		this.startTime = startTime;
		return this;
	}

	@JsonProperty
	public long getDuration() {
		return duration;
	}

	@JsonProperty
	public TimerResult setDuration(long duration) {
		this.duration = duration;
		return this;
	}

	@JsonProperty
	public long getPingDuration() {
		return pingDuration;
	}

	@JsonProperty
	public TimerResult setPingDuration(long pingDuration) {
		this.pingDuration = pingDuration;
		return this;
	}

	@JsonProperty
	public String getTestCaseId() {
		return testCaseId;
	}

	@JsonProperty
	public TimerResult setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
		return this;
	}

	@JsonProperty
	public boolean isOutage() {
		return outage;
	}

	@JsonProperty
	public TimerResult setOutage(boolean outage) {
		this.outage = outage;
		return this;
	}
	
	@JsonProperty
	public String getServerIp() {
		return serverIp;
	}

	@JsonProperty
	public TimerResult setServerIp(String serverIp) {
		this.serverIp = serverIp;
		return this;
	}

	@JsonProperty
	public long getSize() {
		return size;
	}

	@JsonProperty
	public TimerResult setSize(long size) {
		this.size = size;
		return this;
	}

	@JsonProperty
	public int getSpeed() {
		return speed;
	}

	@JsonProperty
	public TimerResult setSpeed(int speed) {
		this.speed = speed;
		return this;
	}

	@JsonProperty
	public int getDeviceId() {
		return deviceId;
	}

	@JsonProperty
	public TimerResult setDeviceId(int deviceId) {
		this.deviceId = deviceId;
		return this;
	}

	@Override
	public String toString() {
		return JsonUtils.toJson(this);
	}
}
