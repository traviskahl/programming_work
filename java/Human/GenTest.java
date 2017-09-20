import java.util.Scanner;
import myPackages.testPackage.Human;

public class GenTest {
	private static Scanner input = new Scanner(System.in);

	public static void main(String args[]) {

		String name = getName();
		String ethnicity = getEthnicity();
		String eyeColor = getEyeColor();
		int height = getHeight();
		double weight = getWeight();
		int age = getAge();
		char sex = getSex(); // i wish i could :(

		Human guy = new Human(name, height, weight, age, sex, eyeColor, ethnicity);

		System.out.println();
		guy.printHeight();
		guy.printWeight();
		guy.printAge();
		guy.printSex();
		guy.printEyeColor();
		guy.printEthnicity();

	}

	public static String getName() {
		System.out.print("What's your name? > ");
		String name = input.nextLine();
		return name;
	}

	public static int getHeight() {
		System.out.print("What's your height (in inches)? > ");
		int height = input.nextInt();
		return height;
	}

	public static double getWeight() {
		System.out.print("What's your weight (in pounds)? > ");
		double weight = input.nextDouble();
		return weight;
	}

	public static int getAge() {
		System.out.print("What's your age? > ");
		int age = input.nextInt();
		return age;
	}

	public static char getSex() { // i never do :(
		System.out.print("What's your sex (M or F)? > ");
		char sex = input.next().charAt(0);
		return sex;
	}

	public static String getEyeColor() {
		System.out.print("What's your eye color? > ");
		String eyeColor = input.nextLine();
		return eyeColor;
	}

	public static String getEthnicity() {
		System.out.print("What's your ethnicity? > ");
		String ethnicity = input.nextLine();
		return ethnicity;
	}

}