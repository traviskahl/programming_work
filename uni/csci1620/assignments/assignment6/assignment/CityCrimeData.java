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

This program is the CityCrimeData class, a class that holds some crime stats for a given city.

*/

public class CityCrimeData {

	public String cityName;
	public int population;
	public int violentCrimeCount;
	public int murderCount;
	public int robberyCount;
	public int assaultCount;
	public int propertyCount;
	public int burglaryCount;
	public int larcenyCount;
	public int vehicleTheftCount;
	public int arsonCount;

	// Method Name:			CityCrimeData
	// Parameters:			a name: String; population, violent crime count, murder count, robbery count, assault count, property damage count, larceny count, vehicle theft count, arson count: int
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the CityCrimeData class.
	public CityCrimeData(String name, int pop, int vio, int mur, int rob, int aslt, int pro, int bur, int lar, int veh, int ars) {
		cityName = name;
		population = pop;
		violentCrimeCount = vio;
		murderCount = mur;
		robberyCount = rob;
		assaultCount = aslt;
		propertyCount = pro;
		burglaryCount = bur;
		larcenyCount = lar;
		vehicleTheftCount = veh;
		arsonCount = ars;
	}
}