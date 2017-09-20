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
// This program is the definition of the Zoo class,
// a class used in the ZooDriver program. It uses all of the
// Animal classes and Food classes to simulate a zoo.

import Zoo.Foods.*;
import Zoo.Animals.*;

import java.util.Random;

public class Zoo {

	private Animal[] cages;
	private Food[] foodCrates;

	private int keeperEnergy;
	private int score;

	public final int ELEPHANTLOCATION	= 0;
	public final int DOLPHINLOCATION	= 1;
	public final int OSTRICHLOCATION	= 2;
	public final int LIONLOCATION		= 3;

	public final int SEEDSCRATE	= 0;
	public final int MEATCRATE	= 1;
	public final int GRASSCRATE = 2;
	public final int FISHCRATE	= 3;
	public final int FRUITCRATE = 4;

	// Method Name:			Zoo
	// Parameters:			None
	// Return Values:		None
	// Partners:			None
	// Description:			This method is the constructor for the Zoo class.
	public Zoo() {
		cages = new Animal[4];
		cages[ELEPHANTLOCATION]	= new Elephant();
		cages[DOLPHINLOCATION]	= new Dolphin();
		cages[OSTRICHLOCATION]	= new Ostrich();
		cages[LIONLOCATION]		= new Lion();

		foodCrates = new Food[5];
		foodCrates[SEEDSCRATE]	 = new Seeds();
		foodCrates[MEATCRATE]	 = new Meat();
		foodCrates[GRASSCRATE]	 = new Grass();
		foodCrates[FISHCRATE]	 = new Fish();
		foodCrates[FRUITCRATE]	 = new Fruit();

		keeperEnergy = 100;
		score = 0;
	}

	// Method Name:			feedAnimal
	// Parameters:			cage and crate: ints
	// Return Values:		Whether the action was performed or not: boolean
	// Partners:			None
	// Description:			This method attempts to feed the target animal.
	public boolean feedAnimal(int cage, int crate) {
		if (keeperEnergy < foodCrates[crate].getExhaustionCost() || foodCrates[crate].getAmount() == 0) {
			return false;
		}
		else {
			cages[cage].eat(foodCrates[crate]);
			keeperEnergy -= foodCrates[crate].getExhaustionCost();
			foodCrates[crate].consume();
			return true;
		}
	}

	// Method Name:			cleanCage
	// Parameters:			cage: int
	// Return Values:		Whether the action was performed or not: boolean
	// Partners:			None
	// Description:			This method attempts to clean the target cage.
	public boolean cleanCage(int cage) {
		if (keeperEnergy < 30) {
			return false;
		}
		else {
			cages[cage].clean();
			keeperEnergy -= 30;
			return true;
		}
	}

	// Method Name:			swimWithDolphin
	// Parameters:			None
	// Return Values:		Whether the action was performed or not: boolean
	// Partners:			None
	// Description:			This method attempts to swim with the dolphin.
	public boolean swimWithDolphin() {
		if (keeperEnergy < 40) {
			return false;
		}
		else {
			((Dolphin) (cages[DOLPHINLOCATION])).swim();
			keeperEnergy -= 40;
			return true;
		}
	}

	// Method Name:			giveLionBall
	// Parameters:			None
	// Return Values:		Whether the lion was given the ball or not: boolean
	// Partners:			None
	// Description:			This method attempts to give the lion its ball.
	public boolean giveLionBall() {
		if (keeperEnergy < 20) {
			return false;
		}
		else {
			((Lion) (cages[LIONLOCATION])).giveBall();
			keeperEnergy -= 20;
			return true;
		}
	}

	// Method Name:			endDay
	// Parameters:			None
	// Return Values:		The current score for the day: int
	// Partners:			None
	// Description:			This method puts the animals to sleep, gives the 
	// keeper more food randomly, resets the energy, and updates the score.
	public int endDay() {
		int currentScore = 0;
		for (int count = 0; count < cages.length; count++)
			currentScore += cages[count].sleep();

		Random rand = new Random();
		int whichFood = rand.nextInt(5);
		foodCrates[whichFood].receiveDelivery();

		keeperEnergy = 100;

		return currentScore;
	}

	// Method Name:			toString
	// Parameters:			None
	// Return Values:		Information about the zoo: String
	// Partners:			None
	// Description:			This method returns information about the animals
	// and the food available, as well as the keepers energy and the score.
	@Override
	public String toString() {
		String currentState = "ANIMALS\n";
		for (int animals = 0; animals < cages.length; animals++) {
			currentState += cages[animals].toString();
			currentState += '\n';

		}

		currentState += "FOOD CRATES\n";
		for (int foods = 0; foods < foodCrates.length; foods++) {
			currentState += foodCrates[foods].toString();
			currentState += '\n';
		}

		currentState += String.format("ENERGY: %d\nSCORE: %d\n", keeperEnergy, score);
		return currentState;
	}

}