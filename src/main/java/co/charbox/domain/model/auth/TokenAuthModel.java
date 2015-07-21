package co.charbox.domain.model.auth;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import org.joda.time.DateTime;

import co.charbox.domain.model.RoleModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Sets;
import com.tpofof.core.data.IPersistentModel;
import com.tpofof.core.security.IAuthModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenAuthModel implements IPersistentModel<TokenAuthModel, Integer>, CharbotAuthModel {
	
	private Integer id;
	private DateTime expiration;
	@NonNull private String token;
	@NonNull private Integer authAssetId;
	@NonNull private String serviceName;

	public boolean isValid(Integer expectedAuthAssetId, String expectedServiceName) {
		return new DateTime().compareTo(getExpiration()) < 0 && 
				getAuthAssetId().equals(expectedAuthAssetId) &&
				getServiceName().equals(expectedServiceName);
	}

	@JsonIgnore
	public boolean isAdmin() {
		return false;
	}
	
	@JsonIgnore
	public Set<RoleModel> getRoles() {
		return Sets.newHashSet(RoleModel.getTokenRole(), 
				RoleModel.getTokenRole("DEVICE", getAuthAssetId()), // TODO: move to field/db 
				RoleModel.getServiceRole(getServiceName()));
	}

	@JsonIgnore
	public boolean isActivated() {
		return new DateTime().compareTo(getExpiration()) < 0;
	}

	public <AuthModelT extends IAuthModel<RoleModel>> AuthModelT to(Class<AuthModelT> clazz) {
		return is(clazz) ? clazz.cast(this) : null;
	}
	
	public <AuthModelT extends IAuthModel<RoleModel>> boolean is(Class<AuthModelT> clazz) {
		return getClass().equals(clazz);
	}
}
