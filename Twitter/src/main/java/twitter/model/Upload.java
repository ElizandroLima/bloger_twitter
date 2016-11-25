package twitter.model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class Upload {
	public String salvarImagemServidor(MultipartFile arquivo) {
		if (!arquivo.isEmpty()) {
			try {
				byte[] bytes;
				String raiz;
				File diretorio, arquivoServidor;
				BufferedOutputStream stream;

				// Converte o conteúdo do arquivo em um array de bytes
				bytes = arquivo.getBytes();

				// Cria o diretório para armazenar o arquivo
				raiz = System.getProperty("catalina.home");
				diretorio = new File(raiz + File.separator + "tmpFiles");
				if (!diretorio.exists()) {
					diretorio.mkdirs();
				}

				// Salva o arquivo no servidor
				arquivoServidor = new File(diretorio.getAbsolutePath() + File.separator + arquivo.getName());
				stream = new BufferedOutputStream(new FileOutputStream(arquivoServidor));
				stream.write(bytes);
				stream.close();

				return ">> ARQUIVO: Sucesso ao fazer upload de imagem: " + arquivo.getName();

			} catch (Exception erro) {
				return ">> ARQUIVO: Falha ao fazer upload de imagem! => " + erro.getMessage();
			}
		}
		else {
			return ">> ARQUIVO: Arquivo de imagem em branco/inexistente!";
		}
	}
}
