import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.File;
import java.util.NoSuchElementException;

public class STTest {
	public static void main(String[] args) {
		try {
			File infile = new File("dum.csv");
			Scanner input = new Scanner(infile);

			System.out.println("hasNextLine is " + input.hasNextLine());
			String line = input.next();

			System.out.println("line is " + line);
			StringTokenizer st = new StringTokenizer(line, ",");

			while (st.hasMoreTokens()) {
				String name = st.nextToken();
				System.out.println("name is " + name);
				int pop = Integer.parseInt(st.nextToken());
				int vio = Integer.parseInt(st.nextToken());
				int mur = Integer.parseInt(st.nextToken());
				int rob = Integer.parseInt(st.nextToken());
				int aslt = Integer.parseInt(st.nextToken());
				int pro = Integer.parseInt(st.nextToken());
				int bur = Integer.parseInt(st.nextToken());
				int lar = Integer.parseInt(st.nextToken());
				int veh = Integer.parseInt(st.nextToken());
				int ars = Integer.parseInt(st.nextToken());
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
