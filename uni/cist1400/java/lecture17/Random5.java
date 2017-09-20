import java.util.Random;
public class Random5 {
    public static void main(String args[])
    {
        int frequency1 = 0;
        int frequency2 = 0;
        int frequency3 = 0;
        int frequency4 = 0;
        int frequency5 = 0;
        int frequency6 = 0;
        Random randomNumbers = new Random();

        for (int roll = 1; roll <= 6000; roll++)
        {
            int dieRoll = 1 + randomNumbers.nextInt(6);
            switch(dieRoll)
            {
                case 1: frequency1++; break;
                case 2: frequency2++; break;
                case 3: frequency3++; break;
                case 4: frequency4++; break;
                case 5: frequency5++; break;
                case 6: frequency6++; break;
            }
        }
        System.out.printf("%4s%10s\n", "Face", "Freq");

        System.out.printf("%4d%10d\n", 1, frequency1);
        System.out.printf("%4d%10d\n", 2, frequency2);
        System.out.printf("%4d%10d\n", 3, frequency3);
        System.out.printf("%4d%10d\n", 4, frequency4);
        System.out.printf("%4d%10d\n", 5, frequency5);
        System.out.printf("%4d%10d\n", 6, frequency6);

    }
}
