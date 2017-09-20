import java.util.Scanner;

public class Grades2 {
    public static void main(String args[])
    {
        int total = 0;
        int counter = 1;
        int grade;

        final int maxGrades = 10;
        Scanner get = new Scanner(System.in);

        while (counter <= maxgrades)
        {
            System.out.print("Enter a grade: ");
            grade = get.nextInt();
            total = total + grade;
            counter = counter + 1;
        }
        int average = total / maxgrades;
        System.out.printf("The total is: %d\n", total);
        System.out.printf("The average is: %d\n", average);
    }

}
