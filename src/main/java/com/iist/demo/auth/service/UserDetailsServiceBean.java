package com.iist.demo.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iist.demo.auth.repository.UserRepository;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceBean implements UserDetailsService{
	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.iist.demo.auth.model.User u = userRepository.get(username);
		List<GrantedAuthority> listAuthority = new ArrayList<>();
		listAuthority.add(new SimpleGrantedAuthority("USER"));
		return new User(username,u.getUserPassword(), listAuthority);
	}
}
