package com.daw.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)	//Para habilitar la seguridad a nivel de método
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		 
	 //@Autowired
	 //private MyBasicAuthenticationEntryPoint authenticationEntryPoint;
	 @Autowired
	 private UserDetailsService userDetailsService;
	 @Autowired
	 private PasswordEncoder passwordEncoder;	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.cors()
//			.and()
//			.sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
//			.and()
//			.httpBasic()
//			.and()
//			.authorizeRequests()
//				.antMatchers(HttpMethod.OPTIONS, "/usuarios/**", "/roles/**", "/entradas/**", "/comentarios" ).permitAll()								
//				.antMatchers(HttpMethod.GET, "/entradas/**", "/comentarios" ).permitAll()
//				.antMatchers(HttpMethod.POST, "/usuarios/**").permitAll()
//				.antMatchers("/administrador/**").permitAll()
//				//.antMatchers(HttpMethod.GET, "/usuarios").hasRole("ADMIN")
//				.antMatchers(HttpMethod.GET, "/usuarios").permitAll()
//				.antMatchers(HttpMethod.GET, "/usuarios/**").permitAll() 
//				.antMatchers(HttpMethod.POST, "/entradas/**").permitAll()
//				.antMatchers(HttpMethod.POST, "/comentarios").permitAll()
//				.antMatchers(HttpMethod.POST, "/comentarios/**").permitAll()
//				.antMatchers(HttpMethod.PUT, "/entradas/**").permitAll()
//				.antMatchers(HttpMethod.PUT, "/comentarios/**", "/usuarios/**").permitAll()
//				.antMatchers(HttpMethod.DELETE, "/entradas/**").permitAll()
//				.antMatchers(HttpMethod.DELETE, "/comentarios/**", "/usuarios/**").permitAll()
//				.anyRequest().authenticated()
//			.and()
//			.csrf().disable();
//	}

	 public void configure(WebSecurity web) {
		 web.ignoring().anyRequest();
	 }
	 
}
