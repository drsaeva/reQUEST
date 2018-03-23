
class Request {
  constructor(empLastName, empFirstName, submitDate, eventName, eventType,
              eventStartDate, eventEndDate, eventCost, reqReimb, gradeFormat,
              passingGrade, finalGrade, passOrFail, evidenceFolder,
              justification, urgent, providedApproval, requestStatus) {

    this.empLastName = empLastName;
    this.empFirstName = empFirstName;
    this.submitDate = submitDate;
    this.eventName = eventName;
    this.eventType = eventType;
    this.eventStartDate = eventStartDate;
    this.eventEndDate = eventEndDate;
    this.eventCost = eventCost;
    this.reqReimb = reqReimb;
    this.gradeFormat = gradeFormat;
    this.passingGrade = passingGrade;
    this.finalGrade = finalGrade;
    this.passOrFail = passOrFail;
    this.evidenceFolder = evidenceFolder;     //TODO refactor with dropbox API integration
    this.justification = justification;
    this.urgent = urgent;
    this.providedApproval = providedApproval;
    this.requestStatus = requestStatus;
  }
}

var sampleRequest = new Request("Doe", "John", "27-FEB-2018",
                                "Oracle Certified Associate Examination", 3,
                                "31-MAR-2018", "31-MAR-2018", 245.00, 245.00,
                                "0-100", "65", null, null, "https://www.example.com",
                                "App Dev team uses Java, supervisor wants me certified",
                                null, "Supervisor", "Partial Approval");

window.onload = function(){
  document.getElementById("headerContent").innerHTML = "<table><tr><td>"+
      sampleRequest.empLastName+", "+sampleRequest.empFirstName+"</td>"+
      "<td>"+sampleRequest.submitDate+"</td></tr></table>"
};
