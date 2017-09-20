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
// This program is the definition of the Ostrich class,
// a class used in the Zoo program.

package Zoo.Animals;

import Zoo.Foods.Food;
import Zoo.Foods.Grass;
import Zoo.Foods.Fish;
import Zoo.Foods.Fruit;
import Zoo.Foods.Meat;
import Zoo.Foods.Seeds;

import java.util.Random;

public class Ostrich extends Animal {

	private int eggs;

	// Method Name:			Ostrich
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the Ostrich class.
	public Ostrich() {
		super();
		this.eggs = 0;
	}

	// Method Name:			eat
	// Parameters:			A meal: Food
	// Return Values:		None
	// Partners:			None
	// Description:			This method changes the hunger and happiness based on what kind of food the ostrich was fed.
	@Override
	public void eat(Food meal) {

		double hungerMod = 0.0;
		int hap = 0;

		if (meal instanceof Grass) {
			hungerMod = 0.65;
			hap = 0;
		}
		else if (meal instanceof Fish) {
			hungerMod = 0.8;
			hap = 20;
		}
		else if (meal instanceof Fruit) {
			hungerMod = 1;
			hap = 20;
		}
		else if (meal instanceof Meat) {
			hungerMod = 0.3;
			hap = -15;
		}
		else if (meal instanceof Seeds) {
			hungerMod = 1;
			hap = 10;
		}

		this.modifyHunger((int) (hungerMod * meal.getNutrition()));
		this.modifyHappiness(hap);
	}

	// Method Name:			sleep
	// Parameters:			None
	// Return Values:		The sum of hunger and happiness: int
	// Partners:			None
	// Description:			This method lowers the hunger and happiness and randomly gives the ostrich an egg.
	//						It further lowers the happiness if there are more than 3 eggs. It returns the sum of hunger and happiness.
	@Override
	public int sleep() {
		this.modifyHunger(-10);
		this.modifyHappiness(-20);

		Random rand = new Random();
		int chance = rand.nextInt(2);
		if (chance == 0)
			this.eggs += 1;

		if (this.eggs >= 3)
			this.modifyHappiness(-30);

		return this.getHappiness() + this.getHunger();
	}

	// Method Name:			clean
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method increases happiness and removes any eggs.
	@Override
	public void clean() {
		this.modifyHappiness(20);
		this.eggs = 0;
	}

	// Method Name:			toString
	// Parameters:			None
	// Return Values:		Information about the ostrich: String
	// Partners:			None
	// Description:			This method returns information about the class.
	@Override
	public String toString() {
		return "Ostrich\n" + super.toString() + String.format("Eggs: %d\n", this.eggs);
	}

}