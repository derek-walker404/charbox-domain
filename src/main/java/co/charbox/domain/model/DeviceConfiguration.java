package co.charbox.domain.model;

import co.charbox.core.data.PersistentModel;
import co.charbox.core.utils.JsonUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceConfiguration implements PersistentModel<DeviceConfiguration> {

	private String _id = "";
	private int trialsCount = 3;
	private int testInterval = 30; // minutes

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

	@Override
	public String toString() {
		return JsonUtils.toJson(this);
	}
}
