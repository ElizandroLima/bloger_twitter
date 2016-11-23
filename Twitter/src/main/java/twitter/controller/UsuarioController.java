package twitter.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import twitter.model.Usuario;
import twitter.model.repository.UsuarioRepository;
import twitter.modelview.UsuarioModelView;
import twitter.modelview.UsuarioModelViewValidator;

@Controller
public class UsuarioController {
	// Injeção do objeto UsuarioRepository dentro desse atributo, dispensando o new (instanciação)
	@Autowired
	private UsuarioRepository repositorio;

	// Inicia a validação do usuário
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioModelViewValidator());
	}

	// --------------------------------
	// CRIAÇÃO DE CONTA
	//---------------------------------
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
			System.err.println(">> VALIDAÇÃO: Os campos contêm dados inválidos!");
			return "criar-conta";
		}

		// Insere o usuário no BD através de JPA + Spring
		if (repositorio.inserir(usuario.getUsuario())) {
			System.out.println(">> VALIDAÇÃO: Usuário inserido com sucesso: " + usuario.getUsuario()
			                                                                           .getNomeUsuario());
			return "redirect:/";
		}
		resultado.rejectValue("nomeUsuario", ">> VALIDAÇÃO: Este usuário já existe no sistema!");
		return "criar-conta";
	}

	// --------------------------------
	// ALTERAÇÃO DE CONTA
	//---------------------------------
	@RequestMapping(value = "/alterar-conta", method = RequestMethod.GET)
	public String alterarContaForm(Model modelo) {
		UsuarioModelView usuariomv = new UsuarioModelView();

		try {
			// TODO Recuperar da sessão o código do usuário correspondente /alterar-conta/{codigo} e @PathVariable
			Usuario usuario = repositorio.obter(2);
			usuariomv.setUsuario(usuario);

		} catch (NullPointerException erro) {
			System.err.println(">> USUÁRIO: Usuário não encontrado!");
		} catch (Exception erro) {
			System.err.println(">> USUÁRIO: Falha ao recuperar dados do usuário!");
		}

		modelo.addAttribute("alterarContaModelo", usuariomv);
		return "alterar-conta";
	}

	@Transactional
	@RequestMapping(value = "/alterar-conta", method = RequestMethod.POST)
	public String alterarContaValidar(@Valid @ModelAttribute("alterarContaModelo") UsuarioModelView usuario,
	                BindingResult resultado, @RequestParam("usuario.imagem") MultipartFile arquivo, ModelMap modelMap) {

		if (resultado.hasErrors()) {
			System.err.println(">> VALIDAÇÃO: Os campos contêm dados inválidos!");
			return "alterar-conta";
		}

		// Imagem 
		modelMap.addAttribute("alterarContaModelo", arquivo);

		// Insere o usuário no BD
		if (repositorio.alterar(usuario.getUsuario())) {
			System.out.println(">> VALIDAÇÃO: Usuário alterado com sucesso: " + usuario.getUsuario()
			                                                                           .getNomeUsuario());
			return "redirect:/meu-perfil";
		}
		return "alterar-conta";
	}
}
