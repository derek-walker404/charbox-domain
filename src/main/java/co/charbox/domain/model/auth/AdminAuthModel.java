package co.charbox.domain.model.auth;

import java.util.Set;

import org.elasticsearch.common.collect.Sets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tpofof.core.security.IAuthModel;

public class AdminAuthModel implements IAuthModel {

	public boolean isAdmin() {
		return true;
	}

	public boolean isActivated() {
		return true;
	}

	@JsonIgnore
	public Set<String> getRoles() {
		return Sets.newHashSet("ADMIN");
	}

	public <AuthModelT extends IAuthModel> AuthModelT to(Class<AuthModelT> clazz) {
		return is(clazz) ? clazz.cast(this) : null;
	}
	
	public <AuthModelT extends IAuthModel> boolean is(Class<AuthModelT> clazz) {
		return getClass().equals(clazz);
	}
}
