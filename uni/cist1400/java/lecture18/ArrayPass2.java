public class ArrayPass2 {
	public static void main(String args[])
	{
		int[] foo  = { 1, 2, 3, 4, 5 };
		int[] wubba = { 10 ,20, 30, 40, 50, 60 ,70 };
		printArray(foo);
		printArray(wubba);
	}

	public static void printArray(int[] bar)
	{
		for (int value : bar)
			System.out.printf("%8d", value);
		System.out.println();
	}
}