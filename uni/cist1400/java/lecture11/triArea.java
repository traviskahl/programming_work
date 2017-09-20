import java.util.Scanner;
public class triArea {
	public static void main(String args[])
	{
		double base, height, area;
		System.out.println("Area of a triangle!");
		Scanner i = new Scanner(System.in);
		System.out.print("Enter base: ");
		base = i.nextDouble();
		System.out.print("Enter height: ");
		height = i.nextDouble();

		area = (1 / 2) * base * height;
		System.out.printf("Area of is %.2f\n", area);
	}
}