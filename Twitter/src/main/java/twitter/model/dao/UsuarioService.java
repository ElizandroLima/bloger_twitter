package twitter.model.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import twitter.model.Usuario;
import twitter.model.repository.UsuarioRepository;
import twitter.model.repository.UsuarioServiceRepository;

@Service
@Primary
public class UsuarioService implements UserDetailsService, UsuarioServiceRepository {

	@Autowired
	private UsuarioRepository repositorio;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario;

		usuario = repositorio.buscarUsuarioPorUsername(username);

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado.");
		}
		return usuario;
	}

	@Override
	@Transactional
	public boolean cadastrarUsuario(Usuario usuario) {
		String passwordCriptografado;
		BCryptPasswordEncoder encoder;

		encoder = new BCryptPasswordEncoder();
		passwordCriptografado = encoder.encode(usuario.getPassword());
		usuario.setPassword(passwordCriptografado);

		if (repositorio.inserir(usuario)) {
			return true;
		}
		return false;
	}
}
