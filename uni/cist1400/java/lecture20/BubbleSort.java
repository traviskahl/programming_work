public class BubbleSort {
	public static void main(String args[])
	{
		int[] a = { 15, 62, 51, 7, 16, 12 };
		showArray("original", a);
		bubSort(a);
		showArray("final", a);
	}

	public static void showArray(String label, int[] t)
	{
		System.out.println("\n" + label + " order: ");
		for (int item : t)
			System.out.printf("%4d", item);
		System.out.println();
	}

	public static void bubSort(int[] foo)
	{
		for (int pass = 0; pass < foo.length - 1; pass++)
		{
			for (int pos = 0; pos < foo.length - 1; pos++)
			{
				if (foo[pos] > foo[pos+1])
				{
					int temp = foo[pos];
					foo[pos] = foo[pos+1];
					foo[pos+1] = temp;
				}
			}
		
		showArray("Pass #" + (pass+1), foo);

		}
	}
}