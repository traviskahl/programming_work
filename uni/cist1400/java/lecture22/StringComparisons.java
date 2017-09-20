public class StringComparisons {
    public static void main(String args[])
    {
        String a = new String("hola");
        String b = new String("holla");
        String c = new String("Java Programming");
        String d = new String("java programming");

        System.out.printf("%s compared to %s results %d\n",
            a, b, a.compareTo(b));
        System.out.printf("%s compared to %s results %d\n",
            a, b, b.compareTo(a));

        if (c.compareTo(d) < 0)
            System.out.printf("%s comes before %s\n", c, d);
        else
            System.out.printf("%s comes before %s\n", d, c);
    }
}
