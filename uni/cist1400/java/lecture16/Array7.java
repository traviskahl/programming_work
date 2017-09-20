public class Array7 {
	public static void main(String args[])
	{
		final int ARRAY_SIZE = 10;
		int[] s = new int[ARRAY_SIZE];
		for (int j = 0; j < s.length; j++)
			s[j] = 2 + 2 * j;

		System.out.printf("%5s%8s\n", "Index", "Value");

		for (int x = 0; x < s.length; x++)
			System.out.printf("%5d%8d\n", x, s[x]);
	}
}