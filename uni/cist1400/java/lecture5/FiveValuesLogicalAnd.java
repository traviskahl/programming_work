import java.util.Scanner;
public class FiveValuesLogicalAnd {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int a, b, c, d, e;
        a = in.nextInt(); b = in.nextInt();
        c = in.nextInt(); d = in.nextInt();
        e = in.nextInt();

        if
        (
            (a > -27) &&
            (b > -27) &&
            (c > -27) &&
            (d > -27) &&
            (e > -27)
        )
        {
            System.out.println("All greater than -27!");
        }
        else
        {
            System.out.println("Not greater than -27!");
        }
    }
}
