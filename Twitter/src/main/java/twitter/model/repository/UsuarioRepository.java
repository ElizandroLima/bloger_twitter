package twitter.model.repository;

import java.util.List;

import twitter.model.Usuario;

public interface UsuarioRepository {
	boolean inserir(Usuario usuario);

	boolean alterar(Usuario usuario);

	boolean excluir(Usuario usuario);

	Usuario obter(Usuario usuario);

	List<Usuario> obterTodos();
}
