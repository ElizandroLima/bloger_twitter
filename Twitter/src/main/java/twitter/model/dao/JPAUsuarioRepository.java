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
		// Consulta tipada para indicar que será retornado um objeto Usuário da consulta
		TypedQuery<Usuario> consulta;

		try {
			// Verifica se o nome de usuário já existe antes de inserir no BD
			consulta = em.createQuery("SELECT u FROM Usuario u WHERE u.nomeUsuario = :nomeUsuario", Usuario.class);
			consulta.setParameter("nomeUsuario", usuario.getNomeUsuario());

			// Se a consulta não retornar resultados, então insere o usuário no BD
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
		Usuario usuarioBD;

		try {
			// Obtém os dados do usuário pelo código para atualizar
			usuarioBD = this.obter(usuario.getCodigo());

			usuarioBD.setNome(usuario.getNome());
			usuarioBD.setEmail(usuario.getEmail());
			usuarioBD.setSenha(usuario.getSenha());

			// Verifica se a imagem foi alterada pelo usuário antes de salvar no BD
			if (usuario.getImagem() != null) {
				usuarioBD.setImagem(usuario.getImagem());
			}

			em.merge(usuarioBD);
			return true;

		} catch (IllegalArgumentException erro) {
			System.err.println(">> JPA: O objeto não é uma tabela do BD!\n" + erro);
		} catch (Exception erro) {
			System.err.println(">> JPA: Falha ao alterar!\n" + erro);
		} finally {
			em.close();
		}
		return false;
	}

	@Override
	public boolean excluir(int codigo) {
		Usuario usuarioBD;

		try {
			usuarioBD = this.obter(codigo);
			em.remove(usuarioBD);

			return true;

		} catch (IllegalArgumentException erro) {
			System.err.println(">> JPA: O objeto não é uma entidade!\n" + erro);
		} catch (Exception erro) {
			System.err.println(">> JPA: Falha ao alterar!\n" + erro);
		} finally {
			em.close();
		}
		return false;
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
