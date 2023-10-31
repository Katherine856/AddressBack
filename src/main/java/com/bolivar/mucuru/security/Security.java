package com.bolivar.mucuru.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

//Activar politica de cors
public class Security {
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().authorizeHttpRequests().requestMatchers("/**").permitAll();
	}
}
