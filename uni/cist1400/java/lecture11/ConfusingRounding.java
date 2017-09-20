public class ConfusingRounding {
	public static void main(String args[])
	{
		double x = 1.234;
		double y = 6.543;
		double z = x + y;
		System.out.printf("  %4.2f\n", x);
		System.out.printf("+ %4.2f\n", y);
		System.out.printf("-------\n");
		System.out.printf("  %4.2f\n", z);
	}
}