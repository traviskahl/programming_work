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
// This program is the definition of the Lion class,
// a class used in the Zoo program.

package Zoo.Animals;

import Zoo.Foods.Food;
import Zoo.Foods.Grass;
import Zoo.Foods.Fish;
import Zoo.Foods.Fruit;
import Zoo.Foods.Meat;
import Zoo.Foods.Seeds;

import java.util.Random;

public class Lion extends Animal {

	private boolean hasBall;

	// Method Name:			Lion
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the Lion class.
	public Lion() {
		super();
		this.hasBall = true;
	}

	// Method Name:			eat
	// Parameters:			A meal: Food
	// Return Values:		None
	// Partners:			None
	// Description:			This method changes the lion's hunger and happiness based on what food it was given.
	@Override
	public void eat(Food meal) {

		double hungerMod = 0.0;
		int hap = 0;

		if (meal instanceof Grass) {
			hungerMod = 0.5;
			hap = -10;
		}
		else if (meal instanceof Fish) {
			hungerMod = 0.7;
			hap = 10;
		}
		else if (meal instanceof Fruit) {
			hungerMod = 1;
			hap = 20;
		}
		else if (meal instanceof Meat) {
			hungerMod = 1;
			hap = 20;
		}
		else if (meal instanceof Seeds) {
			hungerMod = 0.15;
			hap = -10;
		}

		this.modifyHunger((int) (hungerMod * meal.getNutrition()));
		this.modifyHappiness(hap);
	}

	// Method Name:			sleep
	// Parameters:			None
	// Return Values:		The sum of happiness and hunger: int
	// Partners:			None
	// Description			This method lowers the hunger and happiness data members,
	// 						as well as randomly breaking the lion's ball.
	@Override
	public int sleep() {
		this.modifyHunger(-20);
		this.modifyHappiness(-10);

		Random rand = new Random();
		int chance = rand.nextInt(10);

		if (chance <= 2) {
			this.hasBall = false;
			this.modifyHappiness(-20);
		}

		return this.getHappiness() + this.getHunger();
	}

	// Method Name:			clean
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method increases the lion's happiness.
	@Override
	public void clean() {
		this.modifyHappiness(20);
	}

	// Method Name:			toString
	// Parameters:			None
	// Return Values:		Information about the class: String
	// Partners:			None
	// Description:			This method returns information about the class.
	@Override
	public String toString() {
		String echoBall = "Has Ball\n";
		if (this.hasBall == false)
			echoBall = "Broke Ball\n";

		return "Lion\n" + super.toString() + echoBall;
	}

	// Method Name:			giveBall
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method sets the hasBall data member to true.
	public void giveBall() {
		this.hasBall = true;
	}

}