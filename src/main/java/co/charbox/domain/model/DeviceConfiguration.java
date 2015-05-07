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
public class DeviceConfiguration implements IPersistentModel<DeviceConfiguration, String> {

	private String id = "";
	private int trialsCount = 3;
	private int testInterval = 30; // minutes
}
