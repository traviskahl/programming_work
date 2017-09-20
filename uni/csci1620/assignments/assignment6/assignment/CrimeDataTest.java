/*
Name:			Travis Kahl
Class:			CSCI1620-001
Program #:		6
Due Date:		April 19, 2017

Honor Pledge: On my honor as a student of the University
			of Nebraska at Omaha, I have neither given nor received
			unauthorized help on this homework assignment.

NAME:			Travis Kahl
NUID:			*****762
EMAIL:			traviskahl1@gmail.com

Partners: N/A

This program is the CrimeDataTest file, the driver for the StateCrimeData class.

*/

import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ClassNotFoundException;

public class CrimeDataTest {

	// Method Name:			main
	// Parameters:			command-line arguments: String[]
	// Return Value:		None
	// Partners:			None
	// Description:			This is the main method for the CrimeDataTest class.
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter state name: ");
		String stateName = input.next();

		try {
			FileInputStream fis = new FileInputStream(stateName + ".ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			System.out.println("Loading existing data...");

			StateCrimeStats stateStats = (StateCrimeStats) ois.readObject();
			System.out.println(stateStats);
			ois.close();

		}
		catch(FileNotFoundException FNFE) {
			System.out.println("Processing new data...");
			StateCrimeData crimeData = new StateCrimeData();

			try {
				crimeData.readCrimeData(stateName);
			}
			catch(FileNotFoundException otherFNFE) {
				System.err.println("Error reading crime data");
				System.exit(0);
			}
			StateCrimeStats stateStats = crimeData.processCrimeData();

			try {
				FileOutputStream fos = new FileOutputStream(stateName + ".ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(stateStats);
				oos.close();
			}
			catch(Exception ex) {
				System.err.println("Error writing crime data");
			}

		}
		catch(IOException IOE) {
			System.err.println("THERE WAS AN IOEXCEPTION");
		}
		catch(ClassNotFoundException CNFE) {
			System.err.println("THAT CLASS WASN'T FOUND");
		}
	}
}