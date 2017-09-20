import java.util.Scanner;

public class averageWithArray {
	public static void main(String args[])
	{
		final int HOWMANY = 5;
		double[] grades = new double[HOWMANY];

		System.out.println("Enter grades: ");
		Scanner in = new Scanner(System.in);
		for (int a = 0; a < HOWMANY; a++)
			grades[a] = in.nextDouble();

		double total = 0.0;
		for (int a = 0; a < HOWMANY; a++)
			total += grades[a];
		double avg = total / HOWMANY;

		System.out.print("The grades were: ");
		for (int a = 0; a < HOWMANY; a++)
			System.out.printf("%.2f ", grades[a]);
		System.out.println();

		System.out.println("The average was " + avg);
	}
}