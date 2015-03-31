package com.pofof.conmon.model.mm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NamedLocation {

	private String name;
	private String isoCode;
	
	@JsonProperty
	public String getName() {
		return name;
	}

	@JsonProperty
	public NamedLocation setName(String name) {
		this.name = name;
		return this;
	}

	@JsonProperty
	public String getIsoCode() {
		return isoCode;
	}

	@JsonProperty
	public NamedLocation setIsoCode(String isoCode) {
		this.isoCode = isoCode;
		return this;
	}
}
