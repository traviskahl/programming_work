import java.util.Scanner;

public class q5 {
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();

        // equation is 2 * (n * n * n * n) - 10 * (n * n * n) + 17
        System.out.println("Number was " + n);

        System.out.printf("Answer is %d\n", (2 * (n * n * n * n)) - (10 * (n * n * n)) + 17);
    }
}
