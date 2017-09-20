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

This program is intended to be a superclass for the UNOMember and
UNLMember classes.

*/
package NUMembers;

public class UniversityNebraskaMember {
	private String name;
	private int NUID;
	private String city;


	// Method Name:			UniversityNebraskaMember
	// Parameters:			name and city as Strings, NUID as an int
	// Return Values:		None
	// Partners:			None
	// Description:			This mehtod is the constructor for the UniversityNebraskaMember class.

	public UniversityNebraskaMember(String name, int NUID, String city) {
		setName(name);
		setNUID(NUID);
		setCity(city);
	}


	// Method Name:			setName
	// Parameters:			name, a String
	// Return Values:		None
	// Partners:			None
	// Description:			This method sets the name data member.

	public void setName(String name) {
		this.name = name;
	}


	// Method Name:			setNUID
	// Parameters:			NUID, an int
	// Return Values:		None
	// Partners:			None
	// Description:			This method sets the NUID data member.

	public void setNUID(int NUID) {
		if (String.valueOf(NUID).length() != 8) {
			this.NUID = -1;
		}
		else {
			this.NUID = NUID;
		}
	}


	// Method Name:			setCity
	// Parameters:			city, a String
	// Return Values:		None
	// Partners:			None
	// Description:			This method sets the city data member.

	public void setCity(String city) {
		this.city = city;
	}


	// Method Name:			toString
	// Parameters:			None
	// Return Values		Information about the class, a String
	// Partners:			None
	// Description:			This method returns information about the class.

	@Override
	public String toString() {
		if (this.NUID == -1) {
			return String.format("Name: %s\nNUID: NOT SET\nCampus Location: %s\n", this.name, this.city);
		}
		else {
			return String.format("Name: %s\nNUID: %d\nCampus Location: %s\n", this.name, this.NUID, this.city);		
		}
		
	}

}