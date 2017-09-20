public class scopeDemo {
	private static int x = 1;

	public static void main(String args[])
	{
		int x = 5;
		System.out.println("local x in main is " + x);

		useLocalVariable();
		useField();
		useLocalVariable();
		useField();

		System.out.println("\nlocal x in main is " + x);
	}

	public static void useLocalVariable()
	{
		int x = 25;
		System.out.println("\nlocal x entering useLV is " + x);
		++x;
		System.out.println("local x before leaving useLV is " + x);
	}

	public static void useField()
	{
		System.out.println("\nfield x on entering useF is " + x);
		x *= 10;
		System.out.println("field x before leaving useF is " + x);
	}
}