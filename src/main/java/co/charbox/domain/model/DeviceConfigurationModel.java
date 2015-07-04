package co.charbox.domain.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.tpofof.core.data.IPersistentModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceConfigurationModel implements IPersistentModel<DeviceConfigurationModel, Integer> {

	private Integer id;
	private DeviceModel device;
	private Integer version;
	private boolean registered;
	private Map<String, String> schedules;
}
