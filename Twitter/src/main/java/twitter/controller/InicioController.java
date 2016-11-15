package twitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InicioController {

	// GET: pega o formulário de criação
	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String inicio() {
		return "inicio";
	}

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
