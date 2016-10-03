package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import model.Usuario;
import model.repository.UsuarioRepository;

@Repository
@Primary
public class JPAUsuarioRepository implements UsuarioRepository {
	@PersistenceContext(name = "twitterPU")
	private EntityManager em;

	@Override
	public boolean inserir(Usuario usuario) {

		try {
			// TODO verificar se o nome de usuario/email já existe antes de inserir no BD
			em.persist(usuario);
			return true;
		} catch (Exception erro) {
			System.err.println(">> JPA: Falha ao inserir!");
			return false;
		}
	}

	@Override
	public boolean alterar(Usuario usuario) {
		return false;
	}

	@Override
	public boolean excluir(Usuario usuario) {
		return false;
	}

	@Override
	public Usuario obter(Usuario usuario) {

		return null;
	}

	@Override
	public List<Usuario> obterTodos() {
		// Retorna o objeto do tipo Usuario
		TypedQuery<Usuario> consulta = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
		return consulta.getResultList();
	}
}
