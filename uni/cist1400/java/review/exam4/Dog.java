public class Dog {
	private String name;
	private int age;
	private String breed;

	public Dog(String n, int a, String b) {
		name	= n;
		age		= a;
		breed 	= b;
	}

	public void bark() {
		for (int pass = 1; pass <= 8; pass++) {
			System.out.print("Bark! ");
		}
		System.out.println();
		System.out.println();
	}

	public String getInfo() {
		String info = "";
		info += "Name: " + name + "\n";
		info += "Age: " + age + "\n";
		info += "Breed: " + breed + "\n";
		return info;
	}
}