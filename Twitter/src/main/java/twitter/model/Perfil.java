package twitter.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(name="perfil")
public class Perfil implements GrantedAuthority{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	
	public static final String NORMAL_USER = "normal-user";

	@Id
	@Column
	private String nome;
	
	@ManyToMany(mappedBy="papeis")
	private Set<Usuario> user;
	
	public Perfil() {}
	
	public Perfil(String nome){
		this.nome = nome;
	}
	
	@Override
	public String getAuthority() {
		return nome;
	}
}
