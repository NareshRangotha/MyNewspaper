package com.newspaper.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JwtResponse {
	String token;

	private Logger logger = LoggerFactory.getLogger(JwtResponse.class);

	public JwtResponse() {
	}

	public JwtResponse(String token) {
		logger.info("Inside @class :JwtResponse @constructor :JwtResponse");
		this.token = token;
	}

	public String getToken() {
		logger.info("Inside @class :JwtResponse @method :getToken");
		return token;
	}

	public void setToken(String token) {
		logger.info("Inside @class :JwtResponse @method :JwtRequest");
		this.token = token;
	}
}
