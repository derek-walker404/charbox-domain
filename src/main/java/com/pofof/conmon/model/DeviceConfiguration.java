package com.pofof.conmon.model;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceConfiguration {

	private String _id = "";
	private int trialsCount = 3;
	private int testInterval = 30; // minutes
	private List<String> testCaseIds = Collections.emptyList();

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
	public List<String> getTestCaseIds() {
		return testCaseIds;
	}

	@JsonProperty
	public void setTestCaseIds(List<String> testCasesIds) {
		this.testCaseIds = testCasesIds;
	}
}
