public class ArrayPass {
	public static void main(String args[])
	{
		int[] foo = { 1, 2, 3, 4, 5 };
		System.out.println("Before sending array to modifyArray:");
		showArray(foo);
		modifyArray(foo);
		System.out.println("After sending array to modifyArray:");
		showArray(foo);
	}

	public static void modifyArray(int[] bar)
	{
		for (int a = 0; a < bar.length; a++)
			bar[a] *= 2;
	}

	public static void showArray(int[] thing)
	{
		for (int value : thing)
			System.out.printf("%8d", value);

		System.out.println();
	}
}