public class forLoop3 {
	public static void main(String args[])
	{
		int sum = 0;
		for (int foo = 20; foo >= 2; foo -= 2)
		{
			sum += foo;
			System.out.println("Sum is now " + sum);
		}

		System.out.println("Final sum is " + sum);
	}
}