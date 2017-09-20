import java.util.Scanner;
import java.io.File;

public class FileInput {
    public static void main(String args[])
    {
        try {
            Scanner keyboard = new Scanner(System.in);

            System.out.println("Enter input filename: ");
            String inFile;
            inFile = keyboard.next();

            File file = new File(inFile);

            Scanner input = new Scanner(file);

            String first = input.next();
            System.out.println("First item of the file is: " + first);

            int v1 = input.nextInt();
            System.out.println("First int on the second line is: " + v1);

            int v2 = input.nextInt();
            System.out.println("Last int on the second line is: " + v2);

            System.out.println("Now reading the rest of the data!");
            while (input.hasNext())
            {
                int v = input.nextInt();
                System.out.printf("A value from the file: %d\n", v);
            }
        }
        catch (Exception ex) {
            System.out.println("An error has occured!");
            ex.printStackTrace();
        }
    }
}
