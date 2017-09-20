// Name:		Travis Kahl
// Class:		CIST1400-850
// Program:		8
// Due Date:	October 20th
// Colleagues:	N/A

import java.util.Scanner;

public class tdkahl_ReadingMethods {
	public static Scanner input = new Scanner(System.in);
	public static void main(String args[])
	{
		double numWords 			= getWords();
		double numSentences 		= getSentences();
		double numBigWords			= getBigWords();
		double numSyllables 		= getSyllables();

		double gfReadingIndex		= GunningFog(numWords, numSentences, numBigWords);
		double readingEaseScore		= FleschRESCore(numWords, numSentences, numSyllables);
		String gradeLevel			= FleschGL(readingEaseScore);

		displayResults(gfReadingIndex, readingEaseScore, gradeLevel);
	}

	/**
	* getWords
	*
	* This method should read a value from the user until the value entere
	* is greater than or equal to 100 (we need at least 100 words to make
	* a useful reading level determination).
	*
	* @param	No parameters are required
	* @return 	The number of words as a double
	*/
	public static double getWords()
	{
		double numWords;
		do
		{
			System.out.print("Please enter the number of words in the sample:     ");
			numWords = input.nextDouble();
		} while (numWords < 100);

		return numWords;
	}

	/**
	* getSentences
	*
	* This method should read a value from the user until the value entered
	* is greater than or equal to 1. It's assumed that there should be at
	* least 1 sentence in the sample.
	*
	* @param 	No parameters are required
	* @return	The number of sentences as a double
	*/
	public static double getSentences()
	{
		double numSentences;
		do
		{
			System.out.print("Please enter the number of sentences in the sample: ");
			numSentences = input.nextDouble();
		} while (numSentences < 1);

		return numSentences;
	}

	/**
	* getBigWords
	*
	* This method should read a value from the user until the value entered 
	* is greater than or equal to 0. "Big Words" are words with three or 
	* more syllables. It is possible that the reading sample has 0 "big 
	* words", so this method should validate for 0 and above.
	*
	* @param 	No parameters are required
	* @return	The number of big words as a double
	*/
	public static double getBigWords()
	{
		double numBigWords;
		do
		{
			System.out.print("Please enter the number of big words in the sample: ");
			numBigWords = input.nextDouble();
		} while (numBigWords < 0);

		return numBigWords;
	}

	/**
	* getSyllables
	*
	* This method should read a value from the user until the value entered
	* is greater than or equal to 1. Assuming there are at least 100 words
	* in the sample , there should be at least 1 syllable in the sample.
	*
	* @param 	No parameters are required
	* @return	The number of syllables as a double
	*/
	public static double getSyllables()
	{
		double numSyllables;
		do
		{
			System.out.print("Please enter the number of syllables in the sample: ");
			numSyllables = input.nextDouble();
		} while (numSyllables < 1);

		return numSyllables;
	}

	/**
	* GunningFog
	*
	* This method should determine the Gunning Fog Index given the number of
	* words, sentences and big words in a passage.
	*
	* @param 	words 		The number of words in the sample as a double
	* @param 	sentences 	The number of sentences in the sample as a double
	* @param 	big 		the number of big words in the sample as a double
	* @return 	the Gunning Fog Index as a double
	*/
	public static double GunningFog(double words, double sentences, double big)
	{
		double avgSentenceLength	= words / sentences;
		double percentBigWords		= (big / words) * 100;
		double gfReadingIndex		= (avgSentenceLength + percentBigWords) * 0.4;

		return gfReadingIndex;
	}

	/**
	* FleschRESCore
	*
	* This method should determine the Flesch Reading Ease Score given the 
	* number of words, sentences and syllables in a passage.
	*
	* @param 	words 		The number of words in the sample as a double
	* @param 	sentences 	The number of sentences in the sample as a double
	* @param 	syllables 	The number of syllables in the sample as a double
	* @return 	the Flesch Formula Reading Ease Score as a double
	*/
	public static double FleschRESCore(double words, double sentences, double syllables)
	{
		double avgSentenceLength 	= words / sentences;
		double fleschDoubleOne		= avgSentenceLength * 1.015;
		double fleschDoubleTwo		= (syllables / words) * 84.6;
		double readingEaseScore 	= 206.835 - (fleschDoubleOne + fleschDoubleTwo);

		return readingEaseScore;
	}

	/**
	* FleschGL
	*
	* This method should determine the Flesch Formula Grade Level given the
	* Flesch Reading Ease Score.
	*
	* @param 	readingEaseScore 	The Flesch Formula Reading Ease Score as a double
	* @return 	Flesch Grade Level as a String
	*/
	public static String FleschGL(double readingEaseScore)
	{
		String gradeLevel;

		if (readingEaseScore > 100)
			gradeLevel = "Not Defined";
		else if (readingEaseScore >= 90)
			gradeLevel = "4th to 5th Grade";
		else if (readingEaseScore >= 80)
			gradeLevel = "5th to 6th Grade";
		else if (readingEaseScore >= 70)
			gradeLevel = "7th Grade";
		else if (readingEaseScore >= 60)
			gradeLevel = "8th to 9th Grade";
		else if (readingEaseScore >= 50)
			gradeLevel = "High School";
		else if (readingEaseScore >= 30)
			gradeLevel = "College";
		else if (readingEaseScore >= 0)
			gradeLevel = "Post-Graduate";
		else
			return "Not Defined";

		return gradeLevel;
	}

	/**
	* displayResults
	*
	* This method should output the final results of the Gunning Fog Index,
	* the Flesch Reading Ease Score and the Flesch Grade Level.
	*
	* @param 	gunningFog 			The Gunning Fog Index as a double
	* @param 	readingEaseScore	The Flesch Formula Reading Ease Score as a double
	* @param 	gradeLevel			The Flesch Grade Level as a double
	*/
	public static void displayResults(double gunningFog, double readingEaseScore, String gradeLevel)
	{
		System.out.println();
		System.out.printf("The Gunning Fog Index is:  %.2f\n", gunningFog);
		System.out.printf("The Reading Ease Score is: %.2f\n", readingEaseScore);
		System.out.printf("The Flesch Grade Level is: %s\n", gradeLevel);
	}
}