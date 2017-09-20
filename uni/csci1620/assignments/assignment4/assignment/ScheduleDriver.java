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

This program is the driver for the Schedule class.

*/

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Collections;

public class ScheduleDriver {

	// Method Name:			main
	// Parameters:			Commandline arguments: String[]
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the main method for the ScheduleDriver program.
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Scheduler schedule = new Scheduler();
		StringTokenizer st;

		System.out.println("Input Tasks: DEADLINE VALUE");
		System.out.println("Type DONE to schedule");

		String taken = new String();

		while (true) {

			try {
				taken = input.nextLine();

				if (taken.equals("DONE"))
					break;

				st = new StringTokenizer(taken);
				schedule.addTask(new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));	
			}
			catch (NumberFormatException NFE) {
				System.out.println("Invalid Task");
			}
			catch (java.util.NoSuchElementException NSEE) {
				System.out.println("Invalid Task");
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		schedule.printInputTasks();
		schedule.scheduleTasks();
		schedule.printOutputTasks();
		System.out.printf("Maximum Value of Tasks is %d\n", schedule.calculateValue());

	}

}