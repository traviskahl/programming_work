public class WhatHappens {
	public static void main(String args[])
	{
		int x = 10;
		if (x++ <= 10)
		{
			System.out.println("Hello");
		}
		if (++x == 11)
		{
			System.out.println("Hi");
		}

		while (x++ <= 20)
		{
			System.out.println(x);
		}
	}
}