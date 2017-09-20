public class StringBasics {
    public static void main(String args[])
    {
        char[] greeting = { 'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd' };
        String a = new String("Greetings");
        String b = new String();
        String c = new String(a);
        String d = new String(greeting);
        String e = new String(greeting, 6, 5);

        System.out.printf("a = %s\nb = %s\nc = %s\nd = %s\ne = %s\n",
            a, b, c, d, e);
    }
}
