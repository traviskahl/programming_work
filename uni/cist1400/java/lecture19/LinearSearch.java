import java.util.Scanner;
public class LinearSearch {
	public static void main(String args[])
	{
		int[] a = { 2, 6, 4, 8, 10, 12, 89, 68, 45, 37 };
		int key, position;
		Scanner in = new Scanner(System.in);

		System.out.print("Enter integer search key: ");
		key = in.nextInt();

		position = linsearch(a, key);

		if (position != -1)
			System.out.println("Found value at pos " + position);
		else
			System.out.println(key + " was not found.");
	}

	public static int linsearch(int[] foo, int searchKey)
	{
		int position = -1;
		for (int n = 0; n < foo.length; n++)
			if (foo[n] == searchKey)
			{
				position = n;
				break;
			}
		return position;
	}
}