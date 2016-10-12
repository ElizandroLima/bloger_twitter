package twitter.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import twitter.model.repository.UsuarioRepository;
import twitter.modelview.UsuarioModelView;
import twitter.modelview.UsuarioModelViewValidator;

@Controller
public class UsuarioController {
	@Autowired // Injeção do objeto UsuarioRepository dentro desse atributo, dispensando o new (instanciação)
	private UsuarioRepository repositorio;

	// Inicia a validação do usuário
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioModelViewValidator());
	}

	@RequestMapping(value = "/criar-conta", method = RequestMethod.GET)
	public String criarContaForm(Model modelo) {

		UsuarioModelView usuario = new UsuarioModelView();
		modelo.addAttribute("criarContaModelo", usuario);

		return "criar-conta";
	}

	@Transactional // Indica que este método sera usado pelo BD
	@RequestMapping(value = "/criar-conta", method = RequestMethod.POST)
	public String criarContaValidar(@Valid @ModelAttribute("criarContaModelo") UsuarioModelView usuario,
	                BindingResult resultado) {

		if (resultado.hasErrors()) {
			System.err.println(">> VALIDAÇÃO: Os campos contém dados inválidos!");
			return "criar-conta";
		}

		// Insere o usuário no BD através de JPA + Spring
		if (repositorio.inserir(usuario.getUsuario())) {
			System.out.println(">> VALIDAÇÃO: Usuário inserido com sucesso: " + usuario.getUsuario()
			                                                                           .getNomeUsuario());

			return "redirect:/inicio";
		}
		return "criar-conta";
	}
}
