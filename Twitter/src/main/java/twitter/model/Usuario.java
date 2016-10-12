package twitter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue
	private int codigo;

	@NotEmpty(message = "Nome de usuário não pode ser vazio!")
	private String nomeUsuario;

	@NotEmpty(message = "Nome não pode ser vazio!")
	private String nome;

	@NotEmpty(message = "Email não pode ser vazio!")
	private String email;

	@NotEmpty(message = "Senha não pode ser vazia!")
	@Size(min = 6, message = "O tamanho mínimo da senha é de 6 caracteres!")
	private String senha;

	public Usuario() {}

	public int getCodigo() {
		return codigo;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
