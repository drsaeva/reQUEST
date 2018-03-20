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
	
	// event-specific info
	private String 	eventName;
	private String 	eventDateTime;
	private double 	eventCost;
	private int		eventTypeId;
	private double 	coverageAmt;
	private double 	reimbursementAmt;
	
	// suporting evidence info
	private int		evidenceId;
	private String  evidenceDirectoryLink;
	private int		hasApproval;
	private int		hasFinalGrade;
	
	// grade info
	private String	gradeFormat;
	private String	passingGrade;
	private String	finalGrade;
	private int	passOrFail;
	
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
	public double getCoverageAmt() {
		return coverageAmt;
	}
	public void setCoverageAmt(double coverageAmt) {
		this.coverageAmt = coverageAmt;
	}
	public double getReimbursementAmt() {
		return reimbursementAmt;
	}
	public void setReimbursementAmt(double reimbursementAmt) {
		this.reimbursementAmt = reimbursementAmt;
	}
	public int getEvidenceId() {
		return evidenceId;
	}
	public void setEvidenceId(int evidenceId) {
		this.evidenceId = evidenceId;
	}	
	public String getEvidenceDirectoryLink() {
		return evidenceDirectoryLink;
	}
	public void setEvidenceDirectoryLink(String evidenceDirectoryLink) {
		this.evidenceDirectoryLink = evidenceDirectoryLink;
	}
	public int getHasApproval() {
		return hasApproval;
	}
	public void setHasApproval(int hasApproval) {
		this.hasApproval = hasApproval;
	}
	public int getHasFinalGrade() {
		return hasFinalGrade;
	}
	public void setHasFinalGrade(int hasFinalGrade) {
		this.hasFinalGrade = hasFinalGrade;
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
