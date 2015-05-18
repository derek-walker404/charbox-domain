package co.charbox.domain.model.auth;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import org.elasticsearch.common.collect.Sets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tpofof.core.data.IPersistentModel;
import com.tpofof.core.security.IAuthModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerAuthModel implements IPersistentModel<ServerAuthModel, String>, IAuthModel {

	private String id;
	private boolean activated;
	@NonNull private String serverId;
	@NonNull private String serverKey;
	@NonNull private String service;
	
	@JsonIgnore
	public boolean isAdmin() {
		return false;
	}
	
	@JsonIgnore
	public Set<String> getRoles() {
		return Sets.newHashSet("SERVER", getServerId().toUpperCase(), getService().toUpperCase());
	}

	public <AuthModelT extends IAuthModel> AuthModelT to(Class<AuthModelT> clazz) {
		return is(clazz) ? clazz.cast(this) : null;
	}
	
	public <AuthModelT extends IAuthModel> boolean is(Class<AuthModelT> clazz) {
		return getClass().equals(clazz);
	}
}
