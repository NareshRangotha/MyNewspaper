package com.newspaper.services;

import java.util.List;

import com.newspaper.model.User;

public interface IUserService {

	/**
	 * This method is used to create user
	 * @param user
	 * @return user
	 */
	public User createUser(User user);

	/**
	 * This method is used to get user by user name
	 * @param username
	 * @return user
	 */
	public User getUserByName(String username);

	/**
	 * This method is used to get user by user name and role
	 * @param username
	 * @param role
	 * @return list of role
	 */
	public List<User> getUserByNameAndRole(String username, String role);

	/**
	 * This method is used to update user
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * This method is used to get vendor details
	 * @return list of user
	 */
	public List<User> getVendorDetails();

	/**
	 * This method is used to delete user by userid
	 * @param userId
	 */
	public void deleteUser(long userId);

	/**
	 * This method is used to get all users
	 * @return user
	 */
	public User getAllUser();

	/**
	 * This method is user to get user by userid
	 * @param userId
	 * @return user
	 */
	public User getUserByUserId(long userId);

}
