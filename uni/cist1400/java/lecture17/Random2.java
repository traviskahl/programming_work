import java.util.Random;
public class Random2 {
    public static void main(String args[])
    {
        Random randomNumbers = new Random();
        int randomValue = randomNumbers.nextInt();
        if (randomValue < 0)
            System.out.println("It was heads!");
        else
            System.out.println("It was tails!");
    }
}
