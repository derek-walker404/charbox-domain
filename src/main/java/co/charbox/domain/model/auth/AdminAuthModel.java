package co.charbox.domain.model.auth;

public class AdminAuthModel implements IAuthModel {

	public boolean isAdmin() {
		return true;
	}

	public boolean isActivated() {
		return true;
	}

	public <AuthModelT extends IAuthModel> AuthModelT to(Class<AuthModelT> clazz) {
		return is(clazz) ? clazz.cast(this) : null;
	}
	
	public <AuthModelT extends IAuthModel> boolean is(Class<AuthModelT> clazz) {
		return getClass().equals(clazz);
	}
}
