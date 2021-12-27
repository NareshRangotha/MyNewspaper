package com.newspaper.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newspaper.dao.IUserDao;
//import com.newspaper.Exceptions.UserFoundException;
import com.newspaper.model.User;
import com.newspaper.services.IUserService;

@Service
public class UserServiceImplementation implements IUserService {

	@Autowired
	private IUserDao userDao;

	public User createUser(User user) {
		User local = this.userDao.findByUserName(user.getUserName());
		try {
			if (local != null) {
				throw new Exception();
			} else {
				local = this.userDao.save(user);
			}
		} catch (Exception e) {
		}

		return local;
	}

	@Override
	public User getUserByName(String username) {

		return this.userDao.findByUserName(username);
	}

	@Override
	public User getUserByUserId(long userId) {

		return this.userDao.findById(userId).get();
	}

	@Override
	public void deleteUser(long userId) {
		this.userDao.deleteById(userId);
	}

	@Override
	public User getAllUser() {

		return (User) this.userDao.findAll();

	}

	@Override
	public List<User> getVendorDetails() {
		return this.userDao.getVendorDetails();
	}

	@Override
	public void updateUser(User user) {

		this.userDao.save(user);
	}

	@Override
	public List<User> getUserByNameAndRole(String username, String role) {

		return this.userDao.getUserByNameAndRole(username, role);
	}

}
