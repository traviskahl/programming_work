public class MultiDimArray {
    public static void main(String args[])
    {
        final int ROWS = 3;
        final int COLUMNS = 4;

        int[][] a = new int[ROWS][COLUMNS];

        a[1][2] = 25; a[1][2]++; a[1][0] = 56;

        a[1][2] += a[1][0];

        for (int r = 0; r < a.length; r++)
        {
            for (int c = 0; c < a[r].length; c++)
            {
                System.out.printf("%5d", a[r][c]);
            }
            System.out.println();
        }
    }
}
