// Name:        Travis Kahl
// Class:       1400-850
// Program:     9
// Due Date:    November 1st
// Colleagues:  N/A

import java.util.Scanner;

public class tdkahl_ROT13Arrays {
	private static Scanner input = new Scanner(System.in);
	public static void main(String args[])
	{
		final int LENGTH = 5;
		String[] sentences = new String[LENGTH];
		getSentences(sentences);
		displayOriginal(sentences);

		displayROT13(sentences);
		displayCombinedROT13(sentences);
	}

	/**
	  * getSentences
	  *
	  * This method allows the user to enter text into each of the
	  * element of the String array that it receives. 
	  *
	  * @param		sentences 		An array of String[] data
	  * @return 	None
	  */
	public static void getSentences(String[] sentences)
	{
		System.out.println("Enter your five sentences below:\n");

		for (int count = 0; count < sentences.length; count++)
		{
			System.out.printf("Sentence %d> ", count + 1);
			sentences[count] = input.nextLine();
		}
	}

	/**
	  * displayOriginal
	  *
	  * This method displays all of the elements of the array of
	  * String data that it receives, line by line (element by element).
	  *
	  * @param 		sentences 		An array of String[] data
	  * @return 	None
	  */
	public static void displayOriginal(String[] sentences)
	{
		System.out.println("\nThe original text:");
		for (int count = 0; count < sentences.length; count++)
		{
			System.out.println(sentences[count]);
		}
	}

	/**
	  * charConvert
	  *
	  * This method will take one char value as a parameter and convert
	  * it to its appropriate ROT13 equivalent. The return value will be the 
	  * new ROT13 char equivalent.
	  *
	  * This method will not do any output.
	  *
	  * @param 		toConvert 		A character to convert as a char
	  * @return 	The new ROT13 equivalent value as a char
	  */
	public static char charConvert(char toConvert)
	{
		char toReturn = '\0';
		switch (toConvert)
		{
			case ' ':
				break;
			case 'a': case 'A':
				toReturn = 'N';
				break;
			case 'b': case 'B':
                toReturn = 'O';
                break;
            case 'c': case 'C':
                toReturn = 'P';
                break;
            case 'd': case 'D':
                toReturn = 'Q';
                break;
            case 'e': case 'E':
                toReturn = 'R';
                break;
            case 'f': case 'F':
                toReturn = 'S';
                break;
            case 'g': case 'G':
                toReturn = 'T';
                break;
            case 'h': case 'H':
                toReturn = 'U';
                break;
            case 'i': case 'I':
                toReturn = 'V';
                break;
            case 'j': case 'J':
                toReturn = 'W';
                break;
            case 'k': case 'K':
                toReturn = 'X';
                break;
            case 'l': case 'L':
                toReturn = 'Y';
                break;
            case 'm': case 'M':
                toReturn = 'Z';
                break;
            case 'n': case 'N':
                toReturn = 'A';
                break;
            case 'o': case 'O':
                toReturn = 'B';
                break;
            case 'p': case 'P':
                toReturn = 'C';
                break;
            case 'q': case 'Q':
                toReturn = 'D';
                break;
            case 'r': case 'R':
                toReturn = 'E';
                break;
            case 's': case 'S':
                toReturn = 'F';
                break;
            case 't': case 'T':
                toReturn = 'G';
                break;
            case 'u': case 'U':
                toReturn = 'H';
                break;
            case 'v': case 'V':
                toReturn = 'I';
                break;
            case 'w': case 'W':
                toReturn = 'J';
                break;
            case 'x': case 'X':
                toReturn = 'K';
                break;
            case 'y': case 'Y':
                toReturn = 'L';
                break;
            case 'z': case 'Z':
                toReturn = 'M';
                break;
            default:
            	break;
		}

		return toReturn;
	}

	/**
	  * convertSentence
	  *
	  * This method will do the actual conversion of a String of data to its
	  * ROT13 equivalent in 5-character chunks of data. It should call on
	  * the charConvert() method to do the actual character conversion for each
	  * individual character. In other words, individual character conversion
	  * should not happen within this method.
	  *
	  * This method will not do any output.
	  *
	  * @param 		sentence 		A string variable to convert
	  * @return 	The 5-characters in a group ROT13 result as a String
	  */
	public static String convertSentence(String sentence)
	{
		String converted = "";
		int charsDisplayed = 0;
		for (int count = 0; count < sentence.length(); count++)
		{
			char toConvert = sentence.charAt(count);

			char convertedChar = charConvert(toConvert);
			converted += convertedChar;
			charsDisplayed++;
			if (charsDisplayed % 5 == 0)
				converted += " ";

		}
	
		return converted;
	}

	/**
	  * displayROT13
	  *
	  * This method will display in ROT13 format all of the elements of the
	  * array of String data that it receives. It will need to call on the
	  * method convertSentence() to convert each String before it displays it.
	  * Note that the original array should not be modified with ROT13 data.
	  *
	  * @param 		sentences 		An array of String[] data
	  * @return 	None
	  */
	public static void displayROT13(String[] sentences)
	{
		System.out.println("\nThe line-by-line ROT13: ");
		for (int count = 0; count < sentences.length; count++)
		{
			String convertedSentence = convertSentence(sentences[count]);
			System.out.println(convertedSentence);
		}
	}

	/**
	  * displayCombinedROT13
	  *
	  * This method takes an array of String data and combines all of the Strings
	  * into a single String that is then processed by the convertSentence()
	  * method. The method should essentially display the same results as the
	  * displayROT13() method, except that there won't be separate lines of
	  * output but rather one large result instead.
	  *
	  * @param 		sentences 		An array of String[] data
	  * @return 	None
	  */
	public static void displayCombinedROT13(String[] sentences)
	{
		System.out.println("\nThe combined ROT13: ");
		String fullSentence = "";

		for (int count = 0; count < sentences.length; count++)
		{
			String convertedSentence = convertSentence(sentences[count]);
			fullSentence += convertedSentence;
		}

		System.out.println(fullSentence);
	}
}
