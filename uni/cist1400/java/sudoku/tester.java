import java.util.Scanner;

public class tester {
	public static void main(String[] args) {
		Scanner get = new Scanner(System.in);
		System.out.print("Enter filename of potential Sudoku: ");
		String filename = get.next();

		tdkahl_SudokuChecker thing = new tdkahl_SudokuChecker(filename);

		thing.display();

		boolean a = thing.checkRows();
		boolean b = thing.checkColumns();
		boolean c = thing.checkRegions();

		if (a && b && c) {
			System.out.println("\nSudoku: YES");
		}
		else {
			System.out.println("\nSudoku: NO");
		}

	}
}