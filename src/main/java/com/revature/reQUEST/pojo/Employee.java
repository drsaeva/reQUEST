package com.revature.reQUEST.pojo;

/**
 * Employeee Pojo for record in Employees table
 * @author dsaeva
 *
 */

public class Employee {
	private int id;
	private String lastName;
	private String firstName;
	private String email;
	private String password;
	private int reportsTo;
	private int positionId;
	private String position;
	private int departmentId;
	private String department;
	private double availableReimbursement;
	private double totalReimbursement;
	private double pendingReimbursement;
	private double awardedReimbursement;
	
	//
	
	// No-args constructor
	public Employee() { };
	
	/* Accessors / Mutators */
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReportsTo() {
		return reportsTo;
	}
	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}
	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getAvailableReimbursement() {
		return availableReimbursement;
	}
	public void setAvailableReimbursement(double availableReimbursement) {
		this.availableReimbursement = availableReimbursement;
	}
	public double getTotalReimbursement() {
		return totalReimbursement;
	}
	public void setTotalReimbursement(double totalReimbursement) {
		this.totalReimbursement = totalReimbursement;
	}
	public double getPendingReimbursement() {
		return pendingReimbursement;
	}
	public void setPendingReimbursement(double pendingReimbursement) {
		this.pendingReimbursement = pendingReimbursement;
	}
	public double getAwardedReimbursement() {
		return awardedReimbursement;
	}
	public void setAwardedReimbursement(double awardedReimbursement) {
		this.awardedReimbursement = awardedReimbursement;
	}
}
