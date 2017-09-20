import java.util.Scanner;
public class Array10 {
	public static void main(String args[]) {
		final int ARR_SIZE = 11, HOWMANY = 5;
		int[] freq = new int [ARR_SIZE];
		Scanner in = new Scanner(System.in);

		System.out.println("Enter values between 1 and 10");
		for (int x = 1; x <= HOWMANY; x++)
		{
			System.out.print("Enter #" + x + ": ");
			int value = in.nextInt();
			freq[value]++;
		}

		System.out.printf("%5s%10s\n", "Value", "Frequency");
		for (int x = 1; x < freq.length; x++)
			System.out.printf("%5d%10d\n", x, freq[x]);
	}
}