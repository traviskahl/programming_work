public class MultiDimArray3 {
    public static void main(String args[])
    {
        int[][] x = { {5,8}, {2,4} };
        int[][] y = { {1,1,1,1}, {3,4}, {10,20,30,40,50} };
        printArray("This is array x: ", x);
        printArray("This is array y: ", y);
    }

    public static void printArray(String label, int foo[][])
    {
        for (int r = 0; r < foo.length; r++)
        {
            for (int c = 0; c < foo[r].length; c++)
            {
                System.out.printf("%8d", foo[r][c]);
            }
            System.out.println();
        }
    }
}
