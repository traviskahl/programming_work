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
// This program is the definition of the abstract class Food,
// a superclass for the other types of foods found in the program.

package Zoo.Foods;

public abstract class Food {

	private int exhaustionCost;
	private int nutrition;
	private int amount;

	// Method Name:			Food
	// Parameters:			exC and nut: ints
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the Food class.
	public Food(int exC, int nut) {
		this.exhaustionCost = exC;
		this.nutrition = nut;
		this.amount = 1;
	}

	// Method Name:			getExhaustionCost
	// Parameters:			None
	// Return Values:		The exhaustion cost: int
	// Partners:			None
	// Description:			This method returns the exhaustion cost.
	public int getExhaustionCost() {
		return this.exhaustionCost;
	}

	// Method Name:			getNutrition
	// Parameters:			None
	// Return Values:		The nutrition: int
	// Partners:			None
	// Description:			This method returns the nutrition.
	public int getNutrition() {
		return this.nutrition;
	}

	// Method Name:			getAmount
	// Parameters:			None
	// Return Values:		The amount of food available: int
	// Partners:			None
	// Description:			This method returns the amount of food available.
	public int getAmount() {
		return this.amount;
	}

	// Method Name:			receiveDelivery
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method increases the amount of food by one.
	public void receiveDelivery() {
		this.amount += 1;
	}

	// Method Name:			consume
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method decreases the amount of food by one.
	public void consume() {
		this.amount -= 1;
	}

	// Method Name:			toString
	// Parameters:			None
	// Return Values:		Information about the food: String
	// Partners:			None
	// Description:			This method returns the exhaustion cost, nutrition value, and amount available of the food.
	@Override
	public String toString() {
		return String.format("Exhaustion: %d\nNutrition: %d\nAmount: %d\n", this.exhaustionCost, this.nutrition, this.amount);
	}

}