package com.revature.reQUEST.pojo;

/**
 * Bean storing posted login credentials for server-side validation
 * @author drsae_000
 *
 */
public class LoginCredentials {
	
	private String email;
	private String password;
	
	public LoginCredentials(String em, String pw) {
		this.email = em;
		this.password = pw;
	}
	
	public LoginCredentials() { }
	
	public void setEmail(String em) { this.email = em; }
	public void setPassword(String pw) { this.password = pw; }
	public String getEmail() { 		 return email; }
	public String getPassword() { return password; }
}
