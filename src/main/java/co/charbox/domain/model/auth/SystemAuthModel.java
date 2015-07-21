package co.charbox.domain.model.auth;

import java.util.Set;

import org.elasticsearch.common.collect.Sets;

import co.charbox.domain.model.RoleModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tpofof.core.security.IAuthModel;

public class SystemAuthModel implements CharbotAuthModel {

	public boolean isAdmin() {
		return true;
	}

	public boolean isActivated() {
		return true;
	}

	@JsonIgnore
	public Set<RoleModel> getRoles() {
		return Sets.newHashSet(RoleModel.getSystemRole());
	}

	public <AuthModelT extends IAuthModel<RoleModel>> AuthModelT to(Class<AuthModelT> clazz) {
		return is(clazz) ? clazz.cast(this) : null;
	}
	
	public <AuthModelT extends IAuthModel<RoleModel>> boolean is(Class<AuthModelT> clazz) {
		return getClass().equals(clazz);
	}
}
