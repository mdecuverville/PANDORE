package isep.project.web.config;

import isep.project.web.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data sourc
	@Autowired
	private DataSource securityDataSource;

	@Autowired
	private UserAuthService userAuthService;

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userAuthService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/member/**").hasAnyRole( "ADMINISTRATOR", "TEACHER", "STUDENT", "ADMIN")
				.antMatchers("/admin/**").hasRole( "ADMIN")
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/").permitAll()
				.and()
				.httpBasic()
				.and()
				.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
				.and()
				.logout()
				.permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
	}

	@Bean
	public UserDetailsManager userDetailsManager() {

		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();

		jdbcUserDetailsManager.setDataSource(securityDataSource);

		return jdbcUserDetailsManager;
	}


	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}






