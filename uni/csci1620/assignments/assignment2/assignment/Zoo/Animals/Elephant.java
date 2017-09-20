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
// This program is the definition of the Elephant class,
// a class used in the Zoo program.

package Zoo.Animals;

import Zoo.Foods.Food;
import Zoo.Foods.Grass;
import Zoo.Foods.Fish;
import Zoo.Foods.Fruit;
import Zoo.Foods.Meat;
import Zoo.Foods.Seeds;

public class Elephant extends Animal {

	private int loneliness;

	// Method Name:			Elephant
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the Elephant class.
	public Elephant() {
		super();
		this.loneliness = 100;
	}

	// Method Name:			eat
	// Parameters:			A meal: Food
	// Return Values:		None
	// Partners:			None
	// Description:			This method changes the elephant's hunger and happiness depending on what food it was given.
	@Override
	public void eat(Food meal) {

		double hungerMod = 0.0;
		int hap = 0;

		if (meal instanceof Grass) {
			hungerMod = 1;
			hap = 0;
		}
		else if (meal instanceof Fish) {
			hungerMod = 0.4;
			hap = -10;
		}
		else if (meal instanceof Fruit) {
			hungerMod = 1;
			hap = 20;
		}
		else if (meal instanceof Meat) {
			hungerMod = 0.7;
			hap = -20;
		}
		else if (meal instanceof Seeds) {
			hungerMod = 0.5;
			hap = 0;
		}

		this.modifyHunger((int) (hungerMod * meal.getNutrition()));
		this.modifyHappiness(hap);

		this.loneliness += 10;
	}

	// Method Name:			sleep
	// Parameters:			None
	// Return Values:		The sum of hunger and happiness: int
	// Partners:			None
	// Description:			This method lowers hunger, happiness, and loneliness, and returns the sum.
	@Override
	public int sleep() {
		this.modifyHunger(-15);
		this.modifyHappiness(-10);
		this.loneliness -= 20;

		if (this.loneliness < 50)
			this.loneliness -= 20;

		return this.getHunger() + this.getHappiness();
	}

	// Method Name:			clean
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method increases the happiness and loneliness data members.
	@Override
	public void clean() {
		this.modifyHappiness(30);
		this.loneliness += 20;
	}

	// Method Name:			toString
	// Parameters:			None
	// Return Values:		Information about the class: String
	// Partners:			None
	// Description:			This method returns information about the class.
	@Override
	public String toString() {
		return "Elephant\n" + super.toString() + String.format("Loneliness: %d\n", this.loneliness);
	}

}