package twitter.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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
	public String criarContaValidar(@Valid @ModelAttribute("criarContaModelo") UsuarioModelView usuariomv,
	                BindingResult resultado) {

		if (resultado.hasErrors()) {
			System.err.println(">> VALIDAÇÃO: Os campos contêm dados inválidos!");
			return "criar-conta";
		}

		// Insere o usuário no BD através de JPA + Spring
		if (repositorio.inserir(usuariomv.getUsuario())) {
			System.out.println(">> VALIDAÇÃO: Usuário inserido com sucesso: " + usuariomv.getUsuario()
			                                                                             .getNomeUsuario());
			return "redirect:/";
		}

		resultado.rejectValue("usuario.nomeUsuario", "", "Este nome de usuário já existe no sistema!");
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
	public String alterarContaValidar(@Valid @ModelAttribute("alterarContaModelo") UsuarioModelView usuariomv,
	                BindingResult resultado, @RequestParam("imagem") MultipartFile arquivo) {

		String raiz, nomeArquivo;
		File diretorio, arquivoServidor;
		BufferedOutputStream stream;

		// Imagem 
		try {
			// Cria o caminho para salvar o arquivo (deve ter permissão de escrita)
			nomeArquivo = arquivo.getOriginalFilename();

			raiz = System.getProperty("catalina.base");
			diretorio = new File(raiz + File.separator + "uploads");

			// Cria o diretório caso não exista
			if (!diretorio.exists()) {
				diretorio.mkdirs();
			}

			// Salva o arquivo no servidor
			arquivoServidor = new File(diretorio.getAbsolutePath() + File.separator + nomeArquivo);
			stream = new BufferedOutputStream(new FileOutputStream(arquivoServidor));
			stream.write(arquivo.getBytes());
			stream.close();

			// Altera o campo no usuariomv
			usuariomv.getUsuario()
			         .setImagem(nomeArquivo);

		} catch (FileNotFoundException erro) {
			resultado.rejectValue("usuario.imagem", "", "Arquivo não encontrado!");

		} catch (Exception erro) {
			resultado.rejectValue("usuario.imagem", "", "Falha ao carregar imagem!");
		}

		// Efetua a validação do formulário
		if (resultado.hasErrors()) {
			resultado.rejectValue("usuario.imagem", "", "Os campos contêm dados inválidos!");

			return "alterar-conta";
		}

		// Insere o usuário no BD
		if (repositorio.alterar(usuariomv.getUsuario())) {
			System.out.println(">> VALIDAÇÃO: Usuário alterado com sucesso: " + usuariomv.getUsuario()
			                                                                             .getNomeUsuario());
			resultado.rejectValue("usuario.nomeUsuario", "", "Usuário alterado com sucesso!");
			return "redirect:/meu-perfil";
		}
		return "alterar-conta";
	}
}
