import java.util.Scanner;
public class GradeBookTest2 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        GradeBook2 myGradeBook = new GradeBook2();

        System.out.print("Please enter course name: ");
        String courseName = input.nextLine();
        System.out.println();

        myGradeBook.displayMessage(courseName);
    }
}
