package com.newspaper.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.newspaper.model.User;

public interface IUserController {


	/**
	 * This method is used to add user
	 * @param user
	 * @return user
	 */
	@PostMapping("/addUser/")
	public ResponseEntity<User> addUser(@RequestBody User user);
	
	/**
	 * This method is used to add vendor
	 * @param user
	 * @return vendor
	 */
	@PostMapping("/addVendor/")
	public ResponseEntity<User> addVendor(@RequestBody User user);
	
	/**
	 * This method is used to get details of vendors
	 * @return list of vendors
	 */
	@GetMapping("/vendorDetails/")
	public List<User> getVendorDetails();

	/**
	 * this method is used to get user details
	 * @param user_id
	 * @return user
	 */
	@GetMapping("/userDetails/{user_id}")
	public User getUserDetails(@PathVariable("user_id") Long user_id);
	
	/**
	 * This method is used to delete user by userid
	 * @param user_id
	 * @return
	 */
	@DeleteMapping("/deleteUserById/{user_id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("user_id") Long user_id);

	/**
	 * This method is used to update user details
	 * @param user
	 * @param user_id
	 */
	@PutMapping("/updateUser/{user_id}")
	public void updateUser(@RequestBody User user,@PathVariable("user_id") Long user_id);
	
	/**
	 * This method is used to activate vendor
	 * @param user
	 */
	@PutMapping("/activateVendor/")
	public void activateVendor(@RequestBody User user);

}
