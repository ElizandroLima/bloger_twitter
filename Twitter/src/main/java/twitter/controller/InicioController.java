package twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	//--------------------------------
	// EXIBIR DADOS DOS USUÁRIOS
	//--------------------------------
	@RequestMapping(value = "/inicio")
	public String inicio(Model modelo) {
		// TODO Pegar o código da sessão adicionado ao efetuar login
		try {
			Usuario usuario = repositorio.obter(2);
			modelo.addAttribute("usuarioModelo", usuario);

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
		return "inicio";
	}

	//--------------------------------
	// EXIBIR MEUS DADOS
	//--------------------------------
	@RequestMapping(value = "/meu-perfil")
	public String meuPerfil(Model modelo) {

		// TODO Pegar o código da sessão adicionado ao efetuar login
		try {
			Usuario usuario = repositorio.obter(2);
			modelo.addAttribute("usuarioModelo", usuario);

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
		return "meu-perfil";
	}

	//--------------------------------
	// TWEETS
	//--------------------------------
	@RequestMapping(value = "/novo-tweet", method = RequestMethod.GET)
	public String novoTweetForm(Model modelo) {

		// TODO Modificar o UsuarioModelView para a classe Mensagem
		//UsuarioModelView usuario = new UsuarioModelView();
		//modelo.addAttribute("novoTweetModelo", usuario);

		return "novo-tweet";
	}

	@RequestMapping(value = "/novo-tweet", method = RequestMethod.POST)
	public String novoTweetValidar() {

		// TODO Modificar o UsuarioModelView para a classe Mensagem
		//UsuarioModelView usuario = new UsuarioModelView();
		//modelo.addAttribute("novoTweetModelo", usuario);

		return "novo-tweet";
	}
}
