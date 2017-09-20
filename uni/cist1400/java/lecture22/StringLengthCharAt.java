public class StringLengthCharAt {
    public static void main(String args[])
    {
        String abc = "Hola mundo";

        System.out.printf("abc is %s\n", abc);

        System.out.printf("Length of abc is %d\n", abc.length());

        System.out.print("abc reversed is ");
        for (int pos = abc.length() - 1; pos >= 0; pos--)
            System.out.printf("%c", abc.charAt(pos));

        System.out.println();
    }
}
