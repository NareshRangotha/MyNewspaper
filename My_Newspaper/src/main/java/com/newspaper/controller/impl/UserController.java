package com.newspaper.controller.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newspaper.controller.IUserController;
import com.newspaper.model.User;
import com.newspaper.services.IUserService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(path = "/user")
public class UserController implements IUserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public ResponseEntity<User> addUser(@RequestBody User user) {
		logger.info("Inside @class :UserController @Method :addUser");
		User local = null;
		try {
			String role = "NORMAL";

			List<User> user1 = this.userService.getUserByNameAndRole(user.getUserName(), role);

			if (user1.size() > 0) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}

			user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
			user.setRole("NORMAL");
			user.setEnabled(true);
			local = this.userService.createUser(user);
			return ResponseEntity.of(Optional.of(local));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	public ResponseEntity<User> addVendor(@RequestBody User user) {
		logger.info("Inside @class :UserController @Method :addVendor");
		User local = null;
		try {
			System.out.println("Vendor :" + user.toString());
			String role = "VENDOR";
			List<User> temp = this.userService.getUserByNameAndRole(user.getUserName(), role);
			if (temp.size() > 0) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}

			user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
			user.setRole(role);
			user.setEnabled(false);
			local = this.userService.createUser(user);
			return ResponseEntity.of(Optional.of(local));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	public ResponseEntity<?> deleteUserById(@PathVariable("user_id") Long user_id) {
		logger.info("Inside @class :UserController @Method :deleteUserById");
		if (user_id == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		userService.deleteUser(user_id);
		return ResponseEntity.ok("deleted");
	}

	@Override
	public void updateUser(User user, Long user_id) {
		logger.info("Inside @class :UserController @Method :updateUser");
		User users = null;
		try {
			users = userService.getUserByUserId(user_id);
			users.setEnabled(user.isEnabled());
			users.setContact(user.getContact());
			users.setEmail(user.getEmail());
			users.setFirstName(user.getFirstName());
			users.setLastName(user.getLastName());
			userService.updateUser(users);
		} catch (Exception e) {

		}

	}

	@Override
	public List<User> getVendorDetails() {
		List<User> vendor = this.userService.getVendorDetails();
		vendor.stream().forEach(e -> {
			e.setPassword(null);
		});

		return vendor;
	}

	@Override
	public void activateVendor(User user) {
		long id = user.getId();
		this.updateUser(user, id);
	}

	@Override
	public User getUserDetails(Long user_id) {

		User user = this.userService.getUserByUserId(user_id);
		user.setPassword(null);
		return user;
	}

}
