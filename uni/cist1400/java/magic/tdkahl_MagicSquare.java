// Name:		Travis Kahl
// Class:		1400-850
// Program:		11	
// Due Date:	November 27th
// Colleagues:	N/A

import java.util.Scanner;
import java.io.File;
public class tdkahl_MagicSquare {
	public static void main(String[] args) {
		try {
			// get the filename
			Scanner input = new Scanner(System.in);
			System.out.print("Enter input filename: ");
			String fileName = input.nextLine();

			// declare necessary objects
			File sourceFile = new File(fileName);
			Scanner fileInput = new Scanner(sourceFile);

			// read information from the file
			int size = fileInput.nextInt();
			int[][] square = new int[size][size];
			for (int row = 0; row < size; row++) {
				for (int column = 0; column < size; column++) {
					square[row][column] = fileInput.nextInt();
				}
			}

			// calculate the magic number
			int magicnum = ((size) * (size * size + 1)) / 2;

			// do some output regarding important information
			System.out.println();
			System.out.printf("Checking a %d x %d Magic Square!\n", size, size);
			System.out.printf("The magic number is %d\n", magicnum);
			System.out.println();

			// output the magic square itself
			System.out.printf("%5s", "    "); // just a whitespace at the beginning
			for (int totalColumns = 1; totalColumns <= size; totalColumns++) {
				System.out.printf("%5s", "[" + totalColumns + "]");
			}

			System.out.println();
			for (int row = 0; row < size; row++) {
				System.out.printf("%5s", "[" + (row+1) + "]");
				for (int column = 0; column < size; column++) {
					System.out.printf("%5d", square[row][column]);
				}
				System.out.println();
			}

			System.out.println();

			// validate the rows
			boolean rowsValid		= checkRows(square, magicnum);
			boolean columnsValid	= checkColumns(square, magicnum); 
			boolean diagsValid		= checkDiagonals(square, magicnum);
			boolean isUnique		= checkUnique(square);

			System.out.println();
			System.out.print("MAGIC SQUARE: ");
			if (rowsValid && columnsValid && diagsValid && isUnique) {
				System.out.print("GOOD\n");
			}
			else {
				System.out.print("BAD\n");
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	  * checkRows()
	  *
	  * This method checks each row to see if it is a valid row, with all
	  * values adding up to the magic number sent in as an argument. Label
	  * the row outputs starting at 1.
	  *
	  * The output should be either the text GOOD or BAD, depending on the
	  * status of the individual row. If the row is BAD, also include what
	  * that row added up to instead of the magic number. See the example
	  * runs for an idea what the output should look like.
	  *
	  * The method should return true if all of the rows are valid and false
	  * otherwise.
	  *
	  * @param 		square 		a 2-d int array representing the square
	  * @param 		magicnum 	an int containing the calculated magic number
	  * @return 	boolean 	true or false if all of the rows are valid
	  */
	public static boolean checkRows(int[][] square, int magicnum) {
		boolean isValid = true;
		for (int row = 0; row < square.length; row++) {
			int sum = 0;
			for (int column = 0; column < square[row].length; column++) {
				sum += square[row][column];
			}

			if (sum != magicnum) {
				System.out.printf("ROW %d: BAD (%d instead of %d)\n", (row+1), sum, magicnum);
				isValid = false;
			}
			else {
				System.out.printf("ROW %d: GOOD\n", row+1);
			}
		}
		System.out.println();
		return isValid;
	}

	/**
	  * checkColumns()
	  *
	  * This method checks each column to see if it is a valid column, with all
	  * values adding up to the magic number sent in as an argument. Label
	  * the column outputs starting at 1.
	  *
	  * The output should be either the text GOOD or BAD, depending on the
	  * status of the individual column. If the column is BAD, also include what
	  * that column added up to instead of the magic number. See the example
	  * runs for an idea what the output should look like.
	  *
	  * The method should return true if all of the columns are valid and false
	  * otherwise.
	  *
	  * @param 		square 		a 2-d int array representing the square
	  * @param 		magicnum 	an int containing the calculated magic number
	  * @return 	boolean 	true or false if all of the columns are valid
	  */
	public static boolean checkColumns(int[][] square, int magicnum) {
		boolean isValid = true;
		for (int column = 0; column < square.length; column++) {
			int sum = 0;
			for (int row = 0; row < square[column].length; row++) {
				sum += square[row][column];
			}

			if (sum != magicnum) {
				System.out.printf("COLUMN %d: BAD (%d instead of %d)\n", (column+1), sum, magicnum);
			}
			else {
				System.out.printf("COLUMN %d: GOOD\n", column+1);
			}
		}
		System.out.println();
		return isValid;
	}

	/**
	  * checkDiagonals()
	  *
	  * This method checks the two major diagonals to see if they are valid,
	  * with all values adding up to the magic number sent in as an argument.
	  * Label the diagonal from upper-left corner (position [0][0]) to the
	  * bottom-right corner (position [n-1][n-1]) as DIAG 1. Label the
	  * other diagonal as DIAG 2.
	  *
	  * The output should be either GOOD or BAD, depending on the
	  * status of the individual diagonal. If the diagonal is BAD, also include
	  * what that diagonal added up to instead of the magic number. See the
	  * example runs for an idea what the output should look like.
	  *
	  * The method should return true if both of the diagonals are valid and false
	  * otherwise.
	  *
	  * @param 		square 		a 2-d int array representing the square
	  * @param 		magicnum 	an int containing the calculated magic number
	  * @return 	boolean		true of false if both of the diagonals are valid
	  */
	public static boolean checkDiagonals(int[][] square, int magicnum) {
		boolean isValid = true;
		int firstSum = 0;
		int secondSum = 0;

		// check first diagonal
		for (int x = 0; x < square.length; x++) {
			firstSum += square[x][x];
		}

		if (firstSum != magicnum) {
			System.out.printf("DIAG 1: BAD (%d instead of %d)\n", firstSum, magicnum);
			isValid = false;
		}
		else {
			System.out.println("DIAG 1: GOOD");
		}

		// check second diagonal
		int row 	= square.length - 1;
		int column 	= 0;

		while (row >= 0) {
			secondSum += square[row][column];
			row--;
			column++;
		}

		if (secondSum != magicnum) {
			System.out.printf("DIAG 2: BAD (%d instead of %d)\n", secondSum, magicnum);
			isValid = false;
		}
		else {
			System.out.println("DIAG 2: GOOD");
		}

		System.out.println();
		return isValid;
	}

	/**
	  * checkUnique()
	  * 
	  * This method checks to see if each value used in the potential magic
	  * square has been used once and only once in the entirety of the square.
	  *
	  * Differently sized squares will have different potential ranges of values
	  * to test. For instance, a 4x4 square will have 16 potential values
	  * to test (1-16). A 7x7 square will have 49 potential values to test.
	  *
	  * If all values in the appropriate range have been used only once,
	  * the output shoudl be the text GOOD for the label UNIQUE.
	  *
	  * If a value was used more than once or wasn't used at all, it should
	  * be listed in order from smallest to largest with a space between each
	  * offending value.
	  *
	  * See the example runs for an idea what the output should look like.
	  *
	  * The method should return true if all values have been used exactly once
	  * and false otherwise.
	  *
	  * @param 		square 		a 2-d int array representing the square
	  * @return 	boolean		true or false if all values are used exactly once
	  */
	public static boolean checkUnique(int[][] square) {
		boolean isValid = true;

		// read the 2d array into a 1d array
		int[] foo = new int[square.length * square.length];
		int index = 0;
		for (int row = 0; row < square.length; row++) {
			for (int column = 0; column < square[row].length; column++) {
				foo[index] = square[row][column];
				index++;
			}
		}

		// bubble sort the array
		for (int pass = 0; pass < foo.length - 1; pass++) {
			for (int pos = 0; pos < foo.length - 1; pos++) {
				if (foo[pos] > foo[pos+1]) {
					int temp = foo[pos];
					foo[pos] = foo[pos+1];
					foo[pos+1] = temp;
				}
			}
		}

		// now search the array
		System.out.print("UNIQUE: ");
		for (int searchKey = 1; searchKey < foo.length; searchKey++) {
			int foundCount = 0;
			for (int n = 0; n < foo.length; n++) {
				if (foo[n] == searchKey) {
					foundCount++;
				}
			}

			if (foundCount != 1) {
				isValid = false;
				System.out.printf("%d ", searchKey);
			}
		}

		if (isValid == true) {
			System.out.print("GOOD\n");
		}

		System.out.println();

		return isValid;
	}
}