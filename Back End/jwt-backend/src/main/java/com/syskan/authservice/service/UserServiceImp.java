package com.syskan.authservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syskan.authservice.model.User;
import com.syskan.authservice.repo.UserRepository;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public User findUserById(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).get();
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
