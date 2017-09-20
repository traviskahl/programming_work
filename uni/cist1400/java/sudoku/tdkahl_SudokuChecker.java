// Name:		Travis Kahl
// Class:		1400-850
// Program:		12
// Due Date:	December 5th
// Colleagues:	N/A

import java.io.File;
import java.util.Scanner;

public class tdkahl_SudokuChecker {
	private int[][] grid = new int[9][9];

	/**
	  * tdkahl_SudokuChecker()
	  *
	  * This is the constructor method for the class. It will not have
	  * a return type, and the name of the method needs to match the
	  * name of the class exactly.
	  *
	  * This method takes as an argument a String that is the name of a
	  * file. It should open up the file and read in the file contents
	  * into the 2-d int array "grid" that is a private instance variable
	  * of the class.
	  *
	  * @param		inputFile 	a String containing the input file name
	  * @return 	no return type at all
	  */
	public tdkahl_SudokuChecker(String inputFile) {
		try {
			File source = new File(inputFile);
			Scanner input = new Scanner(source);

			for (int currentRow = 0; currentRow < grid.length; currentRow++) {
				for (int currentColumn = 0; currentColumn < grid.length; currentColumn++) {
					grid[currentRow][currentColumn] = input.nextInt();
				}
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	  * display()
	  *
	  * This method displays the square to the screen. There should not
	  * be any labeling of the rows or columns, but separating the output
	  * into regions is required for easier visual identification of each
	  * region of the Sudoku grid. See the example runs for examples.
	  *
	  */
	public void display() {
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid.length; column++) {
				System.out.printf("%4d", grid[row][column]);
				if (column == 2 || column == 5)
					System.out.printf("%4s", "|");
			}
			System.out.println();
			if (row == 2 || row == 5)
				System.out.println("-----------------------------------------------");
		}
		System.out.println();
	}

	/**
	  * checkRows()
	  *
	  * This method checks each row to see if it is a valid row, with each
	  * value between 1 and 9 inclusive being used only once.
	  *
	  * The method should label each of the 9 rows and then identify
	  * if the row is GOOD or BAD by outputting either the text GOOD or BAD.
	  * There is no need to identify which values are bad (either duplicated
	  * or missing).
	  *
	  * The method should return true if all of the rows are valid and false 
	  * otherwise.
	  *
	  * @return		boolean 	true or false if all of the rows are valid
	  */
	public boolean checkRows() {
		boolean isValid = true;

		for (int currentRow = 1; currentRow <= grid.length; currentRow++) {
			// read part of 2d array into 1d array
			int[] foo = new int[9];
			boolean isRowValid = true;
			for (int x = 0; x < grid.length; x++) {
				foo[x] = grid[currentRow-1][x];
			}

			// sort the array
			for (int pass = 0; pass < grid.length - 1; pass++) {
				for (int pos = 0; pos < grid.length - 1; pos++) {
					if (foo[pos] > foo[pos+1]) {
						int temp = foo[pos];
						foo[pos] = foo[pos+1];
						foo[pos+1] = temp;
					}
				}
			}

			// now search the array for each individual number
			for (int key = 1; key <= grid.length; key++) {
				int foundCount = 0;
				for (int n = 0; n < grid.length; n++) {
					if (foo[n] == key) {
						foundCount++;
					}
				}
				if (foundCount != 1) {
					isRowValid = false;
				}
			}

			// do output based on if the row is valid
			if (isRowValid) {
				System.out.printf("ROW %d: GOOD\n", currentRow);
			}
			else {
				System.out.printf("ROW %d: BAD\n", currentRow);
				isValid = false;
			}
		}
		System.out.println();
		return isValid;
	}

	/**
	  * checkColumns()
	  *
	  * This method checks each column to see if it is a valid column, with each
	  * value between 1 and 9 inclusive being used only onece.
	  *
	  * The method should label each of the 9 columns and then identify
	  * if the column is GOOD or BAD by outputting either the text GOOD or BAD.
	  * There is no need to identify which values are bad (either duplicated
	  * or missing).
	  *
	  * The method should return true if all of the columns are valid and false
	  * otherwise.
	  *
	  * @return 	boolean 	true or false if all of the columns are valid
	  */
	public boolean checkColumns() {
		boolean isValid = true;

		for (int currentColumn = 1; currentColumn <= grid.length; currentColumn++) {
			// read part of 2d array into 1d array
			int[] foo = new int[9];
			boolean isColumnValid = true;
			for (int x = 0; x < grid.length; x++) {
				foo[x] = grid[x][currentColumn-1];
			}

			// sort the array
			for (int pass = 0; pass < grid.length - 1; pass++) {
				for (int pos = 0; pos < grid.length - 1; pos++) {
					if (foo[pos] > foo[pos+1]) {
						int temp = foo[pos];
						foo[pos] = foo[pos+1];
						foo[pos+1] = temp;
					}
				}
			}

			// now search the array for each individual number
			for (int key = 1; key <= grid.length; key++) {
				int foundCount = 0;
				for (int n = 0; n < grid.length; n++) {
					if (foo[n] == key) {
						foundCount++;
					}
				}
				if (foundCount != 1) {
					isColumnValid = false;
				}
			}

			// do output based on if the row is valid
			if (isColumnValid) {
				System.out.printf("COLUMN %d: GOOD\n", currentColumn);
			}
			else {
				System.out.printf("COLUMN %d: BAD\n", currentColumn);
				isValid = false;
			}
		}
		System.out.println();
		return isValid;
	}

	/**
	  * checkRegions()
	  *
	  * This method checks each of the nine 3x3 regions of the Sudoku to see if
	  * they are valid. A valid region will, like rows and columns, only
	  * contain each of the numbers from 1 through 9 inclusive once.
	  *
	  * The method should label each of the 9 regions and then identify
	  * if the region is GOOD or BAD by outputting either the text GOOD or BAD.
	  * There is no need to identify which values are bad (either duplicated
	  * or missing).
	  *
	  * The method should return true if all of the regions are valid and false
	  * otherwise.
	  *
	  * @return 	boolean 	true or false if all of the regions are valid
	  */
	public boolean checkRegions() {
		boolean isValid = true;

		int[] foo = new int[9];
		int startingRow = 0;
		int startingCol = 0;

		for (int region = 1; region <= grid.length; region++) {
			boolean isRegionValid = true;

			foo[0] = grid[startingRow][startingCol];
			foo[1] = grid[startingRow][startingCol+1];
			foo[2] = grid[startingRow][startingCol+2];
			foo[3] = grid[startingRow+1][startingCol];
			foo[4] = grid[startingRow+1][startingCol+1];
			foo[5] = grid[startingRow+1][startingCol+2];
			foo[6] = grid[startingRow+2][startingCol];
			foo[7] = grid[startingRow+2][startingCol+1];
			foo[8] = grid[startingRow+2][startingCol+2];

			// sort the array
			for (int pass = 0; pass < grid.length - 1; pass++) {
				for (int pos = 0; pos < grid.length - 1; pos++) {
					if (foo[pos] > foo[pos+1]) {
						int temp = foo[pos];
						foo[pos] = foo[pos+1];
						foo[pos+1] = temp;
					}
				}
			}

			// now search the array for each individual number
			for (int key = 1; key <= grid.length; key++) {
				int foundCount = 0;
				for (int n = 0; n < grid.length; n++) {
					if (foo[n] == key) {
						foundCount++;
					}
				}
				if (foundCount != 1) {
					isRegionValid = false;
				}
			}

			// do output based on if the row is valid
			if (isRegionValid) {
				System.out.printf("REGION %d: GOOD\n", region);
			}
			else {
				System.out.printf("REGION %d: BAD\n", region);
				isValid = false;
			}

			// now increment the starting rows and columns
			startingCol += 3;

			if (startingCol > 6) {
				startingRow += 3;
				startingCol = 0;
			}

		}

		return isValid;
	}
}
