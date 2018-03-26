package com.revature.reQUEST.util;

import com.revature.reQUEST.dao.EmployeeDaoImpl;
import com.revature.reQUEST.pojo.Employee;
import com.revature.reQUEST.pojo.LoginCredentials;

public class EmployeeUtils {
	
	private static EmployeeDaoImpl empDbAccess = new EmployeeDaoImpl();
	private static Employee emp;
	
	public static void setEmp(LoginCredentials user) {
		emp = null;
		emp = empDbAccess.getEmployeeForLogin(user.getEmail(), user.getPassword());
	}
	
	public static Employee getEmp() {
		return emp;
	}
	
	public static boolean authenticate() {
		if (emp != null) return true;
		return false;
	}
}
