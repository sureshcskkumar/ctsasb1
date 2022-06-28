package com.demo.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	/*
	 * @Autowired CustomerRepository repo;
	 */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// load from database -> Optional optional = userRepository.findById(username)
//		Optional<Customer> optional = repo.findById(username);

		if ("admin".equals(username)) {
			Set<SimpleGrantedAuthority> authorities = new HashSet<>();
			authorities.add(new SimpleGrantedAuthority("ROLE_" + "ADMIN"));
			authorities.add(new SimpleGrantedAuthority("ROLE_" + "MANAGER"));
			
//			return new User("admin", "{noop}admin@123", authorities);
//			return new User("admin", "{bcrypt}$2a$10$VRi6H.qxEfXn89WKAWpdzumVcLL6yaNkOUD5lfiyG8zeEjkM8atGS", authorities);
			return new User("admin", "$2a$10$VRi6H.qxEfXn89WKAWpdzumVcLL6yaNkOUD5lfiyG8zeEjkM8atGS", authorities);
		} else if ("user".equals(username)) {

			Set<SimpleGrantedAuthority> authorities = new HashSet<>();
			authorities.add(new SimpleGrantedAuthority("ROLE_" + "USER"));

//			return new User("user", "{noop}user@123", authorities);
//			return new User("user", "{bcrypt}$2a$10$y9oWGwxUObvL5zQ3M1UHjeobr8kv56.Mk5Mc/ugsYHtddoAUC8UyK", authorities);
			return new User("user", "$2a$10$y9oWGwxUObvL5zQ3M1UHjeobr8kv56.Mk5Mc/ugsYHtddoAUC8UyK", authorities);
		} else if ("manager".equals(username)) {

			Set<SimpleGrantedAuthority> authorities = new HashSet<>();
			authorities.add(new SimpleGrantedAuthority("ROLE_" + "MANAGER"));

//			return new User("manager", "{noop}manager@123", authorities);
//			return new User("manager", "{bcrypt}$2a$10$5DJ2bVTj4M6P1Rqog2Nye.SpSQ6TtHWM5JaMm6cKvTJPavIWi1fAW", authorities);
			return new User("manager", "$2a$10$5DJ2bVTj4M6P1Rqog2Nye.SpSQ6TtHWM5JaMm6cKvTJPavIWi1fAW", authorities);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}