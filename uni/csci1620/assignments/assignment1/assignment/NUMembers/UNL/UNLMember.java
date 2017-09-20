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

This program is intended to be a superclass for the UNLStudent, UNLFaculty,
and UNLStaff classes.

*/

package NUMembers.UNL;

import NUMembers.UniversityNebraskaMember;

public class UNLMember extends UniversityNebraskaMember {

	private String myUNLID;


	// Method Name:			UNLMember
	// Parameters:			name and myUNLID as Strings, NUID as an int
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the UNLMember class.

	public UNLMember(String name, int NUID, String myUNLID) {
		super(name, NUID, "Lincoln");
		this.setMyUNLID(myUNLID);
	}


	// Method Name:			setMyUNLID
	// Parameters:			myUNLID, a String
	// Return Values:		None
	// Partners:			None
	// Description:			This method sets the myUNLID data member.

	public void setMyUNLID(String myUNLID) {
		if (myUNLID == null) {
			this.myUNLID = "NOT SET";
		}
		else {
			this.myUNLID = myUNLID;
		}
	}


	// Method Name:			toString
	// Parameters:			None
	// Return Values		Information about the class, a String
	// Partners:			None
	// Description:			This method returns information about the class.

	@Override
	public String toString() {
		return super.toString() + String.format("MyUNLID: %s\n", this.myUNLID);
	}

}