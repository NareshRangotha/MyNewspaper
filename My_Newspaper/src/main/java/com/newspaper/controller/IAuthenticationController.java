package com.newspaper.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.newspaper.model.JwtRequest;


public interface IAuthenticationController {


	/**
	 * This method used to login user
	 * @param jwtRequest
	 * @return user
	 * @throws Exception
	 */
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception;

}
