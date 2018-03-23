package com.revature.reQUEST.pojo;

public class Request {
	
	// request general info
	private int 	id;
	private int 	requestorId;
	private String	dateSubmitted;
	private int 	sprvsrId;
	private int 	sprvsrApproval;
	private int 	deptHeadId;
	private int 	deptHeadApproval;
	private int		requestStatus;
	private String	justification;
	private int		isUrgent;
	
	// event-specific info
	private int		eventTypeId;
	private String 	eventName;
	private String 	eventDateTime;
	private String 	eventEndDate;
	private double 	eventCost;
	private double 	reimbursementAmt;
	
	
	// supporting evidence info
	private String  evidenceDirectoryLink;
	private int		evidenceHasApproval;
	
	// grade info
	private String	gradeFormat;
	private String	passingGrade;
	private String	finalGrade;
	private int		passOrFail;
	
	
	/*
ID                   NOT NULL NUMBER(3)     
REQUESTOR_ID         NOT NULL NUMBER(3)     
DATESUBMITTED        NOT NULL DATE          
SPRVSR_ID            NOT NULL NUMBER(3)     
SPRVSR_APPROVAL      NOT NULL NUMBER(3)     
DPT_HEAD_ID          NOT NULL NUMBER(3)     
DPT_HEAD_APPROVAL    NOT NULL NUMBER(3)     
REQUEST_STATUS       NOT NULL NUMBER(2)     
EVENTTYPE_ID         NOT NULL NUMBER(3)     
EVENTNAME            NOT NULL VARCHAR2(50)  
EVENTDATETIME        NOT NULL TIMESTAMP(6)  
EVENTENDDATE         NOT NULL TIMESTAMP(6)  
EVENTCOST            NOT NULL NUMBER(6,2)   
REQREIMB             NOT NULL NUMBER(6,2)   
URGENT                        NUMBER(1)     
JUSTIFICATION                 VARCHAR2(150) 
EVIDENCE_DIRLINK     NOT NULL VARCHAR2(128) 
EVIDENCE_HASAPPROVAL NOT NULL NUMBER(1)     
GRADEFORMAT          NOT NULL VARCHAR2(16)  
PASSINGGRADE         NOT NULL VARCHAR2(8)   
FINALGRADE           NOT NULL VARCHAR2(8)   
PASSORFAIL           NOT NULL NUMBER(1)   
	 */

	
	// No-args constructor
	public Request() { }
	
	/* Accessors / Mutators */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRequestorId() {
		return requestorId;
	}
	public void setRequestorId(int requestorId) {
		this.requestorId = requestorId;
	}
	public String getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	public int getSprvsrId() {
		return sprvsrId;
	}
	public void setSprvsrId(int sprvsrId) {
		this.sprvsrId = sprvsrId;
	}
	public int getSprvsrApproval() {
		return sprvsrApproval;
	}
	public void setSprvsrApproval(int sprvsrApproval) {
		this.sprvsrApproval = sprvsrApproval;
	}
	public int getDeptHeadId() {
		return deptHeadId;
	}
	public void setDeptHeadId(int deptHeadId) {
		this.deptHeadId = deptHeadId;
	}
	public int getDeptHeadApproval() {
		return deptHeadApproval;
	}
	public void setDeptHeadApproval(int deptHeadApproval) {
		this.deptHeadApproval = deptHeadApproval;
	}
	public int getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(int requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDateTime() {
		return eventDateTime;
	}
	public void setEventDateTime(String eventDateTime) {
		this.eventDateTime = eventDateTime;
	}
	public String getEventEndDate() {
		return eventEndDate;
	}
	public void setEventEndDate(String eventEndDate) {
		this.eventEndDate = eventEndDate;
	}
	public double getEventCost() {
		return eventCost;
	}
	public void setEventCost(double eventCost) {
		this.eventCost = eventCost;
	}
	public int getEventTypeId() {
		return eventTypeId;
	}
	public void setEventTypeId(int eventTypeId) {
		this.eventTypeId = eventTypeId;
	}
	public double getReimbursementAmt() {
		return reimbursementAmt;
	}
	public void setReimbursementAmt(double reimbursementAmt) {
		this.reimbursementAmt = reimbursementAmt;
	}
	public int getUrgent() {
		return isUrgent;
	}
	public void setUrgent(int isUrgent) {
		this.isUrgent = isUrgent;
	}
	public String getEvidenceDirectoryLink() {
		return evidenceDirectoryLink;
	}
	public void setEvidenceDirectoryLink(String evidenceDirectoryLink) {
		this.evidenceDirectoryLink = evidenceDirectoryLink;
	}
	public int getEvidenceHasApproval() {
		return evidenceHasApproval;
	}
	public void setEvidenceHasApproval(int evidenceHasApproval) {
		this.evidenceHasApproval = evidenceHasApproval;
	}
	public String getGradeFormat() {
		return gradeFormat;
	}
	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}
	public String getPassingGrade() {
		return passingGrade;
	}
	public void setPassingGrade(String passingGrade) {
		this.passingGrade = passingGrade;
	}
	public String getFinalGrade() {
		return finalGrade;
	}
	public void setFinalGrade(String finalGrade) {
		this.finalGrade = finalGrade;
	}
	public int getPassOrFail() {
		return passOrFail;
	}
	public void setPassOrFail(int passOrFail) {
		this.passOrFail = passOrFail;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public String getJustification(){
		return justification;
	}
	
}
