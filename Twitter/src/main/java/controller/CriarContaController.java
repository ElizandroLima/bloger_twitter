package controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Usuario;

@Controller
public class CriarContaController {

	@RequestMapping(value = "/criar-conta", method = RequestMethod.GET)
	public String criarContaForm(Model modelo) {

		Usuario usuario = new Usuario();
		modelo.addAttribute("criarContaModelo", usuario);

		return "criar-conta";
	}

	@Transactional // Indica que este metodo sera usado pelo BD
	@RequestMapping(value = "/criar-conta", method = RequestMethod.POST)
	public String criarContaValidar(@Valid Usuario usuario, Model modelo, BindingResult resultado) {

		if (resultado.hasErrors()) {
			return "criar-conta";
		}
		// TODO Efetuar login repositorio
		return "redirect:login-inicio";
	}
}
