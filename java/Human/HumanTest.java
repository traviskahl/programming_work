import java.util.Scanner;
import myPackages.testPackage.Human;

public class HumanTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Human dude = new Human();

		dude.setName("Dude");
		dude.setHeight(36);
		dude.setWeight(150);
		dude.setAge(20);
		dude.setSex('M');
		dude.setEyeColor("Brown");
		dude.setEthnicity("White");

		dude.printHeight();
		dude.printWeight();
		dude.printAge();
		dude.printSex();
		dude.printEyeColor();
		dude.printEthnicity();

	}
}