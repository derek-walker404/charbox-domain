package co.charbox.domain.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Outage implements PersistentModel<Outage> {

	private String _id;
	private String deviceId;
	private DateTime outageTime;
	
	@JsonProperty
	public String get_id() {
		return this._id;
	}

	@JsonProperty
	public Outage set_id(String id) {
		this._id = id;
		return this;
	}

	@JsonProperty
	public String getDeviceId() {
		return deviceId;
	}

	@JsonProperty
	public Outage setDeviceId(String deviceId) {
		this.deviceId = deviceId;
		return this;
	}

	@JsonProperty
	public DateTime getOutageTime() {
		return outageTime;
	}

	@JsonProperty
	public Outage setOutageTime(DateTime outageTime) {
		this.outageTime = outageTime;
		return this;
	}
}
