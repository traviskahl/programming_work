import java.util.Random;
public class Random4 {
    public static void main(String args[])
    {
        Random randomNumbers = new Random();
        int dieRoll = 1 + randomNumbers.nextInt(6);
        System.out.println("You rolled a " + dieRoll);
    }
}
