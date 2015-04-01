package co.charbox.domain.model;

import co.charbox.core.data.PersistentModel;
import co.charbox.core.utils.JsonUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Device implements PersistentModel<Device> {

	private String _id = "";
	private int deviceId = -1;
	private String configId = "";
	private boolean registered = false;

	@JsonProperty
	public String get_id() {
		return _id;
	}

	@JsonProperty
	public Device set_id(String _id) {
		this._id = _id;
		return this;
	}

	@JsonProperty
	public int getDeviceId() {
		return deviceId;
	}

	@JsonProperty
	public Device setDeviceId(int deviceId) {
		this.deviceId = deviceId;
		return this;
	}

	@JsonProperty
	public String getConfigId() {
		return configId;
	}

	@JsonProperty
	public Device setConfigId(String configId) {
		this.configId = configId;
		return this;
	}

	@JsonProperty
	public boolean isRegistered() {
		return registered;
	}

	@JsonProperty
	public Device setRegistered(boolean registered) {
		this.registered = registered;
		return this;
	}

	@Override
	public String toString() {
		return JsonUtils.toJson(this);
	}
}
