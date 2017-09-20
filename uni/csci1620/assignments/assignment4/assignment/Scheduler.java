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

This program is the Scheduler class, a class that implements an ArrayList and schedules Tasks.

*/

import java.util.ArrayList;
import java.util.Collections;

public class Scheduler {

	private ArrayList<Task> inputTasks;
	private Task[] outputTasks;

	// Method Name:			Scheduler
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the Scheduler class.
	public Scheduler() {
		this.inputTasks = new ArrayList<Task>();
	}

	// Method Name:			addTask
	// Parameters:			a Task: t
	// Return Values:		None
	// Partners:			None
	// Description:			This method adds a Task to the ArrayList.
	public void addTask(Task t) {
		this.inputTasks.add(t);
	}

	// Method Name:			scheduleTasks
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method schedules Tasks by populating the outputTasks array.
	public void scheduleTasks() {
		if (!(inputTasks.isEmpty())) {
			outputTasks = new Task[inputTasks.get(0).getMaxDeadline()];

			Collections.sort(inputTasks);
			Collections.reverse(inputTasks);

			for (int task = 0; task < outputTasks.length; task++) {
				Task currentTask = inputTasks.get(task);
				int currentMaxPlacement = currentTask.getDeadline();

				for (int placement = currentMaxPlacement - 1; placement >= 0; placement--) {
					if (outputTasks[placement] == null) {
						outputTasks[placement] = currentTask;
						break;
					}
				}
			}
		}
		else {
			outputTasks = new Task[0];
		}	
	}

	// Method Name:			calculateValue
	// Parameters:			None
	// Return Values:		the sum of all values: int
	// Partners:			None
	// Description:			This method sums up the values of scheduled tasks and returns the sum.
	public int calculateValue() {
		int sum = 0;
		for (Task x : outputTasks) {
			sum += x.getValue();
		}

		return sum;
	}

	// Method Name:			printInputTasks
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method prints the Tasks with the highest and lowest values, and prints all Tasks given.
	public void printInputTasks() {
		if (!(inputTasks.isEmpty())) {
			System.out.print("Task with max value: ");
			System.out.println(Collections.max(inputTasks));
			System.out.print("Task with min value: ");
			System.out.println(Collections.min(inputTasks));

			for (int x = 0; x < inputTasks.size(); x++) {
				System.out.println(inputTasks.get(x));
		}
	}

	// Method Name:			printOutputTasks
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method prints all scheduled Tasks in the outputTasks array.
	public void printOutputTasks() {
		if (outputTasks.length == 0) {
			System.out.println("No tasks given.");
		}
		else {
			System.out.println("Scheduled Tasks: ");
			for (Task x : outputTasks) {
				if (x == null)
					continue;
				else
					System.out.println(x);
			}			
		}

	}

}