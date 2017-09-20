import java.util.Scanner;

class averageNoArray {
	public static void main(String args[])
	{
		double a, b, c, d, e;
		System.out.println("Enter grades: ");
		Scanner in = new Scanner(System.in);

		a = in.nextDouble(); b = in.nextDouble();
		c = in.nextDouble(); d = in.nextDouble();
		e = in.nextDouble();

		double avg = (a + b + c + d + e) / 5;

		System.out.println("The grades were " + a + " " + b + " " + c + " " + d + " " + e);

		System.out.printf("Average is %.2f\n", avg);
	}
}