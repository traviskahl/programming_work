public class forLoop4 {
	public static void main(String args[])
	{
		for (int x = 1; x <= 3; x++)
		{
			for (int y = 1; y <= 3; ++y)
			{
				System.out.printf("x = %d, y = %d\n", x, y);
			}

			System.out.println("-----------------------");
		}
	}
}