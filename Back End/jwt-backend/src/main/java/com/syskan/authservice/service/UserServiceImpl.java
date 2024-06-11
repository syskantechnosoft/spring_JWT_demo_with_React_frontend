package com.syskan.authservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.syskan.authservice.model.User;
import com.syskan.authservice.repo.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		System.out.println(user);

		if (user == null) {
			throw new UsernameNotFoundException("User not found with this email" + username);

		}

		System.out.println("Loaded user: " + user.getEmail() + ", Role: " + user.getRole());
		List<GrantedAuthority> authorities = new ArrayList<>();
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

}
