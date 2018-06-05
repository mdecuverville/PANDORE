package isep.project.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source

	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// use jdbc authentication ... oh yeah!!!

//		auth.jdbcAuthentication().dataSource(securityDataSource);

		auth.inMemoryAuthentication().withUser("user1").password("test").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user2").password("test").roles("TEACHER");
		auth.inMemoryAuthentication().withUser("user3").password("test").roles("STUDENT");
		auth.inMemoryAuthentication().withUser("user4").password("test").roles("ADMINISTRATOR");


	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/administration/**").hasAnyRole("ADMINISTRATOR", "TEACHER", "ADMIN")
				.antMatchers("/student/**").hasAnyRole( "STUDENT", "ADMIN")
				.antMatchers("/administrator/**").hasRole( "ADMIN")
				.antMatchers("/*/add").hasRole( "ADMIN")
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
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }


		
}






