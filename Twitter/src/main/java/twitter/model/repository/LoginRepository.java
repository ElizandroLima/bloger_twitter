package twitter.model.repository;

import twitter.model.Login;

public interface LoginRepository {
	boolean autenticar(Login login);
}
