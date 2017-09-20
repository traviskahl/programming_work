import java.util.Scanner;
public class switchDemo1 {
    public static void main(String args[])
    {
        Scanner i = new Scanner(System.in);

        System.out.print("Enter a character to test: ");
        char ch;
        ch = i.next().charAt(0);

        switch (ch)
        {
            case 'a': case 'A':
            case 'e': case 'E':
            case 'i': case 'I':
            case 'o': case 'O':
            case 'u': case 'U':
                System.out.printf("%s is a vowel\n", ch);
                break;
            default:
                System.out.printf("%s is not a vowel\n", ch);
        }
    }
}
