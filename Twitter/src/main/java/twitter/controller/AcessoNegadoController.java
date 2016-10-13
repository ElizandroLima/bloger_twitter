package twitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AcessoNegadoController {

	@RequestMapping("/acesso-negado")
	public String acessoNegado() {
		return "acesso-negado";
	}
}
