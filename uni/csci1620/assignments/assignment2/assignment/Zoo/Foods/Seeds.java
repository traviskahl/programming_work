// Name:			Travis Kahl
// Class 			CSCI1620-001
// Program #:		2
// Due Date:		February 22nd
// 
// Honor Pledge:	On my honor as a student of the University 
//					of Nebraska at Omaha, I have neither given nor received
//					unauthorized help on this homework assignment.
//
// NAME:			Travis Kahl
// NUID:			*****762
// EMAIL:			traviskahl1@gmail.com
// 
// Partners:		None
//
// This program is the definition of the Seeds class,
// a class used in the Zoo program and the Animal classes.

package Zoo.Foods;

public class Seeds extends Food {

	// Method Name:			Seeds
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the Seeds class.
	public Seeds() {
		super(25, 20);
	}

	// Method Name:			toString
	// Parameters:			None
	// Return Values:		Information about the class: String
	// Partners:			None
	// Description:			This method returns information about the class.
	@Override
	public String toString() {
		return "Seeds\n" + super.toString();
	}
}