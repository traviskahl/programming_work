import java.io.File;
import java.util.Scanner;
import java.util.Formatter;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.FormatterClosedException;

public class IOTest {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Do you want to read (1) or write (2)? > ");
		int choice = input.nextInt();
		if (choice == 1) {
			readFile();
		}
		else {
			writeFile();
		}
	}

	public static void writeFile() {
		try {
			System.out.println("Enter the name of the file you want: ");
			String fileName = input.next();
			File newfile = new File(fileName + ".txt");
			Formatter output = new Formatter(newfile);

			String get = new String();
			for (int count = 0; count < 5; count++) {
				get = input.next();
				output.format(get);
				output.format("\n");
			}
			output.close();
		}
		catch(FileNotFoundException FNFE) {
			System.err.println("No file like that.");
		}		
	}

	public static void readFile() {
		try {
			File newfile = new File("test.txt");
			Scanner output = new Scanner(newfile);
			while (output.hasNext()) {
				System.out.println(output.next());
			}

		}
		catch(Exception ex) {
			System.err.println("YOU MESSED UP");
		}
	}
}