package com.pofof.conmon.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestCase {

	private long _id;
	private String name;
	private String uri;

	@JsonProperty
	public long get_id() {
		return _id;
	}

	@JsonProperty
	public void set_id(long _id) {
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
}
