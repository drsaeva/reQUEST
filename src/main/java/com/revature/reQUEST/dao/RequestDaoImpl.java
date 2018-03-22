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
		List<Request> myReq = new ArrayList<Request>();
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "SELECT * FROM REQUESTS WHERE REQUESTOR_ID = ? ";
		Request req = null;
		
		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employeeId);
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
				req.setEventTypeId(rs.getInt(9));
				req.setEventName(rs.getString(10));
				req.setEventDateTime(rs.getString(11));
				req.setEventEndDate(rs.getString(12));
				req.setEventCost(rs.getDouble(13));
				req.setReimbursementAmt(rs.getDouble(14));
				req.setUrgent(rs.getInt(15));
				req.setJustification(rs.getString(16));
				req.setEvidenceDirectoryLink(rs.getString(17));
				req.setEvidenceHasApproval(rs.getInt(18));
				req.setGradeFormat(rs.getString(19));
				req.setPassingGrade(rs.getString(20));
				req.setFinalGrade(rs.getString(21));
				req.setPassOrFail(rs.getInt(22));
				myReq.add(req);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myReq;
	}
	
	/**
	 * Returns all reimbursement request records
	 * @return 		list of requests that contains every record in the requests table at the time
	 */
	public List<Request> getAllRequests() {
		List<Request> allReq = new ArrayList<Request>();
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "SELECT * FROM RESULTS ";
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
				req.setEventTypeId(rs.getInt(9));
				req.setEventName(rs.getString(10));
				req.setEventDateTime(rs.getString(11));
				req.setEventEndDate(rs.getString(12));
				req.setEventCost(rs.getDouble(13));
				req.setReimbursementAmt(rs.getDouble(14));
				req.setUrgent(rs.getInt(15));
				req.setJustification(rs.getString(16));
				req.setEvidenceDirectoryLink(rs.getString(17));
				req.setEvidenceHasApproval(rs.getInt(18));
				req.setGradeFormat(rs.getString(19));
				req.setPassingGrade(rs.getString(20));
				req.setFinalGrade(rs.getString(21));
				req.setPassOrFail(rs.getInt(22));
				allReq.add(req);	
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allReq;
	}

	/**
	 * Returns all request records for a given department
	 * @param int	department's id (Departments.Id)
	 * @return		list of records
	 */
	public List<Request> getAllRequestsByDept(int departmentId) {
		List<Request> depReq = new ArrayList<Request>();
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "SELECT * FROM REQUESTS WHERE REQUESTOR_ID = ("
				+ "SELECT EMP.ID FROM EMPLOYEES EMP WHERE EMP.DEPARTMENT_ID = ? ) ";
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
				req.setEventTypeId(rs.getInt(9));
				req.setEventName(rs.getString(10));
				req.setEventDateTime(rs.getString(11));
				req.setEventEndDate(rs.getString(12));
				req.setEventCost(rs.getDouble(13));
				req.setReimbursementAmt(rs.getDouble(14));
				req.setUrgent(rs.getInt(15));
				req.setJustification(rs.getString(16));
				req.setEvidenceDirectoryLink(rs.getString(17));
				req.setEvidenceHasApproval(rs.getInt(18));
				req.setGradeFormat(rs.getString(19));
				req.setPassingGrade(rs.getString(20));
				req.setFinalGrade(rs.getString(21));
				req.setPassOrFail(rs.getInt(22));
				depReq.add(req);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return depReq;
	}
	
	/**
	 * Returns all request records for employees reporting to a given supervisor
	 * @param int	supervisor's id (Employees.Id)
	 * @return		list of records
	 */
	public List<Request> getAllRequestsBySupervisor(int supervisorId) {
		List<Request> subReq = new ArrayList<Request>();
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "SELECT * FROM REQUESTS WHERE REQUESTOR_ID = ("
				+ "SELECT EMP.ID FROM EMPLOYEES EMP WHERE EMP.REPORTSTO = ? ) ";
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
				req.setEventTypeId(rs.getInt(9));
				req.setEventName(rs.getString(10));
				req.setEventDateTime(rs.getString(11));
				req.setEventEndDate(rs.getString(12));
				req.setEventCost(rs.getDouble(13));
				req.setReimbursementAmt(rs.getDouble(14));
				req.setUrgent(rs.getInt(15));
				req.setJustification(rs.getString(16));
				req.setEvidenceDirectoryLink(rs.getString(17));
				req.setEvidenceHasApproval(rs.getInt(18));
				req.setGradeFormat(rs.getString(19));
				req.setPassingGrade(rs.getString(20));
				req.setFinalGrade(rs.getString(21));
				req.setPassOrFail(rs.getInt(22));
				subReq.add(req);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return subReq;
	}

	public void createNewRequest(Request request) {
		Connection conn = ConnectionFactory.getInstance().getConnection();
		String sql = "INSERT INTO REQUESTS (REQUESTOR_ID, DATESUBMITTED, SPRVSR_ID, "
				+ "SPRVSR_APPROVAL, DPT_HEAD_ID, DPT_HEAD_APPROVAL, REQUEST_STATUS, EVENTTYPE_ID, "
				+ "EVENTNAME, EVENTDATETIME, EVENTENDDATE, EVENTCOST, REQREIMB, URGENT, "
				+ "JUSTIFICATION, EVIDENCE_DIRLINK, EVIDENCE_HASAPPROVAL, GRADEFORMAT, "
				+ "PASSINGGRADE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

		try {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, request.getRequestorId());
			ps.setString(2, request.getDateSubmitted());
			ps.setInt(3,request.getSprvsrId());
			ps.setInt(4,request.getSprvsrApproval());
			ps.setInt(5,request.getDeptHeadId());
			ps.setInt(6,request.getDeptHeadApproval());
			ps.setInt(7, request.getRequestStatus());
			ps.setInt(8, request.getEventTypeId());
			ps.setString(9, request.getEventName());
			ps.setString(10, request.getEventDateTime());
			ps.setString(11, request.getEventEndDate());
			ps.setDouble(12, request.getEventCost());
			ps.setDouble(13, request.getReimbursementAmt());
			ps.setInt(14, request.getUrgent());
			ps.setString(15, request.getJustification());
			ps.setString(16, request.getEvidenceDirectoryLink());
			ps.setInt(17, request.getEvidenceHasApproval());
			ps.setString(18, request.getGradeFormat());
			ps.setString(19, request.getPassingGrade());
			
			int rowsAffected = ps.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 *
ID                   NOT NULL NUMBER(3)     
REQUESTOR_ID, DATESUBMITTED, SPRVSR_ID, SPRVSR_APPROVAL, DPT_HEAD_ID, DPT_HEAD_APPROVAL, 
REQUEST_STATUS, EVENTTYPE_ID, EVENTNAME, EVENTDATETIME, EVENTENDDATE, EVENTCOST, 
REQREIMB, URGENT, JUSTIFICATION, EVIDENCE_DIRLINK, EVIDENCE_HASAPPROVAL, GRADEFORMAT, 
PASSINGGRADE, FINALGRADE, PASSORFAIL         
	 */

	public void updatePendingRequest(Request request) {
		 // TODO Auto-generated method stub
		
	}

}
