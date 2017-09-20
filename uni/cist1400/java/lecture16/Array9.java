public class Array9 {
	public static void main(String args[])
	{
		int[] n = { 1, 3, 5, 5, 7, 2, 99, 16, 45, 67 };
		int total = 0;

		for (int i = 0; i < n.length; i++)
			total += n[i];

		System.out.println("Total of values is " + total);
	}
}