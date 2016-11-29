package twitter.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import twitter.model.Usuario;
import twitter.model.repository.UsuarioRepository;

@Controller
public class BuscaController {
	@Autowired
	private UsuarioRepository repositorio;

	// GET: pega o formulário de criação
	@Transactional
	@RequestMapping("busca")
	public String busca(Model model, String campoBusca) {

		campoBusca = "'%" + campoBusca + "%'";
		List<Usuario> retornoPesquisa = repositorio.pesquisarUsuario(campoBusca);

		for (int cont = 0; cont < retornoPesquisa.size(); cont++) {

			System.out.println(retornoPesquisa.get(cont)
			                                  .getNome());

		}
		model.addAttribute("retornoPesquisa", repositorio.pesquisarUsuario(campoBusca));

		return "buscar-usuario";
	}

	@Transactional
	@RequestMapping("perfil-usuario")
	public String acessarUsuario(Model modelo, int codigoUsuario) {
		// TODO Pegar o código da sessão adicionado ao efetuar login
		try {
			modelo.addAttribute("usuarioModelo", repositorio.obter(codigoUsuario));

			/*
			 * Mensagem mensagem = repositorio.obter(codigoSessao);
			 * modelo.addAttribute("mensagemModelo", mensagem);
			 */
			/*
			 * Seguidor seguidor = repositorio.obter(codigoSessao);
			 * modelo.addAttribute("seguidorModelo", seguidor);
			 */

		} catch (NullPointerException erro) {
			System.err.println(">> USUÁRIO: Usuário não encontrado!");
		} catch (Exception erro) {
			System.err.println(">> USUÁRIO: Falha ao recuperar dados do usuário!");
		}

		return "perfil-usuario";
	}
}
