// Name:        Travis Kahl
// Class:       1400-850
// Program:     1
// Due Date:    August  28th
// Colleagues:  N/A

import java.util.Scanner;

public class tdkahl_First
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int number1, number2;

        System.out.print("Enter the first integer: ");
        number1 = input.nextInt();

        System.out.print("Enter the second integer: ");
        number2 = input.nextInt();

        if (number1 == number2)
            System.out.printf("%d == %d\n", number1, number2);
        
        if (number1 != number2)
            System.out.printf("%d != %d\n", number1, number2);

        if (number1 < number2)
            System.out.printf("%d < %d\n", number1, number2);

        if (number1 > number2)
            System.out.printf("%d > %d\n", number1, number2);

        if (number1 <= number2)
            System.out.printf("%d <= %d\n", number1, number2);

        if (number1 >= number2)
            System.out.printf("%d >= %d\n", number1, number2);
    }
}
