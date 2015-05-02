package co.charbox.domain.model;

import lombok.Builder;
import lombok.Data;

import com.tpofof.core.data.IPersistentModel;

@Data
@Builder
public class TestCase implements IPersistentModel<TestCase, String> {

	private String id;
	private String name;
	private String uri;
	private boolean active = true;
}
