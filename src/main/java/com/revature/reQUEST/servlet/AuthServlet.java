package com.revature.reQUEST.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.reQUEST.pojo.Employee;
import com.revature.reQUEST.pojo.LoginCredentials;
import com.revature.reQUEST.util.EmployeeUtils;
import com.revature.reQUEST.util.JwtUtil;
import com.revature.reQUEST.util.TokenBox;

@WebServlet(name="AuthServlet", urlPatterns= {"/auth"})
public class AuthServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// retrieve the email and password from the request
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// authenticate user
		Employee emp;
		LoginCredentials user = new LoginCredentials(email, password);
		EmployeeUtils.setEmp(user);
		boolean authenticated = EmployeeUtils.authenticate();
		
		if (authenticated) {
			emp = EmployeeUtils.getEmp();
		
			JwtUtil tokenService = new JwtUtil();
			try {
				TokenBox.setSessionToken(tokenService.generateToken(emp));
			} catch (NoSuchAlgorithmException | IOException e) {
				e.printStackTrace();
			}
			
			// TODO store token and send response
			if (TokenBox.getSessionToken() != null) {
				response.addHeader("Authorization", TokenBox.getSessionToken());
				response.sendRedirect("landing.html");
			}
			
		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}
	}
}