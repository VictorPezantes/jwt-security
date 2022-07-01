package com.pe.ttk.admision.security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtDto {
	
	private String token;
	
	public JwtDto(String token) {
		
		this.token = token;
		
	}
	
	public JwtDto() {
		
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	

}
