public class MethodOverloadOne {
	public static void main(String args[])
	{
		System.out.println("Square of 7 is " + square(7));
		System.out.println("Square of 7.5 is " + square(7.5));
	}

	public static int square(int iValue)
	{
		System.out.println("\nCalled int with " + iValue);
		return iValue * iValue;
	}

	public static double square(double dValue)
	{
		System.out.println("\nCalled double with " + dValue);
		return Math.pow(dValue, 2);
	}
}