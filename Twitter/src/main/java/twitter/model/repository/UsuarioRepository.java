package twitter.model.repository;

import java.util.List;

import twitter.model.Usuario;

public interface UsuarioRepository {
	void inserir(Usuario usuario);

	boolean alterar(Usuario usuario);

	boolean excluir(int codigo);

	Usuario obter(int codigo);

	List<Usuario> obterTodos();

	Usuario buscarUsuarioPorUsername(String username);
}
