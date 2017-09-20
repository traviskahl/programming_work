public class SelectionSort {
	public static void main(String args[])
	{
		int[] a = { 15, 62, 51, 7, 16, 12 };
		showArray("original", a);
		selectSort(a);
		showArray("final", a);
	}

	public static void showArray(String label, int[] t)
	{
		System.out.println("\n" + label + " order: ");
		for (int item : t)
			System.out.printf("%4d", item);
		System.out.println();
	}

	public static void selectSort(int[] data)
	{
		int smallest;
		for (int pos = 0; pos < data.length - 1; pos++)
		{
			smallest = pos;
			for (int a = pos + 1; a < data.length; a++)
			{
				if (data[a] < data[smallest])
					smallest = a;
			}
			int temp = data[pos];
			data[pos] = data[smallest];
			data[smallest] = temp;

			showArray("Pass # " + (pos+1), data);
		}
	}
}