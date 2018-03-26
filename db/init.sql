/* Employee Table and Constraining Subtables */

--Positions description table, e.g. "Software Developer" or "Manager"
CREATE TABLE Positions (
    Id                  NUMBER(3)       PRIMARY KEY,
    Title               VARCHAR2(30)    UNIQUE NOT NULL
);
/
--Initiate Positions with default values
INSERT ALL 
    INTO positions (id, title) VALUES (1, 'Employee')
    INTO positions (id, title) VALUES (2, 'Manager')
    INTO positions (id, title) VALUES (3, 'Department Head')
SELECT * FROM dual;
/

--Departments description table, e.g. "Employee Benefits" or "Product Engineering"
CREATE TABLE Departments (
    Id                  NUMBER(3)       PRIMARY KEY,
    Title               VARCHAR2(30)    UNIQUE NOT NULL
);
/
--Initialize Departments with default values
INSERT ALL 
    INTO departments (id, title) VALUES (1, 'Application Development')
    INTO departments (id, title) VALUES (2, 'Business Analytics')
    INTO departments (id, title) VALUES (3, 'Employee Benefits')
SELECT * FROM dual;
/

--Employees table, including basic details such as First/Last Names, Email address, references for other data, etc.
CREATE TABLE Employees (
    Id                  NUMBER(3)       PRIMARY KEY,
    LastName            VARCHAR2(20)    NOT NULL,
    FirstName           VARCHAR2(20)    NOT NULL,
    Email               VARCHAR2(20)    NOT NULL,
    Password            VARCHAR2(24)	NOT NULL,
    ReportsTo           NUMBER(3),
    Position_Id         NUMBER(3),      
    Department_Id       NUMBER(3),
    Avail_Reimb 	NUMBER(5,2),
    Total_Reimb		NUMBER(5,2),
    Pndng_Reimb		NUMBER(5,2),
    Award_Reimb		NUMBER(5,2)
);
/
--Add Position, Department Ids to Employees Constraints table
ALTER TABLE Employees
	ADD CONSTRAINT fk_dep_id  FOREIGN KEY (Department_Id) REFERENCES Departments(Id);
ALTER TABLE Employees
	ADD CONSTRAINT fk_pos_id FOREIGN KEY (Position_Id) REFERENCES Positions(Id);
/

--Initialize Employees with defaul Data
INSERT ALL 
    INTO employees (id,LastName,FirstName,Email, Password,ReportsTo,Position_Id,Department_Id) VALUES (1, 'Employee')
    INTO employees (id, title) VALUES (2, 'Manager')
    INTO employees (id, title) VALUES (3, 'Department Head')
SELECT * FROM dual;
/


/* Requests Table and constraining Sub-Tables (e.g. Grades, Events) */
--Add table in which reimbursement requests are stored
CREATE TABLE Requests (
    id                  NUMBER(3)   	PRIMARY KEY,
    Requestor_Id        NUMBER(3)   	NOT NULL,
    DateSubmitted	DATE	    	NOT NULL,
    Sprvsr_Id           NUMBER(3)   	NOT NULL,
    Sprvsr_Approval     NUMBER(3)   	NOT NULL,
    Dpt_Head_Id         NUMBER(3)   	NOT NULL,
    Dpt_Head_Approval   NUMBER(3)   	NOT NULL,
    RequestStatus	NUMBER(2)   	NOT NULL,
    EventType_Id        NUMBER(3)   	NOT NULL,
    EventName           VARCHAR2(50)    NOT NULL,
    EventDateTime	TIMESTAMP       NOT NULL,
    EventCost           NUMBER(6,2)     NOT NULL,
    ReqReimb            NUMBER(6,2)     NOT NULL,
    Evidence_Id         NUMBER(3),
    Grade_Id            NUMBER(3)       NOT NULL,
    Justification	VARCHAR2(150),
    DirLink         VARCHAR2(128)   NOT NULL,
);
/

--Add table describing the type of educational event
CREATE TABLE EventTypes(
    id          NUMBER(3)       PRIMARY KEY,
    Name        VARCHAR2(50)    UNIQUE NOT NULL,
    Coverage    NUMBER(1,2)     NOT NULL
);
/
--Add table for requestor-provided Supporting Evidence
CREATE TABLE SupportingEvidence(
    id              NUMBER(3)       PRIMARY KEY,
   
    HasFinalGrade   NUMBER(1)       NOT NULL,
    Grade_Id        NUMBER(3)       NOT NULL,
    HasApproval     NUMBER(1)       NOT NULL
);
/
--Add table to store grade information for a specific request
CREATE TABLE Grades (
    id              NUMBER(3)       PRIMARY KEY,
    GradeFormat     VARCHAR2(16)    NOT NULL,
    PassingGrade    VARCHAR2(8)     NOT NULL,
    FinalGrade      VARCHAR2(8),
    PassOrFail      NUMBER(1)
);
/
