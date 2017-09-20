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
// This program is the definition of the Fish class,
// a class used in the Zoo program and the Animal classes.

package Zoo.Foods;

public class Fish extends Food {

	// Method Name:			Fish
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the Fish class.
	public Fish() {
		super(40, 25);
	}

	// Method Name:			toString
	// Parameters:			None
	// Return Values:		Information about the class: String
	// Partners:			None
	// Description:			This method returns information about the class.
	@Override
	public String toString() {
		return "Fish\n" + super.toString();
	}
}