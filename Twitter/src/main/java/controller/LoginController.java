package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/bem-vindo")
	public String loginInicio() {
		return "login-inicio";
	}
}
