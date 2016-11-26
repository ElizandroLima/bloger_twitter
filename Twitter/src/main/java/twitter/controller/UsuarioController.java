package twitter.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
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
	@Autowired
	private ServletContext contexto;

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

		// Efetua a validação do formulário
		if (resultado.hasErrors()) {
			resultado.rejectValue("usuario.imagem", "", "Os campos contêm dados inválidos!");

			return "alterar-conta";
		}

		// Imagem 
		if (!arquivo.isEmpty()) {
			String imagem = salvarImagem(arquivo, resultado);

			// Altera o campo no usuariomv
			usuariomv.getUsuario()
			         .setImagem(imagem);
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

	public String salvarImagem(MultipartFile arquivo, BindingResult resultado) {
		String nomeArquivo, nomeArquivoCompleto, diretorio;
		File caminho;
		BufferedOutputStream stream;

		try {
			// Cria o caminho para salvar o arquivo (deve ter permissão de escrita)
			nomeArquivoCompleto = arquivo.getOriginalFilename();

			// Recupera somente o nome do arquivo, descartando o caminho completo
			nomeArquivo = nomeArquivoCompleto.substring(nomeArquivoCompleto.lastIndexOf("\\") + 1,
			                nomeArquivoCompleto.length());

			diretorio = contexto.getRealPath("resources/uploads");

			// Salva o arquivo no servidor
			caminho = new File(diretorio + File.separator + nomeArquivo);
			stream = new BufferedOutputStream(new FileOutputStream(caminho));
			stream.write(arquivo.getBytes());
			stream.close();

			return nomeArquivo;

		} catch (FileNotFoundException erro) {
			resultado.rejectValue("usuario.imagem", "", "Arquivo não encontrado!");
		} catch (Exception erro) {
			resultado.rejectValue("usuario.imagem", "", "Falha ao carregar imagem!");
		}
		return "";
	}
}
