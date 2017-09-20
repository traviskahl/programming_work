import java.util.Random;
public class Random1 {
    public static void main(String args[])
    {
        Random randomNumbers = new Random();
        int randValue = randomNumbers.nextInt();
        System.out.println("So random: "+ randValue);
    }
}
