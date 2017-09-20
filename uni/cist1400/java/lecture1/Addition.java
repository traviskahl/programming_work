
import java.util.Scanner;
public class Addition {
    public static void main(String args[])
    {
        int first;
        int second;
        int sum;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        first = input.nextInt();
        System.out.print("Enter second integer: ");
        second = input.nextInt();

        sum = first + second;
        System.out.printf("Sum is %d\n", sum);
    }

}
