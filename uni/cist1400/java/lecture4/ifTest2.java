import java.util.Scanner;

public class ifTest2 {
    public static void main(String args[])
    {
       int grade;
       Scanner input = new Scanner(System.in);
       System.out.print("Please enter a grade: ");
       grade = input.nextInt();

       if (grade >= 60)
           System.out.println("Passed");
       if (grade < 60)
           System.out.println("Failed");
    }
}
