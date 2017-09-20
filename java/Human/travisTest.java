import java.util.Scanner;
import myPackages.testPackage.Human;

public class travisTest {
	public static void main(String[] args) {
		String name = "Travis";
		int height = 65;
		float weight = 140;
		int age = 17;
		char sex = 'M';
		String eyeColor = "blue";
		String ethnicity = "supawhite";

		Human travis = new Human(name, height, weight, age, sex, eyeColor, ethnicity);
		travis.printHeight();
		travis.printWeight();
		travis.printAge();
		travis.printSex();
		travis.printEyeColor();
		travis.printEthnicity();
	}
}