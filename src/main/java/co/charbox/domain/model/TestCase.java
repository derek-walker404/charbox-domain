package co.charbox.domain.model;

import co.charbox.core.data.PersistentModel;
import co.charbox.core.utils.JsonUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestCase implements PersistentModel<TestCase> {

	private String _id = null;
	private String name;
	private String uri;
	private boolean active = true;

	@JsonProperty
	public String get_id() {
		return _id;
	}

	@JsonProperty
	public TestCase set_id(String _id) {
		this._id = _id;
		return this;
	}

	@JsonProperty
	public String getName() {
		return name;
	}

	@JsonProperty
	public TestCase setName(String name) {
		this.name = name;
		return this;
	}

	@JsonProperty
	public String getUri() {
		return uri;
	}

	@JsonProperty
	public TestCase setUri(String uri) {
		this.uri = uri;
		return this;
	}

	@JsonProperty
	public boolean isActive() {
		return active;
	}

	@JsonProperty
	public TestCase setActive(boolean active) {
		this.active = active;
		return this;
	}
	
	@Override
	public String toString() {
		return JsonUtils.toJson(this);
	}
}
