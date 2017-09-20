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

This program is the definition of the InvalidDeadlineException, an exception that can be
thrown in the assignment.

*/

public class InvalidDeadlineException extends RuntimeException {

	// Method Name:			InvalidDeadlineException
	// Parameters:			an invalid deadline: int
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the InvalidDeadlineException class.
	public InvalidDeadlineException(int deadline) {
		super(String.format("Non-positive number given for deadline: %d", deadline));
	}
}