package co.charbox.domain.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tpofof.core.data.IPersistentModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceAuthModel implements IPersistentModel<DeviceAuthModel, String>, IAuthModel {

	private String id;
	private boolean activated;
	@NonNull private String deviceId;
	@NonNull private String apiKey;
	
	@JsonIgnore
	public boolean isAdmin() {
		return false;
	}

	public <AuthModelT extends IAuthModel> AuthModelT to(Class<AuthModelT> clazz) {
		return is(clazz) ? clazz.cast(this) : null;
	}
	
	public <AuthModelT extends IAuthModel> boolean is(Class<AuthModelT> clazz) {
		return getClass().equals(clazz);
	}
}
