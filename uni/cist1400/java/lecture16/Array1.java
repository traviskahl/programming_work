public class Array1 {
	public static void main(String args[])
	{
		int[] n;
		n = new int[10];

		System.out.printf("%5s%8s\n", "Index", "Value");

		for (int x = 0; x < n.length; x++)
			System.out.printf("%5d%8d\n", x, n[x]);
	}
}