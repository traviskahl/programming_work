/*
Name:			Travis Kahl
Class:			CSCI1620-001
Program #:		4
Due Date:		March 29th, 2017

Honor Pledge: On my honor as a student of the University
			of Nebraska at Omaha, I have neither given nor received
			unauthorized help on this homework assignment.

NAME:			Travis Kahl
NUID:			*****762
EMAIL:			traviskahl1@gmail.com

Partners: N/A

This program is the definition of the InvalidValueException, an exception that can be
thrown in the assignment.

*/

public class InvalidValueException extends RuntimeException {
	
	// Method Name:			InvalidValueException
	// Parameters:			an invalid value: int
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the InvalidValueException class.
	public InvalidValueException(int value) {
		super(String.format("Non-positive number given for value: %d", value));
	}
}