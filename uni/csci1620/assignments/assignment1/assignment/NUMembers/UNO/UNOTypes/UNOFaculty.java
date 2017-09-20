/*
Name:			Travis Kahl
Class:			CSCI1620-001
Program #:		1
Due Date:		February 8th, 2017

Honor Pledge: On my honor as a student of the University
			of Nebraska at Omaha, I have neither given nor received
			unauthorized help on this homework assignment.

NAME:			Travis Kahl
NUID:			*****762
EMAIL:			traviskahl1@gmail.com

Partners: N/A

This program is intended to be a representation of a faculty member at UNO.

*/

package NUMembers.UNO.UNOTypes;

import NUMembers.UNO.UNOMember;

public class UNOFaculty extends UNOMember {

	private String department;
	private String title;
	private double salary;


	// Method Name:			UNOFaculty
	// Parameters:			name, netID, department, and title as Strings, NUID as an int, salary as a double
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the UNOFaculty class.

	public UNOFaculty(String name, int NUID, String netID, String department, String title, double salary) {
		super(name, NUID, netID);
		this.setDepartment(department);
		this.setTitle(title);
		this.setSalary(salary);
	}


	// Method Name:			setDepartment
	// Parameters:			department, a String
	// Return Values:		None
	// Partners:			None
	// Description:			This method sets the department data member

	public void setDepartment(String department) {
		if (department == null) {
			this.department = "NOT SET";
		}
		else {
			this.department = department;
		}
	}


	// Method Name:			setTitle
	// Parameters:			title, a String
	// Return Values:		None
	// Partners:			None
	// Description:			This method sets the title data member.

	public void setTitle(String title) {
		if (title == null) {
			this.title = "NOT SET";
		}
		else {
			this.title = title;
		}
	}


	// Method Name:			setSalary
	// Parameters:			salary, a double
	// Return Values:		None
	// Partners:			None
	// Description:			This method sets the salary data member.

	public void setSalary(double salary) {
		if (salary < 23660) {
			this.salary = -1;
		}
		else {
			this.salary = salary;
		}
	}


	// Method Name:			toString
	// Parameters:			None
	// Return Values		Information about the class, a String
	// Partners:			None
	// Description:			This method returns information about the class.

	@Override
	public String toString() {
		if (this.salary == -1) {
			return super.toString() + String.format("Department: %s\nTitle: %s\nSalary: NOT SET", this.department, this.title);
		}
		else {
			return super.toString() + String.format("Department: %s\nTitle: %s\nSalary: $%.2f", this.department, this.title, this.salary);			
		}

	}

}