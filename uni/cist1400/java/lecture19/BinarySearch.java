import java.util.Scanner;
public class BinarySearch {
	public static void main(String args[])
	{
		int a[] = { 2, 4, 6, 8, 10, 12, 37, 45, 68, 89 };
		int search, position;
		Scanner in = new Scanner(System.in);

		System.out.print("Enter search key: ");
		search = in.nextInt();

		position = binSearch(a, search);

		if (position != -1)
			System.out.println("Found at position " + position);
		else
			System.out.println(search + " was not found");
	}

	public static int binSearch(int[] foo, int searchKey)
	{
		int position = -1;
		int low = 0; int high = foo.length - 1;
		int middle;

		while (low <= high && position == -1)
		{
			middle = (low + high) / 2;
			if (searchKey == foo[middle])
				position = middle;
			else if (searchKey < foo[middle])
				high = middle - 1;
			else
				low = middle - 1;
		}

		return position;
	}
}