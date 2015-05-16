package co.charbox.domain.model.auth;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Sets;
import com.tpofof.core.data.IPersistentModel;
import com.tpofof.core.security.IAuthModel;

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
	
	public Set<String> getRoles() {
		return Sets.newHashSet("DEVICE", getDeviceId().toUpperCase());
	}

	public <AuthModelT extends IAuthModel> AuthModelT to(Class<AuthModelT> clazz) {
		return is(clazz) ? clazz.cast(this) : null;
	}
	
	public <AuthModelT extends IAuthModel> boolean is(Class<AuthModelT> clazz) {
		return getClass().equals(clazz);
	}
}
