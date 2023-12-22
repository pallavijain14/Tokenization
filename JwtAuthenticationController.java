package com.mirae.pkg.jwt;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mirae.pkg.repo.TokenDao;

@CrossOrigin(origins="*",allowedHeaders="*", exposedHeaders = "**")
@Controller
public class JwtAuthenticationController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	TokenDao tokenDao;

	@ResponseBody
	@CrossOrigin(origins="https://calculator.miraeassetfin.com/*", exposedHeaders = "token")
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(HttpServletRequest request) throws Exception {
		try {
			String HeadTest = request.getHeader("SessionId");

			System.out.println("sessid "+ HeadTest);
			JwtRequest authRequest = new JwtRequest();
			authRequest.setUsername("mirae@Asset");
			authRequest.setPassword("CALmirae@asset");

			final UserDetails userdetail = this.jwtUserDetailsService.loadUserByUsername(authRequest.getUsername());

			final String token = this.jwtTokenUtil.generateToken(userdetail);
			System.out.println("JWT--> "+token.length());

			JwtResponse jwtResponse = new JwtResponse();
			jwtResponse.setJwttoken(token);
			jwtResponse.setSessionId(HeadTest);
			tokenDao.save(jwtResponse);

			System.out.println("-------------------"+jwtResponse);

			return new ResponseEntity<Object>(jwtResponse ,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("--------ERROR-------"+e);
		}
		return null;
	}
	//	private void authenticate(String username, String password) throws Exception {
	//		try {
	//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	//		} catch (DisabledException e) {
	//			throw new Exception("USER_DISABLED", e);
	//		} catch (BadCredentialsException e) {
	//			throw new Exception("INVALID_CREDENTIALS", e);
	//		}
	//	}



}
