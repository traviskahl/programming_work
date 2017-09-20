import java.util.Scanner;

public class q9 {
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        char hero;
        System.out.print("Enter a single character: ");
        hero = input.next().charAt(0);

        switch (hero)
        {
            case 'b' : case 'B' :
                System.out.println("BATMAN IS BEST");
                break;
            case 's' : case 'S' :
                System.out.println("SUPERMAN IS BEST");
                break;
            case 'w' : case 'W' :
                System.out.println("BLACK WIDOW IS BEST");
                break;
            default:
                System.out.println("ALAS ALL THE SUPER HEROES ARE GONE");
        }
    }
}
