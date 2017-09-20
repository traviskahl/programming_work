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

This program is intended to be a superclass for the UNOStudent, UNOFaculty,
and UNOStaff classes.

*/
package NUMembers.UNO;

import NUMembers.UniversityNebraskaMember;

public class UNOMember extends UniversityNebraskaMember {
	
	private String netID;


	// Method Name:			UNOMember
	// Parameters:			name and netID as Strings, NUID as an int
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the UNOMember class.

	public UNOMember(String name, int NUID, String netID) {
		super(name, NUID, "Omaha");
		this.setNetID(netID);
	}


	// Method Name:			setNetID
	// Parameters:			netID, a String
	// Return Values:		None
	// Partners:			None
	// Description:			This method sets the netID data member.

	public void setNetID(String netID) {
		if (netID == null) {
			this.netID = "NOT SET";
		}
		else {
			this.netID = netID;		
		}

	}


	// Method Name:			toString
	// Parameters:			None
	// Return Values		Information about the class, a String
	// Partners:			None
	// Description:			This method returns information about the class.

	@Override
	public String toString() {
		return super.toString() + String.format("NetID: %s\n", this.netID);
	}
}