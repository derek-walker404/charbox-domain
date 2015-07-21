package co.charbox.domain.model.auth;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import org.elasticsearch.common.collect.Sets;

import co.charbox.domain.model.RoleModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tpofof.core.data.IPersistentModel;
import com.tpofof.core.security.IAuthModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerAuthModel implements IPersistentModel<ServerAuthModel, Integer>, CharbotAuthModel {

	private Integer id;
	private boolean activated;
	@NonNull private String serverId;
	@NonNull private String serviceName;
	@NonNull private String key;
	
	@JsonIgnore
	public boolean isAdmin() {
		return false;
	}
	
	@JsonIgnore
	public Set<RoleModel> getRoles() {
		RoleModel serviceRole = RoleModel.getServiceRole();
		RoleModel serviceNameRole = RoleModel.getServiceRole(getServiceName());
		RoleModel serverIdRole = RoleModel.getServiceRole(getServiceName(), getServerId());
		return Sets.newHashSet(serviceRole, serviceNameRole, serverIdRole);
	}

	public <AuthModelT extends IAuthModel<RoleModel>> AuthModelT to(Class<AuthModelT> clazz) {
		return is(clazz) ? clazz.cast(this) : null;
	}
	
	public <AuthModelT extends IAuthModel<RoleModel>> boolean is(Class<AuthModelT> clazz) {
		return getClass().equals(clazz);
	}
}
