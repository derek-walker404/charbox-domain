package co.charbox.domain.model;

import com.tpofof.core.security.IRoleModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleModel implements IRoleModel {

	private String name;
	
	public static RoleModel getDeviceRole() {
		return getRole("DEVICE");
	}
	
	public static RoleModel getDeviceRole(Integer deviceId) {
		return getRole("DEVICE-" + deviceId);
	}
	
	public static RoleModel getUserRole() {
		return getRole("USER");
	}
	
	public static RoleModel getUserRole(Integer userId) {
		return getRole("USER-" + userId);
	}
	
	public static RoleModel getServiceRole() {
		return getRole("SERVICE");
	}
	
	public static RoleModel getServiceRole(String serviceName) {
		return getRole(serviceName.toUpperCase());
	}
	
	public static RoleModel getServiceRole(String serviceName, String serviceId) {
		return getRole(serviceName.toUpperCase() + "-" + serviceId);
	}
	
	public static RoleModel getTokenRole() {
		return getRole("TOKEN");
	}
	
	public static RoleModel getTokenRole(String assetType, Integer authAssetId) {
		return getRole(assetType + "-" + authAssetId);
	}
	
	public static RoleModel getAdminRole() {
		return getRole("ADMIN");
	}
	
	private static RoleModel getRole(String name) {
		return RoleModel.builder()
				.name(name.toUpperCase())
				.build();
	}
}
