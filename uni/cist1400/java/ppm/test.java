import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class test {
	public static void main(String args[])
	{
		//int[] array = new int[30];
		//for (int count = 0; count < array.length; count++)
			//array[count] = count;

		/*System.out.println("Original: ");
		for (int x : array)
			System.out.printf("%5d", x);

		flipHorizontal(array, 0);

		System.out.println();
		System.out.println("Flipped");
		for (int x : array)
			System.out.printf("%5d", x);
		*/

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

            // append the max value for each triplet
            writer.println("255");

            int throwaway = scan.nextInt(); // ignore header

            // declare our buffer[] variable
            int bufferSize = rows * 3; // no need to make it larger than necessary
            System.out.println("bufferSize = " + bufferSize);
            int[] buffer = new int[bufferSize];

            for (int index = 0; index < columns; index++)
            {
            	for (int count = 0; count < bufferSize; count++)
            		buffer[count] = scan.nextInt();

            	flipHorizontal(buffer, columns);
            	
            	for (int x : buffer)
            		writer.println(x);
            }

            writer.close();
        }
        catch (Exception ex)
        {
        	System.out.println("Error");
        }	
	}

	public static void flipHorizontal(int[] buffer, int columns)
    {
        for (int count = 0; count < (buffer.length / 2); count += 3)
        {
        	System.out.printf("Count = %d\n", count);
            int len = buffer.length;
            System.out.printf("Len = %d\n", len);

            int x1  = buffer[count];
            int x2  = buffer[count + 1];
            int x3  = buffer[count + 2];

            System.out.println("x");
            System.out.println(x1);
            System.out.println(x2);
            System.out.println(x3);

            int y1  = buffer[len - (count + 3)];
            int y2  = buffer[len - (count + 2)];
            int y3  = buffer[len - (count + 1)];

            System.out.println("y");
            System.out.println(y1);
            System.out.println(y2);
            System.out.println(y3);

            //int temp;
            // switch x1 and y1
            int tempR  = x1;
            int tempG  = x2;
            int tempB  = x3;

            // same for x2 and y2
            /*temp    = y2;
            y2      = x2;
            x2      = temp;
            // and now for x3 and y3
            temp    = y3;
            y3      = x3;
            x3      = temp; */

            buffer[count]       = y1;
            buffer[count + 1]   = y2;
            buffer[count + 2]   = y3;

            buffer[len - (count + 3)] = tempR;
            buffer[len - (count + 2)] = tempG;
            buffer[len - (count + 1)] = tempB;

            System.out.println("buffers");

            for (int index = 0; index <= 2; index++)
            	System.out.println(buffer[index]);

            System.out.println("part 2");

            for (int index = 1; index <= 3; index++)
            	System.out.println(buffer[len - (count + index)]);
        }

    }

}