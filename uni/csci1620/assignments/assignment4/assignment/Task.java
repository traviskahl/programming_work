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

This program is the definition of the Task class.

*/

public class Task implements Comparable<Task> {

	private static int maxDeadline;
	private int value;
	private int deadline;

	// Method Name:			Task
	// Parameters:			a deadline and a value: ints
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the Task class.
	public Task(int deadline, int value) {

		setDeadline(deadline);
		setValue(value);

		if (maxDeadline < this.deadline) {
			maxDeadline = this.deadline;
		}
	}

	// Method Name:			getDeadline
	// Parameters:			None
	// Return Values:		The deadline data member: int
	// Partners:			None
	// Description:			This method returns the deadline data member.
	public int getDeadline() {
		return this.deadline;
	}

	// Method Name:			setDeadline
	// Parameters:			a deadline: int
	// Return Values:		None
	// Partners:			None
	// Description:			This method sets the deadline data member.
	public void setDeadline(int deadline) {
		if (deadline < 0)
			throw new InvalidDeadlineException(deadline);

		if (deadline > this.deadline) 
			this.deadline = deadline;
	}

	// Method Name:			getValue
	// Parameters:			None
	// Return Values:		The value data member: int
	// Partners:			None
	// Description:			This method returns the value data member.
	public int getValue() {
		return this.value;
	}

	// Method Name:			setValue
	// Parameters:			a value: int
	// Return Values:		None
	// Partners:			None
	// Description:			This method sets the value data member.
	public void setValue(int value) {
		if (value < 0)
			throw new InvalidValueException(value);

		this.value = value;
	}

	// Method Name:			getMaxDeadline
	// Parameters:			None
	// Return Values:		the maxDeadline data member: int
	// Partners:			None
	// Description:			This method returns the maxDeadline data member.
	public int getMaxDeadline() {
		return this.maxDeadline;
	}

	// Method Name:			compareTo
	// Parameters:			a Task: t
	// Return Values:		the relationship between another Task and the current one: int
	// Partners:			None
	// Description:			This method can be used to compare two Tasks.
	@Override
	public int compareTo(Task t) {
		int ret;

		if (this.getValue() < t.getValue())
			ret = -1;
		else if (t.getValue() == this.getValue())
			ret = 0;
		else
			ret = 1;

		return ret;
	}

	// Method Name:			toString
	// Parameters:			None
	// Return Values:		Information about the class: String
	// Partners:			None
	// Description:			This method returns information about the class.
	@Override
	public String toString() {
		return String.format("Deadline: %d Value: %d", this.deadline, this.value);
	}
}