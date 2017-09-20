import java.util.Scanner;

public class newGrades {
    public static void main(String args[])
    {
        double total = 0;
        int howmany = 0;
        double average;
        int grade;
        Scanner foo = new Scanner(System.in);

        System.out.print("Enter a grade: ");
        grade = foo.nextInt();

        while (grade != -1)
        {
            total = total + grade;
            howmany = howmany + 1;
            System.out.print("Enter a grade (-1 to end): ");
            grade = foo.nextInt();
        }

        if (howmany != 0)
        {
            average = total / howmany;
            System.out.println("The average is: " + average);
        }
        else
        {
            System.out.println("No grades to average!");
        }

    }
}
