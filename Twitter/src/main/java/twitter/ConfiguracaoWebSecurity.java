package twitter;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ConfiguracaoWebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService usuarioService;

	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(usuarioService)
		       .passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		    .antMatchers("/")
		    .permitAll()
		    .antMatchers("/criar-conta")
		    .hasRole("admin")
		    .anyRequest()
		    .authenticated()
		    .and()
		    .formLogin()
		    .loginPage("/")
		    .permitAll()
		    .and()
		    .logout()
		    .permitAll()
		    .and()
		    .exceptionHandling()
		    .accessDeniedPage("/acesso-negado")
		    .and()
		    .csrf()
		    .disable();
	}
}*/