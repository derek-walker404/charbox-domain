package co.charbox.domain.model.auth;

public interface IAuthModel {

	public boolean isAdmin();
	
	public boolean isActivated();
	
	public <AuthModelT extends IAuthModel> AuthModelT to(Class<AuthModelT> clazz);
	
	public <AuthModelT extends IAuthModel> boolean is(Class<AuthModelT> clazz);
}
