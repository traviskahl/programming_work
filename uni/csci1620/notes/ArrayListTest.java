public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Integer> myList = new ArrayList<Integer>(10); // specify type parameter along with class
		Scanner input = new Scanner(System.in);

		int value;

		System.out.print("Enter positive numbers to average (-1 to exit):\n");

		do {
			value = input.nextInt();
			if (value == -1)
				break;
			myList.add(value);
		} while (true);

		int sum = 0;
		for (int i = 0; i < myList.size(); i++) {
			sum += myList.get(i);
		}

		System.out.printf("Average is %d\n", sum / myList.size());
	}
}