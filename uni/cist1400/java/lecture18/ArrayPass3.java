public class ArrayPass3 {
	public static void main(String args[])
	{
		double[] a = { 12, 23, 34, 45, 56, 67 };
		double average = avgArray(a);
		System.out.printf("The average is %.2f\n", average);
	}

	public static double avgArray(double[] stuff)
	{
		double sum = 0.0;
		for (double value : stuff)
			sum += value;
		return sum;
	}
}