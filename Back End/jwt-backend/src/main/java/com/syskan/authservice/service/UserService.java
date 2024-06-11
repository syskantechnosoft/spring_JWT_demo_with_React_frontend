package com.syskan.authservice.service;

import java.util.List;

import com.syskan.authservice.model.User;

public interface UserService {

//	public User findUserProfileByJwt(String jwt);

	public User findUserByEmail(String email);

	public User findUserById(String userId);

	public List<User> findAllUsers();

}
