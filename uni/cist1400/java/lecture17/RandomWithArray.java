import java.util.Random;
public class RandomWithArray {
    public static void main(String args[])
    {
        Random randomNumbers = new Random();
        final int ROLLS = 1000000000;
        final int OPTIONS = 10;
        int f[] = new int [OPTIONS + 1];

        for (int roll = 1; roll < ROLLS; roll++)
        {
            int face = 1 + randomNumbers.nextInt(OPTIONS);
            f[face]++;
        }

        System.out.printf("%4s%10s%10s\n", "Face", "Freq", "Percent");
        for (int x = 1; x < f.length; x++)
        {
            System.out.printf("%4d%10d%10.2f\n", x, f[x], ((double)f[x]/ROLLS)*100);
        }
    }
}
