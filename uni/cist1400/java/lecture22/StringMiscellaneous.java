public class StringMiscellaneous {
    public static void main(String args[])
    {
        String a = "hola";
        String b = "MUNDO";
        String c = "    Space, the Final Frontier   ";

        System.out.printf("a is %s\nb is %s\nc is %s\n", a, b, c);
        System.out.println("Replace l with L in a: " + a.replace('l', 'L'));

        System.out.println("a.toUpperCase is " + a.toUpperCase());
        System.out.println("b.toLowerCase is " + b.toLowerCase());
        System.out.println("c.trim is '" + c.trim() + "'");

        System.out.printf("int = %s\n", String.valueOf(56));
    }
}
