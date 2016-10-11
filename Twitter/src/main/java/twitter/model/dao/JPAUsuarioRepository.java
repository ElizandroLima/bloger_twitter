package twitter.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import twitter.model.Usuario;
import twitter.model.repository.UsuarioRepository;

@Primary
@Repository
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
		TypedQuery<Usuario> consulta = em.createQuery("SELECT u FROM Usuario u WHERE u.codigo = :codigo",
		                Usuario.class);

		// Parametros do WHERE
		consulta.setParameter("codigo", usuario.getCodigo());
		return consulta.getSingleResult();
	}

	@Override
	public List<Usuario> obterTodos() {
		// Retorna o objeto do tipo Usuario
		TypedQuery<Usuario> consulta = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
		return consulta.getResultList();
	}
}
