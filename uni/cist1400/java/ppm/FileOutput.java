import java.util.Scanner;
import java.io.PrintWriter;

public class FileOutput {
    public static void main(String args[])
    {
        try
        {
            Scanner keyboard = new Scanner(System.in);
            String outFile;
            System.out.print("Enter output filename: ");
            outFile = keyboard.next();

            PrintWriter writer = new PrintWriter(outFile);

            int x = 42;

            writer.println("Here's a line of output!");
            writer.printf("Look, it's a number: %d\n", x);

            System.out.println("I just wrote some data to a file");
            writer.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
