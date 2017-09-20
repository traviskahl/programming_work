import java.util.Scanner;

public class DataValidation {
    public static void main(String args[])
    {
        int value;
        Scanner blah = new Scanner(System.in);
        System.out.print("Enter a number between 70 and 80: ");
        value = blah.nextInt();

        while (value < 70 || value > 80)
        {
            System.out.println(value + " is out of range!");
            System.out.print("Enter a number between 70 and 80: ");
            value = blah.nextInt();
        }

        System.out.println("Thanks for entering " + value);
    }
}
