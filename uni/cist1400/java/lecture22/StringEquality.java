public class StringEquality {
    public static void main(String args[])
    {
        String a = new String("hola");
        String b = "whatever";
        String c = "Whatever";

        if (a.equals("hola"))
            System.out.println("a equals hola");
        else
            System.out.println("a does not equal hola");

        if (a == "hola")
            System.out.println("a is the same object as hola");
        else 
            System.out.println("a is not the same object as hola");

        if (b == "whatever")
            System.out.println("b is the same object as whatever");
        else
            System.out.println("b is not the same object as whatever");

        if (b.equalsIgnoreCase(c))
            System.out.printf("%s is equal to %s, case insensitive\n", b, c);
        else
            System.out.printf("%s is not equal to %s\n", b, c);
    }
}
