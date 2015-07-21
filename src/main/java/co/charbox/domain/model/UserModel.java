package co.charbox.domain.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.apache.commons.lang.NotImplementedException;

import co.charbox.domain.model.auth.CharbotAuthModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Sets;
import com.tpofof.core.data.IPersistentModel;
import com.tpofof.core.security.IAuthModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel implements IPersistentModel<UserModel, Integer>, CharbotAuthModel {

	private Integer id;
	private String email;
	private String passwordHash;
	private String name;
	@JsonIgnore private Set<RoleModel> roles;
	
	@JsonIgnore
	public boolean isAdmin() {
		return getRoles().contains(RoleModel.getAdminRole());
	}
	
	public boolean isAnon() {
		return getRoles().isEmpty();
	}

	@Override
	public boolean isActivated() {
		return !isAnon();
	}

	@Override
	public <AuthModelT extends IAuthModel<RoleModel>> AuthModelT to(Class<AuthModelT> clazz) {
		throw new NotImplementedException();
	}

	@Override
	public <AuthModelT extends IAuthModel<RoleModel>> boolean is(Class<AuthModelT> clazz) {
		throw new NotImplementedException();
	}
	
	public static UserModel getAdmin() {
		return UserModel.builder()
				.email("admin@charbot.co")
				.name("Admin")
				.id(0)
				.roles(Sets.newHashSet(RoleModel.getAdminRole(), RoleModel.getUserRole()))
				.build();
	}
}
