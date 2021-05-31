package com.cognizant.truyum.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	private static Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("pwd")).roles("USER");
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() 
	{

		LOGGER.info("Start");
		
		return new BCryptPasswordEncoder();

	}
	
//	@Override
//
//	protected void configure(HttpSecurity httpSecurity) throws Exception 
//	{
//
//		httpSecurity.csrf().disable().httpBasic().and()
//	
//		.authorizeRequests()
//		.antMatchers("/countries").hasRole("USER")
//		.antMatchers("/authenticate").hasAnyRole("USER","ADMIN");
//		//.antMatchers("/authenticate").permitAll();
//
//	}
	
	
	@Override

	protected void configure(HttpSecurity httpSecurity) throws Exception {

	httpSecurity.csrf().disable().httpBasic().and()

	.authorizeRequests()

	//.antMatchers("/countries").hasRole("USER")

	.antMatchers("/authenticatetoken").hasAnyRole("USER", "ADMIN")
//	.antMatchers("/show-menu-list-admin").hasRole("ADMIN")

	.anyRequest().authenticated()

	.and()

	.addFilter(new JwtAuthorizationFilter(authenticationManager()));

	}
}
