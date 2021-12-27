	package com.newspaper.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.newspaper.model.User;

public interface IUserDao extends JpaRepository<User, Long> {
	
	
	public User findByUserName(String userName);
	
	@Query(value="SELECT * FROM users where role='VENDOR'", nativeQuery=true)
	public List<User> getVendorDetails();

	@Query(value="SELECT * FROM users where role=:role AND user_name=:username", nativeQuery=true)
	public List<User> getUserByNameAndRole(@Param("username") String username,@Param("role") String role);
}
