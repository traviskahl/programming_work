// Name:        Travis Kahl
// Class:       1400-850
// Program:     5
// Due Date:    September 25th
// Colleagues:  N/A

import java.util.Scanner;

public class tdkahl_NumberConversions {
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		int eightPowerSix = 262144; // eight to the 6th power is 262144, the largest number needed for octal conversion
		int twoPower19 = 524288; // two to the 19th power is 524288, the number we need for binary conversion

		System.out.print("Enter a number between 0 and 1048575: ");
		int inputNumber = input.nextInt();

		while (inputNumber < 0 || inputNumber > 1048575)
		{
			System.out.println("That number is too large or too small.");
			System.out.print("Enter a number between 0 and 1048575: ");
			inputNumber = input.nextInt();
		}

		System.out.print("Enter a 'b' to convert to binary or an 'o' to convert to octal: ");
		char conversionChar = input.next().charAt(0);

		while (conversionChar != 'b' && conversionChar != 'o')
		{
			System.out.println("That isn't an option.");
			System.out.print("Enter a 'b' to convert to binary or an 'o' to convert to octal: ");
			conversionChar = input.next().charAt(0);
		}

		int remainder = inputNumber; // needed a number to operate on while preserving the original value
		switch (conversionChar)
		{
			case 'b': // here we convert to binary

				int binaryPower = twoPower19; // another number to operate on

				int twentyPlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2; // taking out a two

				int nineteenPlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2;

				int eighteenPlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2;

				int seventeenPlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2;

				int sixteenPlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2;

				int fifteenPlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2;

				int fourteenPlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2;

				int thirteenPlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2;

				int twelvePlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2;

				int elevenPlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2;

				int tenPlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2;

				int ninePlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2;

				int eightPlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2;

				int sevenPlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2;

				int sixPlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2;

				int fivePlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2;

				int fourPlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2;

				int threePlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2;

				int twoPlace = remainder / binaryPower;
				remainder = remainder % binaryPower;
				binaryPower = binaryPower / 2;

				int onePlace = remainder;

				System.out.printf("%d in binary is: %d%d%d%d%d%d%d%d%d%d%d%d%d%d%d%d%d%d%d%d\n", inputNumber,
					twentyPlace,	nineteenPlace,	eighteenPlace,	seventeenPlace,	sixteenPlace,	fifteenPlace,
					fourteenPlace,	thirteenPlace,	twelvePlace,	elevenPlace,	tenPlace,		ninePlace,
					eightPlace,		sevenPlace,		sixPlace,		fivePlace,		fourPlace,		threePlace,
					twoPlace,		onePlace);

				break;

			case 'o': // convert to octal
				
				int power = eightPowerSix; // another number to operate on

				int seventhPlace = remainder / power;
				remainder = remainder % power;
				power = power / 8; // going down by one power of eight

				int sixthPlace = remainder / power;
				remainder = remainder % power;
				power = power / 8;

				int fifthPlace = remainder / power;
				remainder = remainder % power;
				power = power / 8;

				int fourthPlace = remainder / power;
				remainder = remainder % power;
				power = power / 8;

				int thirdPlace = remainder / power;
				remainder = remainder % power;
				power = power / 8;

				int secondPlace = remainder / power;
				remainder = remainder % power;
				power = power / 8;

				int firstPlace = remainder;

				System.out.printf("%d in octal is: %d%d%d%d%d%d%d\n", inputNumber,
					seventhPlace, sixthPlace, fifthPlace, fourthPlace, thirdPlace,
					secondPlace, firstPlace);

				break;
		}
	
		
	}
}
