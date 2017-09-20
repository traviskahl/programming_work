import java.util.Scanner;

public class SquareExample {
	public static void main(String args[])
	{
		for (int x = 1; x <= 10; x++)
			System.out.printf("%2d squared is %3d\n", x, square(x));
	}

	public static int square(int temp)
	{
		int result = (int) (Math.pow(temp, 2));
		return result;
	}
}