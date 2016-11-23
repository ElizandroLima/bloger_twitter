package twitter.model;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void salvarImagemServidor(HttpServletRequest requisicao, HttpServletResponse resposta) {
		DiskFileItemFactory fabricaArquivos;
		ServletFileUpload upload;
		List<FileItem> listaItens;
		boolean multiPart;
		String nomeArquivoCompleto, nomeArquivo, diretorioUpload;
		File arquivoUpload;

		// Verifica se a requisição é para upload de arquivos (enctype="multipart/form-data")
		multiPart = ServletFileUpload.isMultipartContent(requisicao);

		if (multiPart) {
			// Cria uma fábrica para os listaItens armazenados em disco (arquivo temporário)	
			fabricaArquivos = new DiskFileItemFactory();
			// Define o tamanho máximo do arquivo (em bytes) 
			fabricaArquivos.setSizeThreshold(1 * 1024 * 1024);
			// Cria um manipulador para o upload de arquivos
			upload = new ServletFileUpload(fabricaArquivos);

			// Lista que vai armazenar os arquivos que foram enviados (no caso 1)
			listaItens = null;
			try {
				// Recupera a lista de listaItens do formulário a partir da requisição (parser)
				listaItens = upload.parseRequest(requisicao);
			} catch (FileUploadException erro) {
				System.err.println("Falha ao recuperar imagem do formulário! => " + erro.getMessage());
			}

			// Processa os listaItens para upload (no caso 1 só imagem)
			for (FileItem item : listaItens) {
				// Verifica se o item é um arquivo, nesse caso salva o arquivo no local específico
				if (!item.isFormField()) {
					nomeArquivoCompleto = item.getName();

					// Recupera somente o nome do arquivo
					nomeArquivo = nomeArquivoCompleto.substring(nomeArquivoCompleto.lastIndexOf("\\") + 1,
					                nomeArquivoCompleto.length());

					// Define o caminho do arquivo
					diretorioUpload = getServletContext().getRealPath("/") + "uploads\\";

					// Cria um arquivo onde será salvo o arquivo de upload
					arquivoUpload = new File(diretorioUpload, nomeArquivo);
					try {
						// Salva o arquivo no local específico
						item.write(arquivoUpload);

					} catch (Exception erro) {
						System.err.println("Falha ao salvar imagem no servidor! => " + erro.getMessage());
					}
				}
			}
		}
	}
}
