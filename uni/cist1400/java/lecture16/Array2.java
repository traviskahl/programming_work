public class Array2 {
	public static void main(String args[])
	{
		int[] n;
		n = new int[4];

		System.out.printf("%5s%8s\n", "Index", "Value");
		System.out.printf("%5d%8d\n", 0, n[0]);
		System.out.printf("%5d%8d\n", 1, n[1]);
		System.out.printf("%5d%8d\n", 2, n[2]);
		System.out.println("	3		" + n[3]);

	}
}