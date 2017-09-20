import java.util.Scanner;
public class SmallestOfThree {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int a, b, c;
        a = in.nextInt(); b = in.nextInt();
        c = in.nextInt();
        if (b < a)
            if (b < c)
                System.out.printf("%d is tiny!\n", b);
            else
                System.out.printf("%d is not tiny!\n", b);
        else
            System.out.printf("%d is not tiny! \n", b);
    }
}
