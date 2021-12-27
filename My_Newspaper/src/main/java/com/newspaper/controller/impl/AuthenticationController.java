package com.newspaper.controller.impl;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newspaper.controller.IAuthenticationController;
import com.newspaper.helper.JwtUtil;
import com.newspaper.model.JwtRequest;
import com.newspaper.model.JwtResponse;
import com.newspaper.model.User;
import com.newspaper.services.impl.UserDetailsServiceImplementation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController implements IAuthenticationController {

	private Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImplementation userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;


	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		logger.info("Inside @class :AuthenticationController @Method :generateToken");
		try {
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("The username or password is incorrect");
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("The username or password is incorrect");
		}

		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());

		String token = this.jwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		} catch (DisabledException e) {
			throw new Exception("USER DISABLED " + e.getMessage());
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid Credentials " + e.getMessage());
		}

	}

	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		User user=(User) this.userDetailsService.loadUserByUsername(principal.getName());
		user.setPassword(null);
		return user;	
	
	}

}
