package com.mirae.pkg.jwt;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mirae.pkg.repo.TokenDao;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	@Autowired
	TokenDao tokenDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("mirae@Asset".equals(username)) {
			return new User("mirae@Asset", "$2a$10$pDoA905A144mQNjy86X7.ekPdw7MqB6PvOmW1H4oOeGa0eeal5ZBu",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	
}

//@Autowired
//UsersDao usersDao;
////@Override
//public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	try {

//	if(username != null) {
//		JwtRequest jwtRequest = usersDao.getUser(username);
//		jwtRequest.getUsername();
//		jwtRequest.getPassword();
//		System.out.println("-------jwtRequest1----"+jwtRequest);
//	}
//	JwtResponse dd = tokenDao.getToken(username);
//	System.out.println("------TOKEN--------"+dd);

//}catch(BadCredentialsException e) {
//
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//		return null;
//	}




