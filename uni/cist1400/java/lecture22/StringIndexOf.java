public class StringIndexOf {
    public static void main(String args[])
    {
        String letters = "abcdefghijklmabcdefghijklm";

        System.out.printf("'c' is at index %d\n", letters.indexOf('c'));
        System.out.printf("'c' is at index %d\n", letters.indexOf('c', 1));
        System.out.printf("'z' is at index %d\n", letters.indexOf('z'));

        System.out.printf("Last 'c' is in %d\n", letters.lastIndexOf('c'));

        System.out.printf("\"def\" is in pos %d\n", letters.indexOf("def"));
        System.out.printf("\"def\" is in pos %d\n", letters.indexOf("def", 7));

        System.out.printf("Last \"def\" is %d\n", letters.lastIndexOf("def"));
        System.out.printf("Last \"yyz\" is %d\n", letters.lastIndexOf("yyz"));
    }
}
