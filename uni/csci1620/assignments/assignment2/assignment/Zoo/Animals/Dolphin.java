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
// This program is the definition of the Dolphin class,
// a class used in the Zoo program.

package Zoo.Animals;

import Zoo.Foods.Food;
import Zoo.Foods.Grass;
import Zoo.Foods.Fish;
import Zoo.Foods.Fruit;
import Zoo.Foods.Meat;
import Zoo.Foods.Seeds;

public class Dolphin extends Animal {

	// Method Name:			Dolphin
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the Dolphin class.
	public Dolphin() {
		super();
	}

	// Method Name:			eat
	// Parameters:			A meal: Food
	// Return Values:		None
	// Partners:			None
	// Description:			This method changes the dolphin's happiness and hunger based on
	// 						what kind of food it was given.
	@Override
	public void eat(Food meal) {

		double hungerMod = 0.0;
		int hap = 0;

		if (meal instanceof Grass) {
			hungerMod = 0.4;
			hap = -10;
		}
		else if (meal instanceof Fish) {
			hungerMod = 1;
			hap = 10;
		}
		else if (meal instanceof Fruit) {
			hungerMod = 1;
			hap = 20;
		}
		else if (meal instanceof Meat) {
			hungerMod = 0.8;
			hap = 0;
		}
		else if (meal instanceof Seeds) {
			hungerMod = 0.2;
			hap = -30;
		}

		this.modifyHunger((int) (hungerMod * meal.getNutrition()));
		this.modifyHappiness(hap);
	}

	// Method Name:			sleep
	// Parameters:			None
	// Return Values:		The sum of hunger and happiness: int
	// Partners:			None
	// Description:			This method lowers the dolphin's hunger and happiness, then returns their sum.
	@Override
	public int sleep() {
		this.modifyHunger(-10);
		this.modifyHappiness(-30);
		return this.getHunger() + this.getHappiness();
	}

	// Method Name:			clean
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method increases the dolphin's happiness.
	@Override
	public void clean() {
		this.modifyHappiness(10);
	}

	// Method Name:			swim
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method increases the dolphin's happiness by 30.
	public void swim() {
		this.modifyHappiness(30);
	}

	// Method Name:			toString
	// Parameters:			None
	// Return Values:		Information about the class: String
	// Partners:			None
	// Description:			This method returns information about the class.
	@Override
	public String toString() {
		return "Dolphin\n" + super.toString();
	}

}