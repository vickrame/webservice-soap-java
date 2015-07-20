package com.prios.ws.helper;

public enum UserWSRole {

	CONSULT("TEST_WS_CONSULT"),
	ECRITURE("TEST_WS_WRITE");
	
	
	private String role;
	
	private UserWSRole(String unRole){
		this.setRole(unRole);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
