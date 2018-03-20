package com.revature.reQUEST.dao;

import java.util.List;
import com.revature.reQUEST.pojo.Request;

public interface RequestDao {
	
	public List<Request> getRequestsForEmployee(int employeeId);
	public List<Request> getAllRequests();
	public List<Request> getAllRequestsByDept(int departmentId);
	public List<Request> getAllRequestsBySupervisor(int supervisorId);
	public void createNewRequest(Request request);
	public void updatePendingRequest(Request request);
	
}
