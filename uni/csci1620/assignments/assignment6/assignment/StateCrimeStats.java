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

This program is the StateCrimeStats class, a class which contains some crime stats about a state.

*/

import java.io.Serializable;

public class StateCrimeStats implements Serializable {

	private String stateName;
	private int population;
	private int violentCrimes;
	private int nonVehicleTheftCrimes;
	private String highestPropertyCrimeCity;
	private double highestPropertyCrimeRate;

	// Method Name:			StateCrimeStats
	// Parameters:			state name and city name: String; population, violent crime count, theft count: int; property crime rate: double
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the StateCrimeStats class.
	public StateCrimeStats(String sta, int pop, int vio, int thef, String propCity, double propRate) {
		stateName = sta;
		population = pop;
		violentCrimes = vio;
		nonVehicleTheftCrimes = thef;
		highestPropertyCrimeCity = propCity;
		highestPropertyCrimeRate = propRate;
	}

	// Method Name:			toString
	// Parameters:			None
	// Return Values:		information about the class: String
	// Partners:			None
	// Description:			This method returns information about the class.
	@Override
	public String toString() {
		return String.format("State: %s\nPopulation: %d\nViolent Crimes: %d\nNon-Vehicle Theft Crimes: %d\nHighest Property Crime Rate: %s - %d",
							stateName, population, violentCrimes, nonVehicleTheftCrimes, highestPropertyCrimeCity, highestPropertyCrimeRate);
	}
}