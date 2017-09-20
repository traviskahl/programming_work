// Name:        Travis Kahl
// Class:       1400-850
// Program:     10
// Due Date:    November 14th
// Colleagues:  N/A

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class tdkahl_PPM {
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

            // append the max value for each triplet
            writer.println("255");

            // declare our buffer[] variable
            int bufferSize = rows * 3; // no need to make it larger than necessary
            int[] buffer = new int[bufferSize];

            // find out what the user wants to change

            System.out.println("Do you want Red Negative? (y/n)");
            char willChangeRed = input.next().charAt(0);

            System.out.println("Do you want Green Negative? (y/n)");
            char willChangeGreen = input.next().charAt(0);

            System.out.println("Do you want Blue Negative? (y/n)");
            char willChangeBlue = input.next().charAt(0);

            System.out.println("Do you want to Greyscale? (y/n)");
            char willChangeGrey = input.next().charAt(0);

            System.out.println("Do you want to Horizontal Flip? (y/n)");
            char willChangeFlip = input.next().charAt(0);

            int throwaway = scan.nextInt(); // don't pay attention to the header information;
            // copy each pixel
            for (int index = 0; index < columns; index++)
            {
                for (int count = 0; count < bufferSize; count++)
                    buffer[count] = scan.nextInt();

                //negateRed(buffer, columns);

                if (willChangeRed == 'y')
                	negateRed(buffer, columns);

                if (willChangeGreen == 'y')
                	negateGreen(buffer, columns);

                if (willChangeBlue == 'y')
                	negateBlue(buffer, columns);

                if (willChangeGrey == 'y')
                	greyscale(buffer, columns);

                if (willChangeFlip == 'y')
                	flipHorizontal(buffer, columns);
				
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

    /**
     * negateRed
     *
     * This method negates the red value in the image. All P3-format
     * PPM images have an image depth of 255, so use that in your 
     * method's calculations.
     *
     * @param	buffer 		an integer array containing the image buffer
     * @param 	columns		an integer with the number of columns in the image
     * @return	NONE
     */
    public static void negateRed(int[] buffer, int columns)
    {
    	for (int count = 0; count < buffer.length; count += 3)
    	{
    		buffer[count] = 255 - buffer[count];
    	}
    }

    /**
     * negateGreen
     *
     * This method negates the green value in the image. All P3-format
     * PPM images have an image depth of 255, so use that in your
     * method's calculations.
     *
     * @param	buffer 		an integer array containing the image buffer
     * @param	columns		an integer with the number of columns in the image
     * @return 	NONE
     */
    public static void negateGreen(int[] buffer, int columns)
    {
    	for (int count = 1; count < buffer.length; count += 3)
    	{
    		buffer[count] = 255 - buffer[count];
    	}
    }

    /**
     * negateBlue
     *
     * This method negates the blue value in the image. All P3-format
     * PPM images have an image depth of 255, so use that in your
     * method's calculations.
     *
     * @param	buffer 		an integer array containing the image buffer
     * @param	columns		an integer with the number of columns in the image
     * @return 	NONE
     */
    public static void negateBlue(int[] buffer, int columns)
    {
    	for (int count = 2; count < buffer.length; count += 3)
    	{
    		buffer[count] = 255 - buffer[count];
    	}
    }

    /**
     * greyscale
     *
     * This method converts each pixel to its greyscale equivalent by
     * average the red, green, and blue values and replacing each of thos
     * values with the calculated average.
     *
     * @param	buffer 		an integer array containing the image buffer
     * @param 	columns 	an integer with the number of columns in the image
     * @return 	NONE
     */
    public static void greyscale(int[] buffer, int columns)
    {
    	for (int count = 0; count < buffer.length; count += 3)
    	{
    		int red 	= buffer[count];
    		int green 	= buffer[count + 1];
    		int blue 	= buffer[count + 2];

    		int average = (red + green + blue) / 3;

    		buffer[count] 		= average;
    		buffer[count + 1] 	= average;
    		buffer[count + 2]	= average;
    	}
    }

    /**
     * flipHorizontal
     *
     * This method flips a single row of the image so that it is a horizontal mirror
     * of the original row.
     *
     * @param	buffer 		an integer array containing the image buffer
     * @param 	columns 	an integer with the number of columns in the image
     * @return 	NONE
     */
    public static void flipHorizontal(int[] buffer, int columns)
    {
        for (int count = 0; count < buffer.length / 2; count += 3)
        {
            // this method doesn't work properly and I'm not sure how to fix it
            // it appears to work properly on one row, but everything after this
            // is completely messed up.

            int len = buffer.length;

            int x1  = buffer[count];
            int x2  = buffer[count + 1];
            int x3  = buffer[count + 2];

            int y1  = buffer[len - (count + 3)];
            int y2  = buffer[len - (count + 2)];
            int y3  = buffer[len - (count + 1)];

            int tempR  = x1;
            int tempG  = x2;
            int tempB  = x3;
    
            buffer[count]       = y1;
            buffer[count + 1]   = y2;
            buffer[count + 2]   = y3;

            buffer[len - (count + 3)] = tempR;
            buffer[len - (count + 2)] = tempG;
            buffer[len - (count + 1)] = tempB;
        }

    }

}
