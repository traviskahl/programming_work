public class StringSubstring {
    public static void main(String args[])
    {
        String letters = "abcdefghijklmabcdefghijklm";

        System.out.println("Substring from index 20 to the end is " + letters.substring(20));

        System.out.println("Substring of 3 up to but not including 6 is " + letters.substring(3, 6));
    }
}
