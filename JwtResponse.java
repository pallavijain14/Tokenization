package com.mirae.pkg.jwt;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TOKENIZATION")
public class JwtResponse implements Serializable{
	
	private static final long serialVersionUID = -8091879091924046844L;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment") 
	public int id;
	
	@Column(name="JWT_TOKEN")
	public String jwttoken;
	
	@Column(name = "SESSION_ID")
	public String sessionId;
	
	public JwtResponse() {
		super();
	}

	public String getJwttoken() {
		return jwttoken;
	}

	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public JwtResponse(int id,String jwttoken, String sessionId) {
		super();
		this.id = id;
		this.jwttoken = jwttoken;
		this.sessionId = sessionId;
	}

	

	

	

	

	
	
}
