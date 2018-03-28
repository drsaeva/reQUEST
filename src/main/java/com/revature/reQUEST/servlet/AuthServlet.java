package com.revature.reQUEST.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.*;
import com.revature.reQUEST.pojo.Employee;
import com.revature.reQUEST.pojo.LoginCredentials;
import com.revature.reQUEST.util.EmployeeUtils;
import com.revature.reQUEST.util.JwtUtil;
import com.revature.reQUEST.util.TokenBox;


public class AuthServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// retrieve the email and password from the request
		String userParams = getBody(request);
		ObjectMapper mapper = new ObjectMapper();
		LoginCredentials user = mapper.readValue(userParams, LoginCredentials.class);
		
		
		// authenticate user
		Employee emp;
		EmployeeUtils.setEmp(user);
		boolean authenticated = EmployeeUtils.authenticate();
		
		if (authenticated) {
			emp = EmployeeUtils.getEmp();
		
			JwtUtil tokenService = new JwtUtil();
			try {
				TokenBox.setSessionToken(tokenService.generateToken(emp));
			} catch (NoSuchAlgorithmException | IOException e	) {
				e.printStackTrace();
			}
			
			// TODO store token and send response
			if (TokenBox.getSessionToken() != null) {
				response.addHeader("Authorization",TokenBox.getSessionToken());
			}
			
		} else {
			request.getRequestDispatcher("#/login").forward(request, response);

		}
	}

	public static String getBody(HttpServletRequest request) throws IOException {

	    String body = null;
	    StringBuilder stringBuilder = new StringBuilder();
	    BufferedReader bufferedReader = null;

	    try {
	        InputStream inputStream = request.getInputStream();
	        if (inputStream != null) {
	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	            char[] charBuffer = new char[128];
	            int bytesRead = -1;
	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	                stringBuilder.append(charBuffer, 0, bytesRead);
	            }
	        } else {
	            stringBuilder.append("");
	        }
	    } catch (IOException ex) {
	        throw ex;
	    } finally {
	        if (bufferedReader != null) {
	            try {
	                bufferedReader.close();
	            } catch (IOException ex) {
	                throw ex;
	            }
	        }
	    }

	    body = stringBuilder.toString();
	    return body;
	}
}