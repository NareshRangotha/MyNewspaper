package com.newspaper.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.newspaper.dao.IUserDao;
import com.newspaper.model.User;

@Service
@CrossOrigin("http://localhost:4200")
public class UserDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	private IUserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userDao.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("No user found123 !!");
		}

		return user;
	}

}
