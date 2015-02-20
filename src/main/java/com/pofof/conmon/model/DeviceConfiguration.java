package com.pofof.conmon.model;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tpofof.utils.JsonUtils;

public class DeviceConfiguration implements PersistentModel<DeviceConfiguration> {

	private String _id = "";
	private int trialsCount = 3;
	private int testInterval = 30; // minutes
	private List<String> testCaseIds = Collections.emptyList();

	@JsonProperty
	public String get_id() {
		return _id;
	}

	@JsonProperty
	public DeviceConfiguration set_id(String _id) {
		this._id = _id;
		return this;
	}

	@JsonProperty
	public int getTrialsCount() {
		return trialsCount;
	}

	@JsonProperty
	public DeviceConfiguration setTrialsCount(int trialsCount) {
		this.trialsCount = trialsCount;
		return this;
	}

	@JsonProperty
	public int getTestInterval() {
		return testInterval;
	}

	@JsonProperty
	public DeviceConfiguration setTestInterval(int testInterval) {
		this.testInterval = testInterval;
		return this;
	}

	@JsonProperty
	public List<String> getTestCaseIds() {
		return testCaseIds;
	}

	@JsonProperty
	public DeviceConfiguration setTestCaseIds(List<String> testCasesIds) {
		this.testCaseIds = testCasesIds;
		return this;
	}

	@Override
	public String toString() {
		return JsonUtils.toJson(this);
	}
}
