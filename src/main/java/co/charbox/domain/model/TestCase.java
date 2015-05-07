package co.charbox.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.tpofof.core.data.IPersistentModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestCase implements IPersistentModel<TestCase, String> {

	private String id;
	private String name;
	private String uri;
	private boolean active = true;
}
