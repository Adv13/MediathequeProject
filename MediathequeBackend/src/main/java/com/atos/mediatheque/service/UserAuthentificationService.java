package com.atos.mediatheque.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atos.mediatheque.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

import com.atos.mediatheque.handlerException.EmpruntNotFoundException;
import com.atos.mediatheque.handlerException.UserNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserAuthentificationService implements UserDetailsService  {

	
	 @Autowired UserRepository userRepository;
	  
	 @Override
	 
	 @Transactional(readOnly = true) public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	 // TODO Auto-generated method stub
	 
	 com.atos.mediatheque.model.User user = userRepository.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("No such username"));
	 Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	 grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
	 return new User(user.getLogin(),"{noop}" + user.getPassword(), grantedAuthorities); }
	 
}
