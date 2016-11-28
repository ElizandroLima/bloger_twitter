package twitter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	// --------------------------------
	// LOGIN
	// ---------------------------------
	// GET: pega o formulário de criação
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, Authentication auth) {
		System.out.println("Não Logou!");
		//System.out.println(auth.isAuthenticated());
		//System.out.println(auth.getName());
		
		if (auth != null) {
			System.out.println("Logou!");
			return "redirect:/meu-perfil";
			//return "redirect:/time-line";
		}
		return "/login";
	}

	// --------------------------------
	// LOGOUT
	// ---------------------------------

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, Authentication auth) {

		if (auth != null)
			new SecurityContextLogoutHandler().logout(request, response, auth);
		return "redirect:/";
	}

}