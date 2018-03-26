package com.revature.reQUEST.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.reQUEST.pojo.Employee;

public class JwtUtil {
	
	private static String code = "secret";
	
	public String generateToken(Employee emp) throws NoSuchAlgorithmException, IOException{
		String encryptedToken = null;
		String userData = new ObjectMapper().writeValueAsString(emp);
		
		// Prepare JWT with claims set
		try {
			Algorithm algorithm = Algorithm.HMAC256(code);
		    encryptedToken = JWT.create()
		        .withIssuer("reQUEST")
		        .withSubject(userData)
		        .sign(algorithm);
		} catch (UnsupportedEncodingException exception){
		    //UTF-8 encoding not supported
		} catch (JWTCreationException exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		}

	    return encryptedToken;
	}
	
	//TODO properly implement token verification 
	/*public boolean verifyToken(String requestorToken) {
		try {
		    Algorithm algorithm = Algorithm.HMAC256("secret");
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer("auth0")
		        .build(); //Reusable verifier instance
		    DecodedJWT jwt = verifier.verify(token);
		} catch (UnsupportedEncodingException exception){
		    //UTF-8 encoding not supported
		} catch (JWTVerificationException exception){
		    //Invalid signature/claims
		}
		
		return false;
	}*/
}