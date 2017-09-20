import java.util.Scanner;

public class DNADriver {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String master = getMaster();
		System.out.println(master);
	
	}

	public static String getMaster() {
		boolean gettingMaster = true;
		String master = new String();

		do {

			System.out.print("Enter molecule for master DNA strand: ");
			master = input.next();

			try {
				for (int index = 0; index < master.length(); index++)
					if (master.charAt(index) != 'A' && master.charAt(index) != 'G' &&
						master.charAt(index) != 'C' && master.charAt(index) != 'T' ) {
						throw new InvalidDNAStrandException(master.charAt(index));
					}
				gettingMaster = false;
			}
			catch(InvalidDNAStrandException IDNASE) {
				System.out.println(IDNASE.getMessage());
				continue;
			}

		} while (gettingMaster);

		return master;

	}

}