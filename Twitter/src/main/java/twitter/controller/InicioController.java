package twitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InicioController {

	// GET: pega o formulário de criação
	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String inicio() {
		return "inicio";
	}
}
