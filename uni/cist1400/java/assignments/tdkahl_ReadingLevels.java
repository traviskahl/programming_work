// Name:        Travis Kahl
// Class:       1400-850
// Program:     3
// Due Date:    September 11th
// Colleagues:  N/A

import java.util.Scanner;
public class tdkahl_ReadingLevels {
    public static void main(String args[])
    {
        // Here is where I get the variables I will need
        double numWords, numSentences, numBigWords, numSyllables;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of words:     ");
        numWords = input.nextDouble();

        System.out.print("Enter the number of sentences: ");
        numSentences = input.nextInt();

        System.out.print("Enter the number of big words: ");
        numBigWords = input.nextDouble();

        System.out.print("Enter the number of syllables: ");
        numSyllables = input.nextDouble();

        // this finds the Gunning Fog Index
        double avgSentenceLength = (numWords / numSentences);
        double percentBigWords = (numBigWords / numWords) * 100;

        double gfReadingLevel = (avgSentenceLength + percentBigWords) * 0.4;
        System.out.printf("\nThe Gunning Fog Index is:  %.2f\n", gfReadingLevel);

        // this finds the Flesch score
        double fleschDoubleOne = avgSentenceLength * 1.015;
        double fleschDoubleTwo = (numSyllables / numWords) * 84.6;

        double readingEaseScore = 206.835 - (fleschDoubleOne + fleschDoubleTwo);
        System.out.printf("The Reading Ease Score is: %.2f\n", readingEaseScore);

        // this finds the reading level based on the Flesch score
        System.out.print("The Flesch Grade Level is: ");

        if (readingEaseScore > 100)
            System.out.println("Undefined");
        else if (readingEaseScore >= 90)
            System.out.println("4th to 5th Grade");
        else if (readingEaseScore >= 80)
            System.out.println("5th to 6th Grade");
        else if (readingEaseScore >= 70)
            System.out.println("7th Grade");
        else if (readingEaseScore >= 60)
            System.out.println("8th to 9th Grade");
        else if (readingEaseScore >= 50)
            System.out.println("High School.");
        else if (readingEaseScore >= 30)
            System.out.println("College");
        else if (readingEaseScore >= 0)
            System.out.println("Post-Graduate");
        else
            System.out.println("Undefined");
    }
}
