package twitter.model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	@NotEmpty(message = "Nome de usuário não pode ser vazio!")
	@Column(unique = true)
	private String username;

	@NotEmpty(message = "Nome não pode ser vazio!")
	private String nome;

	@NotEmpty(message = "Email não pode ser vazio!")
	@Email(message = "Deve estar no formato correto de email!")
	private String email;

	@NotEmpty(message = "Senha não pode ser vazia!")
	@Size(min = 6, message = "O tamanho mínimo da senha é de 6 caracteres!")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "codigo", referencedColumnName = "codigo"), inverseJoinColumns = @JoinColumn(name = "perfil", referencedColumnName = "nome"))
	private Set<Perfil> papeis;

	private String imagem;

	public Usuario(int codigo, String username, String nome, String email, String password, Set<Perfil> papeis,
	                String imagem) {
		super();
		this.codigo = codigo;
		this.username = username;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.papeis = papeis;
		this.imagem = imagem;
	}

	public Usuario() {
		super();

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Set<Perfil> getPapeis() {
		return papeis;
	}

	public void setPapeis(Set<Perfil> papeis) {
		this.papeis = papeis;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return papeis;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String toString() {
		return "User [codigo=" + codigo + ", username=" + username + ", password=" + password + "]";
	}
}
