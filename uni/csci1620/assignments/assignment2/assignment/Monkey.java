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
// This program is the definition of the Monkey class,
// a part of the Assignment 2 Questions.

import Zoo.Foods.*;

public class Monkey extends Animal {

	// Method Name:			Monkey
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the Monkey class.
	public Monkey() {
		super();
	}

	// Method Name:			eat
	// Parameters:			A meal: Food
	// Return Values:		None
	// Partners:			None
	// Description:			This method changes the hunger and happiness data members based on which food the monkey was given.
	@Override
	public void eat(Food meal) {

		double hungerMod = 0.0;
		int hap = 0;

		if (meal instanceof Grass) {
			hungerMod = 0.5;
			hap = 0;
		}
		else if (meal instanceof Fish) {
			hungerMod = 0.8;
			hap = 10;
		}
		else if (meal instanceof Fruit) {
			hungerMod = 1;
			hap = 20;
		}
		else if (meal instanceof Meat) {
			hungerMod = 0.65;
			hap = -10;
		}
		else if (meal instanceof Seeds) {
			hungerMod = 0.5;
			hap = -10;
		}

		this.modifyHunger((int) (hungerMod * meal.getNutrition()));
		this.modifyHappiness(hap);
	}

	// Method Name:			sleep
	// Parameters:			None
	// Return Values:		The sum of hunger and happiness: int
	// Partners:			None
	// Description:			This lowers the hunger and happiness data members and returns their sums
	@Override
	public int sleep() {
		this.modifyHunger(-10);
		this.modifyHappiness(-20);

		return this.getHunger() + this.getHappiness();
	}

	// Method Name:			clean
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method increases the monkeys' happiness.
	@Override
	public void clean() {
		this.modifyHappiness(20);
	}

	// Method Name:			fling
	// Parameters:			The target: Animal
	// Return Values:		None
	// Partners:			None
	// Description:			This lowers the targets' happiness.
	public void fling(Animal target) {
		target.modifyHappiness(-30);
	}

	// Method Name:			toString
	// Parameters:			None
	// Return Values:		Information about the class: String
	// Partners:			None
	// Description:			This method returns information about the class.
	@Override
	public String toString() {
		return "Monkey\n" + super.toString();
	}

}