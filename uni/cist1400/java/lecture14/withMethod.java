import java.util.Scanner;

public class withMethod {
	public static void main(String args[])
	{
		for (int x = 1; x <= 10; x++)
			System.out.printf("%2d squared is %3d\n", x, square(x));
	}

	public static int square(int foobar)
	{
		System.out.println("I came to the method with " + foobar);
		return foobar * foobar;
	}
}