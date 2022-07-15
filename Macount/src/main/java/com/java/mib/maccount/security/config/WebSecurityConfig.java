package com.java.mib.maccount.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import groovy.util.logging.Log4j2;

@Configuration
@Log4j2
@EnableWebSecurity
public class WebSecurityConfig{
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/login","/signup").permitAll()
						.antMatchers("/home").hasRole("MEMBER");
		http.formLogin()
			.loginPage("/login")
			.usernameParameter("userid")
			.loginProcessingUrl("/login");
		http.csrf().disable();
		http.logout();		
		
		return http.build();
	}
}
