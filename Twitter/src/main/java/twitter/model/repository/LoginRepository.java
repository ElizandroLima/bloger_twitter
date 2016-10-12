package twitter.model.repository;

import twitter.modelview.UsuarioModelView;

public interface LoginRepository {
	boolean autenticar(UsuarioModelView login);
}
