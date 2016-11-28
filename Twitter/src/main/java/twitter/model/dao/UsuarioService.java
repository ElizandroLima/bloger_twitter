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
	private UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user;

		user = repo.buscarUsuarioPorUsername(username);

		if (user == null)
			throw new UsernameNotFoundException("Usuário não encontrado.");

		return user;
	}

	@Override
	@Transactional
	public void cadastrarUsuario(Usuario usuario) {

		BCryptPasswordEncoder encoder;
		encoder = new BCryptPasswordEncoder();

		System.out.println(usuario.getPassword());

		String passwordCriptografado;
		passwordCriptografado = encoder.encode(usuario.getPassword());
		usuario.setPassword(passwordCriptografado);

		repo.inserir(usuario);
	}

}
