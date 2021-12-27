package com.newspaper.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.newspaper.services.impl.UserDetailsServiceImplementation;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	private Logger logger = LoggerFactory.getLogger(MySecurityConfig.class);

	@Autowired
	private JwtAuthenticationFilter jwtFilter;

	@Autowired
	private JwtAuthenticationEntryPoint entryPoint;

	@Autowired
	private UserDetailsServiceImplementation userDetailsServiceImplementation;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("Inside @class :MySecurityConfig @Method :configure  @parameters :http");

		http.csrf().disable().cors().disable().authorizeRequests()
				.antMatchers("/generate-token", "/user/addUser/", "/user/addVendor/", "/v2/api-docs").permitAll()
				.antMatchers(HttpMethod.OPTIONS).permitAll().anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
				.authenticationEntryPoint(entryPoint);

		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info("Inside @class :MySecurityConfig @Method :configure @parameters :auth");

		auth.userDetailsService(this.userDetailsServiceImplementation).passwordEncoder(passwordEncoder());

	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
