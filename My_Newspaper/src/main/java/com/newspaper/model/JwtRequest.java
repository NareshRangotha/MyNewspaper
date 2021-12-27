package com.newspaper.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JwtRequest {

	String username;
	String password;

	private Logger logger = LoggerFactory.getLogger(JwtRequest.class);

	public JwtRequest() {
	}

	public JwtRequest(String username, String password) {
		logger.info("Inside @class :JwtRequest @constructor :JwtRequest");

		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		logger.info("Inside @class :JwtRequest @Method :getUsername");
		return username;
	}

	public void setUsername(String username) {
		logger.info("Inside @class :JwtRequest @Method :setUsername");
		this.username = username;
	}

	public String getPassword() {
		logger.info("Inside @class :JwtRequest @Method :getPassword");
		return password;
	}

	public void setPassword(String password) {
		logger.info("Inside @class :JwtRequest @Method :setPassword");
		this.password = password;
	}

	@Override
	public String toString() {
		return "JwtRequest{" + "username='" + username + '\'' + ", password='" + password + '\'' + '}';
	}
}
