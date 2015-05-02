package co.charbox.domain.model;

import lombok.Builder;
import lombok.Data;

import com.tpofof.core.data.IPersistentModel;

@Data
@Builder
public class Device implements IPersistentModel<Device, String> {

	private String id = "";
	private String version;
	private int deviceId = -1;
	private String configId = "";
	private boolean registered = false;
}
