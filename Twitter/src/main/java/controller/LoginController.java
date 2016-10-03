package controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Login;

@Controller
public class LoginController {
	//@Autowired // Injeção de dependência utilizando interface
	//private LoginRepository repositorio;

	// GET: pega o formulário de criação
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginForm(Model modelo) {

		Login login = new Login();
		modelo.addAttribute("loginModelo", login);

		return "login-inicio";
	}

	// POST: cria o objeto login
	@Transactional // Indica que este metodo sera usado pelo BD
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String loginAutenticar(@Valid Login login, Model modelo, BindingResult resultado) {

		if (resultado.hasErrors()) {
			return "login-inicio";
		}
		// TODO Efetuar login repositorio
		return "redirect:inicio";
	}
}
