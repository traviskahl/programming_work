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

This program is intended to be a representation of a staff member at UNO.

*/

package NUMembers.UNO.UNOTypes;

import NUMembers.UNO.UNOMember;

public class UNOStaff extends UNOMember {

	private String position;
	private double wage;


	// Method Name:			UNOStaff
	// Parameters:			name, netID, and position as Strings, NUID as an int, wage as a double
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the UNOStaff class.

	public UNOStaff(String name, int NUID, String netID, String position, double wage) {
		super(name, NUID, netID);
		this.setPosition(position);
		this.setWage(wage);
	}


	// Method Name:			setPosition
	// Parameters:			position, a String
	// Return Values:		None
	// Partners:			None
	// Description:			This method sets the position data member.

	public void setPosition(String position) {
		if (position == null) {
			this.position = "NOT SET";
		}
		else {
			this.position = position;
		}
	}


	// Method Name:			setWage
	// Parameters:			wage, a double
	// Return Values:		None
	// Partners:			None
	// Description:			This method sets the wage data member.

	public void setWage(double wage) {
		if (wage < 9.0) {
			this.wage = -1;
		}
		else {
			this.wage = wage;
		}
	}


	// Method Name:			toString
	// Parameters:			None
	// Return Values		Information about the class, a String
	// Partners:			None
	// Description:			This method returns information about the class.

	@Override
	public String toString() {
		if (this.wage == -1) {
			return super.toString() + String.format("Position: %s\nWage: NOT SET", this.position);
		}
		else {
			return super.toString() + String.format("Position: %s\nWage: $%.2f", this.position, this.wage);
		}
	}
}