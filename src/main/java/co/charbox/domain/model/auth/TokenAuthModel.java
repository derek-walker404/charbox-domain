package co.charbox.domain.model.auth;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Sets;
import com.tpofof.core.data.IPersistentModel;
import com.tpofof.core.security.IAuthModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenAuthModel implements IPersistentModel<TokenAuthModel, String>, IAuthModel {
	
	private String id;
	private DateTime expiration;
	@NonNull private String token;
	@NonNull private String authAssetId;
	@NonNull private String serviceId;

	public boolean isValid(String authAssetId, String serviceId) {
		return new DateTime().compareTo(getExpiration()) < 0 && 
				getAuthAssetId().equals(authAssetId) &&
				getServiceId().equals(serviceId);
	}

	@JsonIgnore
	public boolean isAdmin() {
		return false;
	}
	
	public Set<String> getRoles() {
		return Sets.newHashSet("TOKEN", getAuthAssetId().toUpperCase(), getServiceId().toUpperCase());
	}

	@JsonIgnore
	public boolean isActivated() {
		return new DateTime().compareTo(getExpiration()) < 0;
	}

	public <AuthModelT extends IAuthModel> AuthModelT to(Class<AuthModelT> clazz) {
		return is(clazz) ? clazz.cast(this) : null;
	}
	
	public <AuthModelT extends IAuthModel> boolean is(Class<AuthModelT> clazz) {
		return getClass().equals(clazz);
	}
}
