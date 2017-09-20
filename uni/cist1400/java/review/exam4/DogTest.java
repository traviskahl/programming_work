public class DogTest {
	public static void main(String[] args) {
		String name = "Taz";
		int age = 2;
		String breed = "Wheaten Terrier";

		Dog taz = new Dog(name, age, breed);
		taz.bark();
		System.out.print(taz.getInfo());
	}
}