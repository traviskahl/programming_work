public class breakTest {
	public static void main(String args[])
	{
		int xyz;
		for (xyz = 1; xyz <= 10; xyz++)
		{
			if (xyz == 5)
				break;
			System.out.printf("%d\n", xyz);
		}

		System.out.println("\n\nxyz is " + xyz);
	}
}