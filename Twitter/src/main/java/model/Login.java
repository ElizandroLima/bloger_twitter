package model;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Login {
	@NotEmpty(message = "Email não pode ser vazio!")
	@Pattern(regexp = ".+@.+\\.[a-z]+")
	private String email;

	@Size(min = 6)
	private String senha;

	public Login() {}

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
