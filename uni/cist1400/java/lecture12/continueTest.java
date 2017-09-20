public class continueTest {
	public static void main(String args[])
	{
		int xyz;
		for (xyz = 1; xyz <= 10; xyz++)
		{
			if (xyz % 2 == 0)
				continue;
			System.out.printf("%d ", xyz);
		}

		System.out.println("\n\nSkipped evens!");
	}
}