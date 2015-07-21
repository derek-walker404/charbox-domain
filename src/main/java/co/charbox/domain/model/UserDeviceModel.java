package co.charbox.domain.model;

import com.tpofof.core.data.IPersistentModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDeviceModel implements IPersistentModel<UserDeviceModel, Integer> {

	private Integer id;
	private Integer userId;
	private Integer deviceId;
}
