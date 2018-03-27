package com.revature.reQUEST;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import com.revature.reQUEST.pojo.Employee;
import com.revature.reQUEST.pojo.LoginCredentials;
import com.revature.reQUEST.util.EmployeeUtils;
import com.revature.reQUEST.util.JwtUtil;
import com.revature.reQUEST.util.TokenBox;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	/*LoginCredentials user = new LoginCredentials("j.stevens@fake.com", "1234");
    	EmployeeUtils.setEmp(user);
        System.out.println(EmployeeUtils.authenticate());
        
        Employee emp = EmployeeUtils.getEmp();
		
		JwtUtil tokenService = new JwtUtil();
		try {
			TokenBox.setSessionToken(tokenService.generateToken(emp));
		} catch (NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}
		
		// TODO store token and send response
		if (TokenBox.getSessionToken() != null) {
			System.out.println("Authorization: "+TokenBox.getSessionToken());
		}*/
    }
}
