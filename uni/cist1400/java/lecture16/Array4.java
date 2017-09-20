public class Array4 {
	public static void main(String args[])
	{
		int[] n = { 32, 27, 64, 18, 95, 14, 90, 70, 60, 37 };

		System.out.printf("%5s%8s\n", "Index", "Value");
		for (int x = 0; x < n.length; x++)
			System.out.printf("%5d%8d\n", x, n[x]);
	}
}