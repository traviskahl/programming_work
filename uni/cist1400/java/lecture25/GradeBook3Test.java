import java.util.Scanner;
public class GradeBook3Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GradeBook3 myGradeBook = new GradeBook3();

        System.out.printf("Initial course name is: %s\n\n", myGradeBook.getCourseName());

        System.out.println("Please enter the course name: ");
        String theName = input.nextLine();
        myGradeBook.setCourseName(theName);
        System.out.println();
        myGradeBook.displayMessage();
    }
}
