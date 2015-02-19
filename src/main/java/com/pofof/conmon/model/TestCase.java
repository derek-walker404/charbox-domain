package com.pofof.conmon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tpofof.utils.JsonUtils;

public class TestCase implements PersistentModel {

	private String _id = null;
	private String name;
	private String uri;
	private boolean active = true;

	@JsonProperty
	public String get_id() {
		return _id;
	}

	@JsonProperty
	public void set_id(String _id) {
		this._id = _id;
	}

	@JsonProperty
	public String getName() {
		return name;
	}

	@JsonProperty
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty
	public String getUri() {
		return uri;
	}

	@JsonProperty
	public void setUri(String uri) {
		this.uri = uri;
	}

	@JsonProperty
	public boolean isActive() {
		return active;
	}

	@JsonProperty
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return JsonUtils.toJson(this);
	}
}
