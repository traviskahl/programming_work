public class MultiDimArray2 {
    public static void main(String args[])
    {
       final int ROWS = 2;
       String[][] a = new String[ROWS][];
       a[0] = new String[5];
       a[1] = new String[6];

       a[0][0] = "Homer"; a[0][1] = "Marge"; a[0][2] = "Lisa";
       a[0][3] = "Bart"; a[0][4] = "Maggie"; a[1][0] = "Peter";
       a[1][1] = "Lois"; a[1][2] = "Chris"; a[1][3] = "Meg";
       a[1][4] = "Stewie"; a[1][5] = "Brian";

       for (int r = 0; r < a.length; r++)
           for (int c = 0; c < a[r].length; c++)
               System.out.printf("%10s", a[r][c]);
           System.out.println();
    }
}
