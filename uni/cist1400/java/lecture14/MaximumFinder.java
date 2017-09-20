import java.util.Scanner;

public class MaximumFinder {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);

		System.out.print("Enter three values: ");
		double n1 = in.nextDouble();
		double n2 = in.nextDouble();
		double n3 = in.nextDouble();

		double result = maximum(n1, n2, n3);

		System.out.println("Maximum is: " + result);
	}

	public static double maximum(double x, double y, double z)
	{
		double maximumValue = x;

		if (y > maximumValue)
			maximumValue = y;
		if (z > maximumValue)
			maximumValue = z;

		return maximumValue;
	}
}