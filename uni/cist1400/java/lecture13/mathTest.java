import java.util.Scanner;

public class mathTest {
	public static void main(String args[])
	{
		double a;
		Scanner i = new Scanner(System.in);

		System.out.print("Enter number: ");
		a = i.nextDouble();

		System.out.printf("abs: %.2f\n", Math.abs(a));
		System.out.printf("ceil: %.2f\n", Math.ceil(a));
		System.out.printf("sqrt: %.2f\n", Math.sqrt(a));
		System.out.printf("Pi: %.2f\n", Math.PI);
	}
}