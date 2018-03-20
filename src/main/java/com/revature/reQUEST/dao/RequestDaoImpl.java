package com.revature.reQUEST.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.reQUEST.pojo.Request;
import com.revature.reQUEST.util.ConnectionFactory;

public class RequestDaoImpl implements RequestDao {

	public List<Request> getRequestsForEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Returns all reimbursement request records
	 * @return 		list of requests that contains every record in the requests table at the time
	 */
	public List<Request> getAllRequests() {
		List<Request> allReq = new ArrayList<Request>();
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "select r.id, r.requestor_id, r.datesubmitted, r.sprvsr_id, r.sprvsr_approval, r.dpt_head_id, r.dpt_head_approval, r.request_status, " + 
				"e.name, r.eventdatetime, r.eventcost, r.eventtype_id, e.coverage, r.reqreimb, se.dirlink, se.hasapproval, " + 
				"se.hasfinalgrade, g.gradeformat, g.passinggrade, g.finalgrade, g.passorfail, r.justification " + 
				"from requests r, eventtypes e, grades g, SUPPORTINGEVIDENCE se " + 
				"where r.eventtype_id = e.id " + 
				"and r.evidence_id = se.id " + 
				"and r.grade_id = g.id ";
		Request req = null;
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				// initialize next row as another Account in the List
				req = new Request();
				req.setId(rs.getInt(1));
				req.setRequestorId(rs.getInt(2));
				req.setDateSubmitted(rs.getString(3));
				req.setSprvsrId(rs.getInt(4));
				req.setSprvsrApproval(rs.getInt(5));
				req.setDeptHeadId(rs.getInt(6));
				req.setDeptHeadApproval(rs.getInt(7));
				req.setRequestStatus(rs.getInt(8));
				req.setEventName(rs.getString(9));
				req.setEventDateTime(rs.getString(10));
				req.setEventCost(rs.getDouble(11));
				req.setEventTypeId(rs.getInt(12));
				req.setCoverageAmt(rs.getDouble(13));
				req.setReimbursementAmt(rs.getDouble(14));
				req.setEvidenceDirectoryLink(rs.getString(15));
				req.setHasApproval(rs.getInt(16));
				req.setHasFinalGrade(rs.getInt(17));
				req.setGradeFormat(rs.getString(18));
				req.setPassingGrade(rs.getString(19));
				req.setPassOrFail(rs.getInt(20));
				req.setJustification(rs.getString(21));
				
				allReq.add(req);	
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allReq;
	}

	/**
	 * Returns all request records for a given department
	 * @param int	id code corresponding to the department
	 * @return		list of records
	 */
	public List<Request> getAllRequestsByDept(int departmentId) {
		List<Request> depReq = new ArrayList<Request>();
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "select r.id, r.requestor_id, r.datesubmitted, r.sprvsr_id, r.sprvsr_approval, r.dpt_head_id, r.dpt_head_approval, r.request_status, " + 
				"e.name, r.eventdatetime, r.eventcost, r.eventtype_id, e.coverage, r.reqreimb, se.dirlink, se.hasapproval, " + 
				"se.hasfinalgrade, g.gradeformat, g.passinggrade, g.finalgrade, g.passorfail, r.justification " + 
				"from requests r, eventtypes e, grades g, SUPPORTINGEVIDENCE se " + 
				"where r.eventtype_id = e.id " + 
				"and r.evidence_id = se.id " + 
				"and r.grade_id = g.id "
				+ "and r.requestor_id = ("
				+ "select emp.id from employees emp where emp.department_id = ? ) ";
		Request req = null;
		
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, departmentId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				req = new Request();
				req.setId(rs.getInt(1));
				req.setRequestorId(rs.getInt(2));
				req.setDateSubmitted(rs.getString(3));
				req.setSprvsrId(rs.getInt(4));
				req.setSprvsrApproval(rs.getInt(5));
				req.setDeptHeadId(rs.getInt(6));
				req.setDeptHeadApproval(rs.getInt(7));
				req.setRequestStatus(rs.getInt(8));
				req.setEventName(rs.getString(9));
				req.setEventDateTime(rs.getString(10));
				req.setEventCost(rs.getDouble(11));
				req.setEventTypeId(rs.getInt(12));
				req.setCoverageAmt(rs.getDouble(13));
				req.setReimbursementAmt(rs.getDouble(14));
				req.setEvidenceDirectoryLink(rs.getString(15));
				req.setHasApproval(rs.getInt(16));
				req.setHasFinalGrade(rs.getInt(17));
				req.setGradeFormat(rs.getString(18));
				req.setPassingGrade(rs.getString(19));
				req.setPassOrFail(rs.getInt(20));
				req.setJustification(rs.getString(21));
				depReq.add(req);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return depReq;
	}
	
	public List<Request> getAllRequestsBySupervisor(int supervisorId) {
		List<Request> subReq = new ArrayList<Request>();
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "select r.id, r.requestor_id, r.datesubmitted, r.sprvsr_id, r.sprvsr_approval, r.dpt_head_id, r.dpt_head_approval, r.request_status, " + 
				"e.name, r.eventdatetime, r.eventcost, r.eventtype_id, e.coverage, r.reqreimb, se.dirlink, se.hasapproval, " + 
				"se.hasfinalgrade, g.gradeformat, g.passinggrade, g.finalgrade, g.passorfail, r.justification " + 
				"from requests r, eventtypes e, grades g, SUPPORTINGEVIDENCE se " + 
				"where r.eventtype_id = e.id " + 
				"and r.evidence_id = se.id " + 
				"and r.grade_id = g.id "
				+ "and r.requestor_id = ("
				+ "select emp.id from employees emp where emp.reportsto_id = ? ) ";
		Request req = null;
		
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, supervisorId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				req = new Request();
				req.setId(rs.getInt(1));
				req.setRequestorId(rs.getInt(2));
				req.setDateSubmitted(rs.getString(3));
				req.setSprvsrId(rs.getInt(4));
				req.setSprvsrApproval(rs.getInt(5));
				req.setDeptHeadId(rs.getInt(6));
				req.setDeptHeadApproval(rs.getInt(7));
				req.setRequestStatus(rs.getInt(8));
				req.setEventName(rs.getString(9));
				req.setEventDateTime(rs.getString(10));
				req.setEventCost(rs.getDouble(11));
				req.setEventTypeId(rs.getInt(12));
				req.setCoverageAmt(rs.getDouble(13));
				req.setReimbursementAmt(rs.getDouble(14));
				req.setEvidenceDirectoryLink(rs.getString(15));
				req.setHasApproval(rs.getInt(16));
				req.setHasFinalGrade(rs.getInt(17));
				req.setGradeFormat(rs.getString(18));
				req.setPassingGrade(rs.getString(19));
				req.setPassOrFail(rs.getInt(20));
				req.setJustification(rs.getString(21));
				subReq.add(req);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return subReq;
	}

	public void createNewRequest(Request request) {
		// TODO Auto-generated method stub
		
	}

	public void updatePendingRequest(Request request) {
		// TODO Auto-generated method stub
		
	}

}
