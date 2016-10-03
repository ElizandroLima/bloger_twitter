package model.repository;

import model.Login;

public interface LoginRepository {
	boolean autenticar(Login login);
}
