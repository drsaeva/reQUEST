package com.revature.reQUEST.util;

/**
 * Hacky implementation for persisting a currently-valid JWT for a session. If this app is to be further developed,
 * 	this should be replaced with a better means to persisting session JWTs (multiple), and storing such.
 * @author drsae_000
 *
 */
public abstract class TokenBox {

	private static String sessionToken = null;
	
	public static void setSessionToken(String token) {
		sessionToken = token;
	}
	public static String getSessionToken() {
		return sessionToken;
	}
	public static void invalidateSessionToken() {
		sessionToken = null;
	}
}
