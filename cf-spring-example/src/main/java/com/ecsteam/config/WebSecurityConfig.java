package com.ecsteam.config;

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private UUID randomPassword = null;

	// this method is only overridden to show what spring boot does for you
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/**/favicon.ico");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		if (randomPassword == null) {
			randomPassword = UUID.randomUUID();
			auth.inMemoryAuthentication().withUser("user").password(randomPassword.toString()).roles("USER");

			System.out.println("Using default password: " + randomPassword.toString());
		}
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//@formatter:off
		http
			.authorizeRequests()
				.anyRequest()
				.authenticated()
			.and()
				.httpBasic()
			.and()
				.anonymous()
				.disable();
		//@formatter:on
	}

}
