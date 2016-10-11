package twitter.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import twitter.model.Usuario;
import twitter.model.repository.UsuarioRepository;

@Controller
public class CriarContaController {
	// Injeção de objeto UsuarioRepository dentro desse atributo, dispensando o new (instanciação)
	@Autowired
	private UsuarioRepository repositorio;

	@RequestMapping(value = "/criar-conta", method = RequestMethod.GET)
	public String criarContaForm(Model modelo) {

		Usuario usuario = new Usuario();
		modelo.addAttribute("criarContaModelo", usuario);

		return "criar-conta";
	}

	@Transactional // Indica que este método sera usado pelo BD
	@RequestMapping(value = "/criar-conta", method = RequestMethod.POST)
	public String criarContaValidar(@Valid Usuario usuario, Model modelo, BindingResult resultado) {

		if (resultado.hasErrors()) {
			return "criar-conta";
		}
		// Persiste o objeto no BD
		repositorio.inserir(usuario);
		return "inicio";
	}
}
