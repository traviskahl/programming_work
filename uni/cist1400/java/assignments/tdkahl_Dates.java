// Name:		Travis Kahl
// Class:		CIST1400-850
// Program:		7
// Due Date:	October 11th
// Colleagues:	N/A

import java.util.Scanner;

public class tdkahl_Dates {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int inputMonthOne	= 0;
		int inputMonthTwo	= 0;
		int inputDayOne		= 0;
		int inputDayTwo		= 0;
		int inputYearOne 	= 0;
		int inputYearTwo 	= 0;
		int daysInMonthOne	= 28; // initialize it to 28 because every month has at least 28 days
		int daysInMonthTwo	= 28; // same

		// THIS IS WHERE FIRST DATE IS TAKEN AND VALIDATED
		
		do
		{
			System.out.println("Enter first date now:");

			System.out.print("Enter Month: "); // first we need to get a month and set daysInMonthOne from that
			inputMonthOne = in.nextInt();
			if (inputMonthOne == 1 || inputMonthOne == 3 || inputMonthOne == 5 ||
				inputMonthOne == 7 || inputMonthOne == 8 || inputMonthOne == 10 ||
				inputMonthOne == 12)
			{
				daysInMonthOne = 31; // these months have 31 days
			}
			else if (inputMonthOne == 2)
			{
				daysInMonthOne = 28; // just this month has 28 days
			}
			else if (inputMonthOne == 4 || inputMonthOne == 6 ||
					 inputMonthOne == 9 || inputMonthOne == 11)
			{
				daysInMonthOne = 30; // these months have 30 days
			}

			System.out.print("Enter Day  : "); // next we need to get the day
			inputDayOne = in.nextInt();

			System.out.print("Enter Year : "); // then we need to get the year
			inputYearOne = in.nextInt();
			if (inputYearOne % 4 == 0 && inputMonthOne == 2)
				daysInMonthOne = 29; // this is what accounts for leap years

			// we need to tell the user what, if any, of what they entered was a bad date.
			if (inputMonthOne < 1 || inputMonthOne > 12)
				System.out.printf("%d is not a valid month.\n", inputMonthOne);
			if (inputDayOne < 1 || inputDayOne > daysInMonthOne)
				System.out.printf("%d is not a valid day.\n", inputDayOne);
			if (inputYearOne < 1900 || inputYearOne > 2400)
				System.out.printf("%d is not a valid year.\n", inputYearOne);

		} while ( ( inputMonthOne < 1 || inputMonthOne > 12 ) ||
				  ( inputDayOne < 1 || inputDayOne > daysInMonthOne ) ||
				  ( inputYearOne < 1900 || inputYearOne > 2400) );

		// THIS IS WHERE SECOND DATE IS TAKEN AND VALIDATED

		do
		{
			System.out.println("Enter second date now:");

			System.out.print("Enter Month: "); // first we need to get a month and set daysInMonthTwo from that
			inputMonthTwo = in.nextInt();
			if (inputMonthTwo == 1 || inputMonthTwo == 3 || inputMonthTwo == 5 ||
				inputMonthTwo == 7 || inputMonthTwo == 8 || inputMonthTwo == 10 ||
				inputMonthTwo == 12)
			{
				daysInMonthTwo = 31; // these months have 31 days
			}
			else if (inputMonthTwo == 2)
			{
				daysInMonthTwo = 28; // just this month has 28 days
			}
			else if (inputMonthTwo == 4 || inputMonthTwo == 6 ||
					 inputMonthTwo == 9 || inputMonthTwo == 11)
			{
				daysInMonthTwo = 30; // these months have 30 days
			}

			System.out.print("Enter Day  : "); // next we need to get the day
			inputDayTwo = in.nextInt();

			System.out.print("Enter Year : "); // then we need to get the year
			inputYearTwo = in.nextInt();
			if (inputYearTwo % 4 == 0 && inputMonthTwo == 2)
				daysInMonthTwo = 29; // this is what accounts for leap years

			// we need to tell the user what, if any, of what they entered was a bad date.
			if (inputMonthTwo < 1 || inputMonthTwo > 12)
				System.out.printf("%d is not a valid month.\n", inputMonthTwo);
			if (inputDayTwo < 1 || inputDayTwo > daysInMonthTwo)
				System.out.printf("%d is not a valid day.\n", inputDayTwo);
			if (inputYearTwo < 1900 || inputYearTwo > 2400)
				System.out.printf("%d is not a valid year.\n", inputYearTwo);

		} while ( ( inputMonthTwo	< 1 	|| inputMonthTwo 	> 12 ) 				||
				  ( inputDayTwo		< 1 	|| inputDayTwo	 	> daysInMonthTwo )	||
				  ( inputYearTwo	< 1900	|| inputYearTwo		> 2400) );

		// THIS IS WHERE THE DIFFERENCE IS CALCULATED

		int yearUsing		= inputYearOne;
		int yearCountingTo	= inputYearTwo;
		int monthUsing		= inputMonthOne;
		int monthCountingTo = inputMonthTwo;
		int dayUsing		= inputDayOne;
		int dayCountingTo	= inputDayTwo;
		int diff 			= 0
		int daysInUsingMonth;

		for (monthUsing; monthUsing != monthCountingTo; monthUsing++)
		{
			
		}

		for (dayUsing; dayUsing != dayCountingTo; dayUsing++)
		{
			diff++;
			if (dayUsing < daysInMonth)
		}

		/*
		if (inputYearOne > inputYearTwo) // count down since first date is later than second date
		{
			yearUsing = inputYearOne;
			yearCountingTo = inputYearTwo; 
		}
		else if (inputYearOne < inputYearTwo) // count up since first date is earlier than second date
		{
			yearUsing = inputYearTwo;
			yearCountingTo = inputYearOne;
		}
		
		if (inputDayOne > inputDayTwo) */
			

		// debugging output here
		/*System.out.printf("\ninputMonthOne is %d\n", inputMonthOne);
		System.out.printf("daysInMonthOne is %d\n", daysInMonthOne);
		System.out.printf("inputDayOne is %d\n", inputDayOne);
		System.out.printf("inputYearOne is %d\n", inputYearOne);

		System.out.printf("\ninputMonthTwo is %d\n", inputMonthTwo);
		System.out.printf("daysInMonthTwo is %d\n", daysInMonthTwo);
		System.out.printf("inputDayTwo is %d\n", inputDayTwo);
		System.out.printf("inputYearOne is %d\n", inputYearOne); */
	} 
}
