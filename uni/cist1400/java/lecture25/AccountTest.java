import java.util.Scanner;
public class AccountTest {
    public static void main(String[] args) {
        Account a1 = new Account(50.00);
        Account a2 = new Account(-7.53);
        System.out.printf("a1 balance: $%.2f\n", a1.getBalance());
        System.out.printf("a2 balance: $%.2f\n", a2.getBalance());

        Scanner input = new Scanner(System.in);
        System.out.print("Enter deposit for a1: ");
        double deposit = input.nextDouble();
        System.out.printf("Adding $%.2f to a1\n\n", deposit);
        a1.credit(deposit);
    }
}
