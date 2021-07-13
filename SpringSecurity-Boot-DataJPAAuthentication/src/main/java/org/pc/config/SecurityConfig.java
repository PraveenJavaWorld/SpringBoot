package org.pc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(encoder);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		antMatchers("/welcome").permitAll().
		antMatchers("/show").hasAuthority("MANAGER").
		anyRequest().hasAuthority("MANAGER").
		and().formLogin().
		and().logout().logoutSuccessUrl("/welcome/login?logout").
		and().exceptionHandling().accessDeniedPage("/denied");
	}

}
