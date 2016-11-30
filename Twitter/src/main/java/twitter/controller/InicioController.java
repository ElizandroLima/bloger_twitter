package twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import twitter.model.Usuario;
import twitter.model.repository.UsuarioRepository;

@Controller
public class InicioController {
	@Autowired
	private UsuarioRepository repositorio;

	// --------------------------------
	// EXIBIR DADOS DOS USUÁRIOS
	// --------------------------------
	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String inicio(Model modelo, Authentication auth) {
		try {
			Usuario usuario = (Usuario) auth.getPrincipal();
			modelo.addAttribute("usuarioModelo", repositorio.obter(usuario.getCodigo()));

		} catch (NullPointerException erro) {
			System.err.println(">> USUÁRIO: Usuário não encontrado!");
		} catch (Exception erro) {
			System.err.println(">> USUÁRIO: Falha ao recuperar dados do usuário!");
		}
		return "inicio";
	}

	// --------------------------------
	// EXIBIR MEUS DADOS
	// --------------------------------
	@RequestMapping(value = "/meu-perfil", method = RequestMethod.GET)
	public String meuPerfil(Model modelo, Authentication auth) {
		try {
			Usuario usuario = (Usuario) auth.getPrincipal();
			modelo.addAttribute("usuarioModelo", repositorio.obter(usuario.getCodigo()));

		} catch (NullPointerException erro) {
			System.err.println(">> USUÁRIO: Usuário não encontrado!");
		} catch (Exception erro) {
			System.err.println(">> USUÁRIO: Falha ao recuperar dados do usuário!");
		}
		return "meu-perfil";
	}

	// --------------------------------
	// TWEETS
	// --------------------------------
	@RequestMapping(value = "/novo-tweet", method = RequestMethod.GET)
	public String novoTweetForm(Model modelo) {
		return "novo-tweet";
	}

	@RequestMapping(value = "/novo-tweet", method = RequestMethod.POST)
	public String novoTweetValidar() {
		return "novo-tweet";
	}
}
