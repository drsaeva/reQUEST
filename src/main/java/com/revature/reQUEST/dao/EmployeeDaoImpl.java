package com.revature.reQUEST.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.reQUEST.pojo.Employee;
import com.revature.reQUEST.pojo.Request;
import com.revature.reQUEST.util.ConnectionFactory;

public class EmployeeDaoImpl implements EmployeeDao {

	public Employee getEmployeeForLogin(String email, String password) {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "SELECT EMP.ID, EMP.LASTNAME, EMP.FIRSTNAME, EMP.EMAIL, EMP.REPORTSTO, "
				+ "POS.ID, POS.TITLE, DEP.ID, DEP.TITLE, EMP.AVAIL_REIMB, EMP.TOTAL_REIMB, "
				+ "EMP.PNDNG_REIMB, EMP.AWARD_REIMB FROM EMPLOYEES EMP, POSITIONS POS, "
				+ "DEPARTMENTS DEP WHERE EMP.POSITION_ID = POS.ID AND "
				+ "EMP.DEPARTMENT_ID = DEP.ID AND EMP.EMAIL = ? AND EMP.PASSWORD = ? ";
		Employee emp = null;
		
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setLastName(rs.getString(2));
				emp.setFirstName(rs.getString(3));
				emp.setEmail(rs.getString(4));
				emp.setReportsTo(rs.getInt(5));
				emp.setPositionId(rs.getInt(6));
				emp.setPosition(rs.getString(7));
				emp.setDepartmentId(rs.getInt(8));
				emp.setDepartment(rs.getString(9));
				emp.setAvailableReimbursement(rs.getDouble(10));
				emp.setTotalReimbursement(rs.getDouble(11));
				emp.setPendingReimbursement(rs.getDouble(12));
				emp.setAwardedReimbursement(rs.getDouble(13));
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return emp;
	}
	public Employee getEmployee(int id) {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "SELECT EMP.ID, EMP.LASTNAME, EMP.FIRSTNAME, EMP.EMAIL, EMP.REPORTSTO, "
				+ "POS.ID, POS.TITLE, DEP.ID, DEP.TITLE, EMP.AVAIL_REIMB, EMP.TOTAL_REIMB, "
				+ "EMP.PNDNG_REIMB, EMP.AWARD_REIMB FROM EMPLOYEES EMP, POSITIONS POS, "
				+ "DEPARTMENTS DEP WHERE EMP.POSITION_ID = POS.ID AND "
				+ "EMP.DEPARTMENT_ID = DEP.ID AND EMP.ID = ? ";
		Employee emp = null;
		
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setLastName(rs.getString(2));
				emp.setFirstName(rs.getString(3));
				emp.setEmail(rs.getString(4));
				emp.setReportsTo(rs.getInt(5));
				emp.setPositionId(rs.getInt(6));
				emp.setPosition(rs.getString(7));
				emp.setDepartmentId(rs.getInt(8));
				emp.setDepartment(rs.getString(9));
				emp.setAvailableReimbursement(rs.getDouble(10));
				emp.setTotalReimbursement(rs.getDouble(11));
				emp.setPendingReimbursement(rs.getDouble(12));
				emp.setAwardedReimbursement(rs.getDouble(13));
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return emp;
	}

}
