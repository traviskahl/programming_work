// Name:        Travis Kahl
// Class:       1400-850
// Program:     6
// Due Date:    October 2nd
// Colleagues:  N/A

import java.util.Scanner;
public class tdkahl_Sentence {
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a sentence to ROT13: ");
        String strInput = input.nextLine();
        
        int length = strInput.length();
        int counter = 0;
        int displayedLetters = 0;

        System.out.println("ORIG:  " + strInput);
        System.out.print("ROT13: ");

        while (counter <= length - 1)
        {
            char currentChar = strInput.charAt(counter);
            char chOutput = '!';

            switch (currentChar) {

                case 'a': case 'A':
                    chOutput = 'N';
                    break;
                case 'b': case 'B':
                    chOutput = 'O';
                    break;
                case 'c': case 'C':
                    chOutput = 'P';
                    break;
                case 'd': case 'D':
                    chOutput = 'Q';
                    break;
                case 'e': case 'E':
                    chOutput = 'R';
                    break;
                case 'f': case 'F':
                    chOutput = 'S';
                    break;
                case 'g': case 'G':
                    chOutput = 'T';
                    break;
                case 'h': case 'H':
                    chOutput = 'U';
                    break;
                case 'i': case 'I':
                    chOutput = 'V';
                    break;
                case 'j': case 'J':
                    chOutput = 'W';
                    break;
                case 'k': case 'K':
                    chOutput = 'X';
                    break;
                case 'l': case 'L':
                    chOutput = 'Y';
                    break;
                case 'm': case 'M':
                    chOutput = 'Z';
                    break;
                case 'n': case 'N':
                    chOutput = 'A';
                    break;
                case 'o': case 'O':
                    chOutput = 'B';
                    break;
                case 'p': case 'P':
                    chOutput = 'C';
                    break;
                case 'q': case 'Q':
                    chOutput = 'D';
                    break;
                case 'r': case 'R':
                    chOutput = 'E';
                    break;
                case 's': case 'S':
                    chOutput = 'F';
                    break;
                case 't': case 'T':
                    chOutput = 'G';
                    break;
                case 'u': case 'U':
                    chOutput = 'H';
                    break;
                case 'v': case 'V':
                    chOutput = 'I';
                    break;
                case 'w': case 'W':
                    chOutput = 'J';
                    break;
                case 'x': case 'X':
                    chOutput = 'K';
                    break;
                case 'y': case 'Y':
                    chOutput = 'L';
                    break;
                case 'z': case 'Z':
                    chOutput = 'M';
                    break;

                default:
                    break;
            }

            if (chOutput != '!')
            {
                System.out.print(chOutput);
                displayedLetters++;
            }

            if (displayedLetters % 5 == 0)
                System.out.print(' ');

            counter++;

        }

        System.out.print('\n'); // print a newline to make it prettier

    }
}
