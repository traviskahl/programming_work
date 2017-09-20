import java.util.Scanner;
public class switchDemo4 {
    public static void main(String args[])
    {
        int left, right, result;
        char operator;
        Scanner i = new Scanner(System.in);

        System.out.print("Enter a simple expression: ");
        left = i.nextInt();
        operator = i.next().charAt(0);
        right = i.nextInt();

        System.out.printf("%d %s %d = ", left, operator, right);
        switch (operator)
        {
            case '+'    :
                System.out.printf("%d\n", left+right);
                break;
            case '-'    :
                System.out.printf("%d\n", left-right);
                break;
            case '*'    :
                System.out.printf("%d\n", left*right);
                break;
            case '/'    :
                System.out.printf("%d\n", left/right);
                break;
            default     :
                System.out.println("Unknown Value");

        }
    }
}
