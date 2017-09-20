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

This program is intended to be a representation of a student at UNO.

*/

package NUMembers.UNO.UNOTypes;

import NUMembers.UNO.UNOMember;

public class UNOStudent extends UNOMember {

	private double balance;
	private int credits;
	private double GPA;

	// Method Name: 		UNOStudent
	// Parameters:			name and netID as Strings, balance and GPA as doubles, credits as an int
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the UNOStudent class.

	public UNOStudent(String name, int NUID, String netID, double balance, int credits, double GPA) {
		super(name, NUID, netID);
		this.setBalance(balance);
		this.setCredits(credits);
		this.setGPA(GPA);
	}


	// Method Name:			setBalance
	// Parameters:			balance, a double
	// Return Values:		None
	// Partners:			None
	// Description:			This method sets the balance data member.

	public void setBalance(double balance) {
		if (balance < 0.0) {
			this.balance = 0.0;
		}
		else {
			this.balance = balance;
		}
	}


	// Method Name:			setCredits
	// Parameters:			credits, an int
	// Return Values:		None
	// Partners:			None
	// Description:			This method sets the credits data member.

	public void setCredits(int credits) {
		if (credits < 0) {
			this.credits = 0;
		}
		else {
			this.credits = credits;
		}
	}


	// Method Name:			setGPA
	// Parameters:			GPA, a double
	// Return Values:		None
	// Partners:			None
	// Description:			This method sets the GPA data member.

	public void setGPA(double GPA) {
		if (GPA < 0.0 || GPA > 4.0) {
			this.GPA = 0.0;
		}
		else {
			this.GPA = GPA;
		}
	}


	// Method Name:			toString
	// Parameters:			None
	// Return Values		Information about the class, a String
	// Partners:			None
	// Description:			This method returns information about the class.

	@Override
	public String toString() {
		return super.toString() + String.format("Balance: $%.2f\nCredits: %d\nGPA: %.2f", this.balance, this.credits, this.GPA);
	}
}