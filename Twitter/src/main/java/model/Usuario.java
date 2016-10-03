package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private int codigo;

	@NotEmpty(message = "Nome de usuário não pode ser vazio!")
	private String nomeUsuario;

	@NotEmpty(message = "Nome não pode ser vazio!")
	private String nome;

	@NotEmpty(message = "Email não pode ser vazio!")
	@Pattern(regexp = ".+@.+\\.[a-z]+")
	private String email;

	@Size(min = 6)
	private String senha;

	public Usuario() {}

	public int getCodigo() {
		return codigo;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
