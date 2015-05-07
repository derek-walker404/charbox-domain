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
public class Device implements IPersistentModel<Device, String> {

	private String id = "";
	private String version;
	private String deviceId = "";
	private String configId = "";
	private boolean registered = false;
}
