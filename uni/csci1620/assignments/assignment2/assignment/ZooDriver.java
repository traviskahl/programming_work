import Zoo.Animals.*;
import Zoo.Foods.*;
import java.util.Scanner;

public class ZooDriver
{
   static Scanner in = new Scanner(System.in);
   public static int menu(String... options)
   {
      int choice;
      for(int line = 0; line < options.length; line++)
         System.out.printf("%d. %s\n", line+1,options[line]);

      do
      {
         System.out.print("Enter Choice: ");
         choice = in.nextInt();
      }while(!(choice > 0 && choice <= options.length));

      return choice;
   }

   public static void main(String args[])
   {
      int playerChoice, daysLeft;
      Zoo myZoo = new Zoo();

      System.out.print("How many days would you like to play:\n");
      playerChoice = menu("5 days", "10 days", "20 days", "30 days");

      switch(playerChoice)
      {
         case 1:
            daysLeft = 5;
            break;
         case 2:
            daysLeft = 10;
            break;
         case 3:
            daysLeft = 20;
            break;
         default:
            daysLeft = 30;
      }

      for(; daysLeft > 0; daysLeft--)
      {
         System.out.printf("NEW DAY!\nYou have %d days left!\n", daysLeft);
         do
         {
            System.out.println(myZoo);
            playerChoice = menu("Feed", "Clean", "Swim with Dolphin", "Give Lion Ball", "End Day");

            if(playerChoice == 1)
            {
               System.out.println("Select Animal and Food:");

               if(myZoo.feedAnimal(menu("Elephant", "Dolphin", "Ostrich", "Lion")-1, menu("Seeds", "Meat", "Grass", "Fish", "Fruit")-1))
               {
                  System.out.println("Animal Fed!");
               }
               else
               {
                  System.out.println("Could not perform task!");
               }
            }
            else if(playerChoice == 2)
            {
               System.out.println("Select cage to clean:");
               if(myZoo.cleanCage(menu("Elephant", "Dolphin", "Ostrich", "Lion")-1))
               {
                  System.out.println("Cage cleaned!");
               }
               else
               {
                  System.out.println("Could not perform task!");
               }
            }
            else if(playerChoice == 3)
            {
               if(myZoo.swimWithDolphin())
               {
                  System.out.println("You swam with the Dolphin! It likes that!");
               }
               else
               {
                  System.out.println("Could not perform task!");
               }
            }
            else if(playerChoice == 4)
            {
               if(myZoo.giveLionBall())
               {
                  System.out.println("You gave the Lion a new Ball!");
               }
               else
               {
                  System.out.println("Could not perform task!");
               }
            }
            else
            {
               System.out.println("Ending day, Animals going to sleep!");
               System.out.printf("Your current score is %d.\n\n", myZoo.endDay());
            }
         }while(playerChoice != 5);
      }

      System.out.printf("All days finished!\nHere is your final score\n%s\n", myZoo);
   }
}