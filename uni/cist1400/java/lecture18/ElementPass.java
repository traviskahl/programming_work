public class ElementPass {
	public static void main(String args[])
	{
		int[] foo = { 1, 2, 3, 4, 5 };
		System.out.println("Before sending element to modifyElement:");
		showArray(foo);
		modifyElement(foo[2]);
		System.out.println("After sending element to modifyElement:");
		showArray(foo);
	}

	public static void modifyElement(int thing)
	{
		System.out.println("\nInside mE, the original value was " + thing);
		thing*= 123;
		System.out.println("\nInside mE, we changed the value to " + thing);
	}

	public static void showArray(int[] thing)
	{
		for (int value : thing)
			System.out.printf("%8d", value);
		System.out.println();
	}
}