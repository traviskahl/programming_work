public class Array3 {
	public static void main(String args[])
	{
		int[] n = new int[10];

		for (int x = 0; x < n.length; x++)
			n[x] = x * 10;

		System.out.printf("%5s%8s\n", "Index", "Value");
		for (int x = 0; x < n.length; x++)
			System.out.printf("%5d%8d\n", x, n[x]);
	}
}