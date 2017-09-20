package myPackages.testPackage;

public class Human {
	private String name;
	private int height;		// height is taken as an argument as inches
	private double weight;		// weight is taken as an argument as pounds
	private int age;
	private char sex;
	private String eyeColor;
	private String ethnicity;

	public Human(String name, int height, double weight, int age,
				char sex, String eyeColor, String ethnicity) {
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.sex = sex;
		this.eyeColor = eyeColor;
		this.ethnicity = ethnicity;
	}

	// printing methods, kinda tedious
	public void printHeight() {
		int feet = height / 12;
		int inches = height % 12;

		System.out.printf("%s is %d feet and %d inches tall.\n", name, feet, inches);
	}

	public void printWeight() {
		System.out.printf("%s is %.2f lbs.\n", name, weight);
	}

	public void printAge() {
		System.out.printf("%s is %d years old.\n", name, age);
	}

	public void printSex() {
		if (sex == 'M' || sex == 'm') {
			System.out.printf("%s is a male.\n", name);
		}
		else if (sex == 'F' || sex == 'f') {
			System.out.printf("%s is a female.\n", name);
		}
		else {
			System.out.printf("%s considers themself nonbinary. (%c)\n", name, sex);
		}
	}

	public void printEyeColor() {
		System.out.printf("%s has %s eyes.\n", name, eyeColor);
	}

	public void printEthnicity() {
		System.out.printf("%s is %s.\n", name, ethnicity);
	}

	// setting methods now, sorta tedious
	public void setName(String name) {
		this.name = name;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
}
