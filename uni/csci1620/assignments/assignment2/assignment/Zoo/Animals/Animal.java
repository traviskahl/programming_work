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
// This program is the definition of the abstract class Animal,
// a superclass for the other types of animals found in the program.

package Zoo.Animals;

import Zoo.Foods.Food;

public abstract class Animal {

	private int hunger;
	private int happiness;

	// Method Name:			Animal
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the Animal class.
	public Animal() {
		this.hunger = 100;
		this.happiness = 100;
	}

	// Method Name:			getHunger
	// Parameters:			None
	// Return Values:		The hunger data member: int
	// Partners:			None
	// Description:			This method returns the hunger data member.
	public int getHunger() {
		return this.hunger;
	}

	// Method Name:			getHappiness
	// Parameters:			None
	// Return Values:		The happiness data member: int
	// Partners:			None
	// Description:			This method returns the happiness data member.	
	public int getHappiness() {
		return this.happiness;
	}

	// Method Name:			modifyHunger
	// Parameters:			The amount to modify hunger by: int
	// Return Values:		None
	// Partners:			None
	// Description:			This method modifies the hunger data member.
	// 						Passing negative numbers decreases it.
	public void modifyHunger(int hun) {
		if (this.hunger + hun < 0)
			this.hunger = 0;
		else if (this.hunger + hun > 100)
			this.hunger = 100;
		else
			this.hunger += hun;
	}

	// Method Name:			modifyHappiness
	// Parameters:			The amount to modify happiness by: int
	// Return Values:		None
	// Partners:			None
	// Description:			This method modifies the happiness data member.
	//						Passing negative numbers decreases it.
	public void modifyHappiness(int hap) {
		if (this.happiness + hap < 0)
			this.happiness = 0;
		else if (this.happiness + hap > 100)
			this.happiness = 100;
		else
			this.happiness += hap;
	}

	// Method Name:			eat
	// Parameters:			A meal: Food
	// Return Values:		None
	// Partners:			None
	// Description:			This is an abstract method that must be overridden.
	public abstract void eat(Food meal);

	// Method Name:			sleep
	// Parameters:			None
	// Return Values:		An int
	// Partners:			None
	// Description:			This is an abstract method that must be overridden.
	public abstract int sleep();

	// Method Name:			Clean
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This is an abstract method that must be overridden.
	public abstract void clean();

	// Method Name:			toString
	// Parameters:			None
	// Return Values:		Information about the class: String
	// Partners:			None
	// Description:			This method returns information about the class.
	@Override
	public String toString() {
		return String.format("Hunger: %d\nHappiness: %d\n", this.hunger, this.happiness);
	}
}