package twitter.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Login {
	@NotEmpty(message = "Email não pode ser vazio!")
	@Pattern(regexp = ".+@.+\\.[a-z]+")
	private String username;

	@Size(min = 6)
	private String password;

	public Login() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
