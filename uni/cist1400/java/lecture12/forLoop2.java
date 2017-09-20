public class forLoop2 {
	public static void main(String args[])
	{
		int sum = 0;

		for (int b = 2; b <= 20; b += 2)
			sum += b;

		System.out.printf("The sum is %d\n", sum);
	}
}