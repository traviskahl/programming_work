import java.util.Scanner;
public class Grades {
    public static void main(String args[])
    {
        double total = 0.0;
        double average = 0.0;
        int gradeCounter = 0;
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int dCount = 0;
        int fCount = 0;
        int grade;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter grades 1-100 or EOF: ");

        while (keyboard.hasNext())
        {
            grade = keyboard.nextInt();

            if (grade >= 1 && grade <= 100)
            {
                total = total + grade;
                gradeCounter++;
                switch (grade / 10)
                {
                    case 9  :
                    case 10 : aCount++; break;
                    case 8  : bCount++; break;
                    case 7  : cCount++; break;
                    case 6  : dCount++; break;
                    default : fCount++; break;
                }
            }
            else
            {
                System.out.println("Out of range, Not processed.");
            }
        }
        average = total / gradeCounter;
        System.out.println("Grade report: ");
        if (gradeCounter != 0)
        {
            System.out.printf("Total of the %d grades is %.2f\n", gradeCounter, total);
            System.out.printf("Class average is %.2f", average);
            System.out.printf("%s\n%s%d\n%s%d\n%s%d\n%s%d\n%s%d\n",
                    "Number of students who received each grade:",
                    "A: ", aCount, "B: ", bCount,
                    "C: ", cCount, "D: ", dCount,
                    "F: ", fCount);
        }
        else
        {
            System.out.println("No grades were entered!");
        }
    }
}
