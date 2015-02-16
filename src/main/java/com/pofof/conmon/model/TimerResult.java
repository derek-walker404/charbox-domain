package com.pofof.conmon.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimerResult {

	private long deviceId;
	private long startTime;
	private long duration;
	private long testCaseId;

	@JsonProperty
	public long getDeviceId() {
		return deviceId;
	}

	@JsonProperty
	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	@JsonProperty
	public long getStartTime() {
		return startTime;
	}

	@JsonProperty
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	@JsonProperty
	public long getDuration() {
		return duration;
	}

	@JsonProperty
	public void setDuration(long duration) {
		this.duration = duration;
	}

	@JsonProperty
	public long getTestCaseId() {
		return testCaseId;
	}

	@JsonProperty
	public void setTestCaseId(long testCaseId) {
		this.testCaseId = testCaseId;
	}

}
