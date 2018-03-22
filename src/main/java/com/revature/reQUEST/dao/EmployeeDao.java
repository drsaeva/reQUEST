package com.revature.reQUEST.dao;

import com.revature.reQUEST.pojo.Employee;

public interface EmployeeDao {

	public Employee getEmployeeForLogin(String email, String password);
	public Employee getEmployee(int id);
}
