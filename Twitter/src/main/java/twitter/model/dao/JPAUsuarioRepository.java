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
		TypedQuery<Usuario> consulta;

		try {
			// Verifica se o nome de usuário já existe antes de inserir no BD
			consulta = em.createQuery("SELECT u FROM Usuario u WHERE u.nomeUsuario = :nomeUsuario", Usuario.class);
			consulta.setParameter("nomeUsuario", usuario.getNomeUsuario());

			if (consulta.getResultList()
			            .isEmpty()) {
				em.persist(usuario);
				return true;
			}
			System.err.println(">> JPA: Este usuário já existe no sistema!");
		} catch (IllegalArgumentException erro) {
			System.err.println(">> JPA: Argumento de pesquisa inválido!\n" + erro);
		} catch (Exception erro) {
			System.err.println(">> JPA: Falha ao inserir!\n" + erro);
		} finally {
			em.close();
		}
		return false;
	}

	@Override
	public boolean alterar(Usuario usuario) {
		em.merge(usuario);
		return true;
	}

	@Override
	public boolean excluir(Usuario usuario) {
		// TODO Verificar se o usuário existe na lista para removê-lo
		em.remove(usuario);
		return true;
	}

	@Override
	public Usuario obter(int codigo) {
		Usuario usuario;

		try {
			// Consulta um usuário pelo seu código
			usuario = em.find(Usuario.class, codigo);
			return usuario;

		} catch (IllegalArgumentException erro) {
			System.err.println(">> JPA: Argumento de pesquisa inválido!\n" + erro);
		} catch (Exception erro) {
			System.err.println(">> JPA: Falha ao buscar!\n" + erro);
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public List<Usuario> obterTodos() {
		// Retorna o objeto do tipo Usuario
		TypedQuery<Usuario> consulta = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
		return consulta.getResultList();
	}
}
