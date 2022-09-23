package com.javabeans;

public class Employee {
private int empId;
private String empName;
private String empEmail;
//private String uniqueCode;
public Employee(int empId, String empName, String empEmail) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.empEmail = empEmail;
//	this.uniqueCode=uniqueCode;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getEmpEmail() {
	return empEmail;
}
public void setEmpEmail(String empEmail) {
	this.empEmail = empEmail;
}
//public void setUniqueCode(String uniqueCode) {
//	this.uniqueCode = uniqueCode;
//}
//public String getUniqueCode() {
//	return uniqueCode;
//}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail
			+ "]";
}

}
