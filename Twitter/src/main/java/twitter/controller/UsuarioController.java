package twitter.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import twitter.model.Usuario;
import twitter.model.repository.UsuarioRepository;
import twitter.model.repository.UsuarioServiceRepository;

@Controller
public class UsuarioController {
	// Injeção do objeto UsuarioRepository dentro desse atributo, dispensando o new (instanciação)
	@Autowired
	private UsuarioRepository repositorio;
	@Autowired
	private ServletContext contexto;
	@Autowired
	private UsuarioServiceRepository service;
	private final String NOME_USUARIO = "username";
	private final String EMAIL = "email";
	private final String IMAGEM = "imagemPerfil";

	/*
	 * // Inicia a validação do usuário
	 * @InitBinder protected void initBinder(WebDataBinder binder) {
	 * binder.addValidators(new UsuarioValidator()); }
	 */
	// --------------------------------
	// CRIAÇÃO DE CONTA
	// ---------------------------------
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String criarContaForm(Model modelo, Authentication autenticacao) {
		if (autenticacao != null) {
			return "redirect:/meu-perfil";
		}
		modelo.addAttribute("criarContaModelo", new Usuario());
		return "criar-conta";
	}

	@Transactional
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String criarContaValidar(@Valid @ModelAttribute("criarContaModelo") Usuario usuario,
	                BindingResult resultado) {

		if (resultado.hasErrors()) {
			System.err.println(">> VALIDAÇÃO: Os campos contém dados inválidos!");
			return "criar-conta";
		}

		if (service.cadastrarUsuario(usuario)) {
			return "redirect:/login";
		}

		resultado.rejectValue(EMAIL, "", "Falha ao incluir usuário! Nome de usuário já existente!");
		return "criar-conta";
	}

	// --------------------------------
	// ALTERAÇÃO DE CONTA
	// ---------------------------------
	@RequestMapping(value = "/alterar-conta", method = RequestMethod.GET)
	public String alterarContaForm(Model modelo, Authentication auth) {
		try {
			// TODO Recuperar da sessão o código do usuário correspondente
			//Usuario usuario = (Usuario) auth.getPrincipal();
			Usuario usuario = repositorio.obter(2);
			modelo.addAttribute("alterarContaModelo", usuario);

		} catch (NullPointerException erro) {
			System.err.println(">> USUÁRIO: Usuário não encontrado!");
		} catch (Exception erro) {
			System.err.println(">> USUÁRIO: Falha ao recuperar dados do usuário!");
		}

		return "alterar-conta";
	}

	@Transactional
	@RequestMapping(value = "/alterar-conta", method = RequestMethod.POST)
	public String alterarContaValidar(@Valid @ModelAttribute("alterarContaModelo") Usuario usuario,
	                BindingResult resultado, @RequestParam("imagemPerfil") MultipartFile arquivo) {

		// Efetua a validação do formulário
		if (resultado.hasErrors()) {
			resultado.rejectValue(NOME_USUARIO, "", "Os campos contêm dados inválidos!");

			return "alterar-conta";
		}

		// Imagem
		if (!arquivo.isEmpty()) {
			String imagem = salvarImagem(arquivo, resultado);

			// Altera o campo no usuario
			usuario.setImagem(imagem);
		}

		// Insere o usuário no BD
		if (repositorio.alterar(usuario)) {
			resultado.rejectValue(NOME_USUARIO, "", usuario.getNome() + ", você alterou com sucesso seu perfil!");
			return "alterar-conta";
		}
		return "alterar-conta";
	}

	public String salvarImagem(MultipartFile arquivo, BindingResult resultado) {
		String nomeArquivo, nomeArquivoCompleto, raiz;
		File diretorio, caminho;
		BufferedOutputStream stream;

		try {
			// Cria o caminho para salvar o arquivo (deve ter permissão de
			// escrita)
			nomeArquivoCompleto = arquivo.getOriginalFilename();

			// Recupera somente o nome do arquivo, descartando o caminho
			// completo
			nomeArquivo = nomeArquivoCompleto.substring(nomeArquivoCompleto.lastIndexOf("\\") + 1,
			                nomeArquivoCompleto.length());

			// Recupera o caminho da aplicação
			raiz = contexto.getRealPath("resources");
			diretorio = new File(raiz + File.separator + "uploads");

			// Cria o diretório caso não exista
			if (!diretorio.exists()) {
				diretorio.mkdirs();
			}

			// Salva o arquivo no servidor
			caminho = new File(diretorio + File.separator + nomeArquivo);
			stream = new BufferedOutputStream(new FileOutputStream(caminho));
			stream.write(arquivo.getBytes());
			stream.flush();
			stream.close();

			return nomeArquivo;

		} catch (FileNotFoundException erro) {
			resultado.rejectValue(IMAGEM, "", "Arquivo não encontrado!");
		} catch (Exception erro) {
			resultado.rejectValue(IMAGEM, "", "Falha ao carregar imagem!");
		}
		return "";
	}
}
