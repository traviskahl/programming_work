import java.util.Scanner;

public class doWhileValidation {
	public static void main(String args[])
	{
		int value;
		Scanner i = new Scanner(System.in);

		do
		{
			System.out.print("Enter number 10 to 20: ");
			value = i.nextInt();
		} while ( (value < 10) || (value > 20) );

		System.out.printf("You entered %d!\n", value);
	}
}