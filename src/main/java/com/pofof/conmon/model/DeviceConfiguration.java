package com.pofof.conmon.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceConfiguration {

	private String _id = "";
	private int trialsCount = 1;
	private int testInterval = 60; // minutes
	private List<TestCase> testCases;

	@JsonProperty
	public String get_id() {
		return _id;
	}

	@JsonProperty
	public void set_id(String _id) {
		this._id = _id;
	}

	@JsonProperty
	public int getTrialsCount() {
		return trialsCount;
	}

	@JsonProperty
	public void setTrialsCount(int trialsCount) {
		this.trialsCount = trialsCount;
	}

	@JsonProperty
	public int getTestInterval() {
		return testInterval;
	}

	@JsonProperty
	public void setTestInterval(int testInterval) {
		this.testInterval = testInterval;
	}

	@JsonProperty
	public List<TestCase> getTestCases() {
		return testCases;
	}

	@JsonProperty
	public void setTestCases(List<TestCase> testCases) {
		this.testCases = testCases;
	}
}
