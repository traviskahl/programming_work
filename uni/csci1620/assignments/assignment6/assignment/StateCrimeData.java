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

This program is the StateCrimeData class definition, which reads crime data from a given
.csv file and creates a StateCrimeStats file.

*/

import java.io.FileNotFoundException;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StateCrimeData {

	private String stateName;
	private ArrayList<CityCrimeData> crimeByCity;

	// Method Name: 		StateCrimeData
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the StateCrimeData class.
	public StateCrimeData() {
		crimeByCity = new ArrayList<CityCrimeData>();
	}

	// Method Name:			readCrimeData
	// Parameters:			a file to read from: String
	// Return Values:		None
	// Partners:			None
	// Description:			This method reads in crime data from a .csv file and stores it in an ArrayList.
	public void readCrimeData(String crimeFile) throws FileNotFoundException {
		try {
			File stateFile = new File(crimeFile + ".csv");
			if (!(stateFile.exists())) {
				throw new FileNotFoundException();
			}

			Scanner fileInput = new Scanner(stateFile);
			stateName = fileInput.nextLine();

			while (fileInput.hasNextLine()) {
				StringTokenizer st = new StringTokenizer(fileInput.nextLine(), ",");

				String name = st.nextElement();
				System.out.println("name is " + name);
				int pop = Integer.parseInt(st.nextToken());
				int vio = Integer.parseInt(st.nextToken());
				int mur = Integer.parseInt(st.nextToken());
				int rob = Integer.parseInt(st.nextToken());
				int aslt = Integer.parseInt(st.nextToken());
				int pro = Integer.parseInt(st.nextToken());
				int bur = Integer.parseInt(st.nextToken());
				int lar = Integer.parseInt(st.nextToken());
				int veh = Integer.parseInt(st.nextToken());
				int ars = Integer.parseInt(st.nextToken());

				CityCrimeData current = new CityCrimeData(name, pop, vio, mur, rob, aslt, pro, bur, lar, veh, ars);
				crimeByCity.add(current);
			}
		}
		catch(IOException IOE) {
			IOE.printStackTrace();
		}
	}

	// Method Name:			processCrimeData
	// Parameters:			None
	// Return Values:		a report of crime statistics in the state: StateCrimeStats
	// Partners:			None
	// Description:			This method makes a report of state crime stats and returns it.
	public StateCrimeStats processCrimeData() {
		String stateName = crimeByCity.get(0).cityName;
		int totalPop = 0;
		int totalVio = 0;
		int totalThef = 0;
		String maxPropCity = null;
		double maxPropRate = 0.0;

		for (int x = 0; x < crimeByCity.size(); x++) {
			CityCrimeData city = crimeByCity.get(x);

			totalPop += city.population;
			totalVio += city.violentCrimeCount;
			totalThef += city.burglaryCount + city.robberyCount + city.larcenyCount;

			double currentPropRate = calculateCrimeRate(city.propertyCount, city.population);
			if (currentPropRate > maxPropRate) {
				maxPropCity = city.cityName;
				maxPropRate = currentPropRate;
			}

		}

		StateCrimeStats state = new StateCrimeStats(stateName, totalPop, totalVio, totalThef, maxPropCity, maxPropRate);
		return state;
	}

	// Method Name:			calculateCrimeRate
	// Parameters:			property crime count and population: int
	// Return Values:		crime rate: double
	// Partners:			None
	// Description:			This method calculates and returns crime rate.
	private double calculateCrimeRate(int propertyCount, int population) {
		return (propertyCount / population) * 100000;
	}

}
