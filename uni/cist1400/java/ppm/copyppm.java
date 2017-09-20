import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class copyppm {
    public static void main(String args[])
    {
        try
        {
            // declare System scanner and filenames
            Scanner input = new Scanner(System.in);
            String sourceFile, outFile;
        
            // get filenames
            System.out.print("Enter a source file: ");
            sourceFile = input.next();
            System.out.print("Enter an output file: ");
            outFile = input.next();

            // declare necessary objects
            File file = new File(sourceFile);
            PrintWriter writer = new PrintWriter(outFile);
            Scanner scan = new Scanner(file);

            // get header and append it
            String header = scan.next();
            writer.println(header);

            // get columns and rows, append them
            int columns = scan.nextInt();
            writer.printf("%d ", columns);
            int rows = scan.nextInt();
            writer.println(rows);

            // declare our buffer[] variable
            int bufferSize = rows * 3;
            int[] buffer = new int[bufferSize];
            
            // copy each pixel
            for (int index = 0; index < columns; index++)
            {
                for (int count = 0; count < bufferSize; count++)
                    buffer[count] = scan.nextInt();

                for (int x : buffer)
                  writer.println(x);                
            }

            // close writer object, this is more necessary than I thought at first
            writer.close();
        
        }
        catch (Exception ex)
        {
            System.out.println("There was an error.");
            ex.printStackTrace();
        }

        System.out.println("Wrote some things. Done now.");

    }
}
