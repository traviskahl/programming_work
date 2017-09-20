// Name:        Travis Kahl
// Class:       1400-850
// Program:     4
// Due Date:    September 18th
// Colleagues:  N/A

import java.util.Scanner;
public class tdkahl_ROT13   {
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a character to ROT13: ");
        char chInput = input.next().charAt(0);
        char chOutput = '*'; // I did this because putting a printf in every case statement would have been a lot of unneccesary work. Instead, there will be an
                             // if statement at the end of the program that tests if the chOutput is not '*'. If chOutput != '*', then the program will print the
                             // character desired. Otherwise, it will print "CANNOT CONVERT".

        switch (chInput) { 
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
        }
        // here is the if statement in question
        if (chOutput != '*') // '*' was the flag character I initialized chOutput as
            System.out.printf("\n%c:%c\n", chInput, chOutput);
        else
            System.out.println("\nCANNOT CONVERT");

    }
}
