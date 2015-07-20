package co.charbox.domain.model.auth;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import co.charbox.domain.model.RoleModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Sets;
import com.tpofof.core.data.IPersistentModel;
import com.tpofof.core.security.IAuthModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceAuthModel implements IPersistentModel<DeviceAuthModel, Integer>, CharbotAuthModel {

	private Integer id;
	private boolean activated;
	@NonNull private Integer deviceId;
	@NonNull private String key;
	
	@JsonIgnore
	public boolean isAdmin() {
		return false;
	}
	
	@JsonIgnore
	public Set<RoleModel> getRoles() {
		return Sets.newHashSet(RoleModel.getDeviceRole(), RoleModel.getDeviceRole(getDeviceId()));
	}

	public <AuthModelT extends IAuthModel<RoleModel>> AuthModelT to(Class<AuthModelT> clazz) {
		return is(clazz) ? clazz.cast(this) : null;
	}
	
	public <AuthModelT extends IAuthModel<RoleModel>> boolean is(Class<AuthModelT> clazz) {
		return getClass().equals(clazz);
	}
}
