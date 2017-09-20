import NUMembers.UNO.UNOTypes.UNOStudent;
import NUMembers.UNL.UNLTypes.UNLStudent;
import NUMembers.UNO.UNOTypes.UNOStaff;
import NUMembers.UNL.UNLTypes.UNLStaff;
import NUMembers.UNO.UNOTypes.UNOFaculty;
import NUMembers.UNL.UNLTypes.UNLFaculty;
public class UniversityNebraskaDriver
{
   public static void main(String args[])
   {
      //UNOStudent test
      UNOStudent unoStudent1 = new UNOStudent("Kitty Pryde", 12345678, "kpryde", 23500, 45, 3.4);
      UNOStudent unoStudent2 = new UNOStudent("Piotr Rasputin", 1234567, null, -500, -10, -2.3);
      String unoStudent1Correct = "Name: Kitty Pryde\nNUID: 12345678\nCampus Location: Omaha\nNetID: kpryde\nBalance: $23500.00\nCredits: 45\nGPA: 3.40";
      String unoStudent2Correct = "Name: Piotr Rasputin\nNUID: NOT SET\nCampus Location: Omaha\nNetID: NOT SET\nBalance: $0.00\nCredits: 0\nGPA: 0.00";

      System.out.printf("%s\n\n", unoStudent1);

      if(unoStudent1.toString().compareTo(unoStudent1Correct) == 0)
         System.out.println("UNO STUDENT 1 TEST OK\n");
      else
         System.out.printf("UNO STUDENT 1 TEST INCORRECT\nSHOULD BE:\n%s\n\n", unoStudent1Correct);

      System.out.printf("%s\n\n", unoStudent2);

      if(unoStudent2.toString().compareTo(unoStudent2Correct) == 0)
         System.out.println("UNO STUDENT 2 TEST OK\n");
      else
         System.out.printf("UNO STUDENT 2 TEST INCORRECT\nSHOULD BE:\n%s\n\n", unoStudent2Correct);


      //UNLStudent test
      UNLStudent unlStudent1 = new UNLStudent("Cain Marko", 68345919, "cain.marko", 6459.21, 21, 2.0);
      UNLStudent unlStudent2 = new UNLStudent("Carl Lykos", 1234567890, null, -1, -1, -0.1);
      String unlStudent1Correct = "Name: Cain Marko\nNUID: 68345919\nCampus Location: Lincoln\nMyUNLID: cain.marko\nBalance: $6459.21\nCredits: 21\nGPA: 2.00";

      String unlStudent2Correct = "Name: Carl Lykos\nNUID: NOT SET\nCampus Location: Lincoln\nMyUNLID: NOT SET\nBalance: $0.00\nCredits: 0\nGPA: 0.00";

      System.out.printf("%s\n\n", unlStudent1);

      if(unlStudent1.toString().compareTo(unlStudent1Correct) == 0)
         System.out.println("UNL STUDENT 1 TEST OK\n");
      else
         System.out.printf("UNL STUDENT 1 TEST INCORRECT\nSHOULD BE:\n%s\n\n", unlStudent1Correct);

      System.out.printf("%s\n\n", unlStudent2);

      if(unlStudent2.toString().compareTo(unlStudent2Correct) == 0)
         System.out.println("UNL STUDENT 2 TEST OK\n");
      else
         System.out.printf("UNL STUDENT 2 TEST INCORRECT\nSHOULD BE:\n%s\n\n", unlStudent2Correct);

      //UNOStaff Test
      UNOStaff unoStaff1 = new UNOStaff("Scott Summers", 10000000, "ssummers", "Receptionist", 13.50);
      UNOStaff unoStaff2 = new UNOStaff("Henry McCoy", 9999999, null, null, 8.99);
      String unoStaff1Correct = "Name: Scott Summers\nNUID: 10000000\nCampus Location: Omaha\nNetID: ssummers\nPosition: Receptionist\nWage: $13.50";
      String unoStaff2Correct = "Name: Henry McCoy\nNUID: NOT SET\nCampus Location: Omaha\nNetID: NOT SET\nPosition: NOT SET\nWage: NOT SET";

      System.out.printf("%s\n\n", unoStaff1);

      if(unoStaff1.toString().compareTo(unoStaff1Correct) == 0)
         System.out.println("UNO STAFF 1 TEST OK\n");
      else
         System.out.printf("UNO STAFF 1 TEST INCORRECT\nSHOULD BE:\n%s\n\n", unoStaff1Correct);

      System.out.printf("%s\n\n", unoStaff2);

      if(unoStaff2.toString().compareTo(unoStaff2Correct) == 0)
         System.out.println("UNO STAFF 2 TEST OK\n");
      else
         System.out.printf("UNO STAFF 2 TEST INCORRECT\nSHOULD BE:\n%s\n\n", unoStaff2Correct);

      //UNLStaff Test
      UNLStaff unlStaff1 = new UNLStaff("Victor Creed", 99999999, "victor.creed", "Yard Services", 9.00);
      UNLStaff unlStaff2 = new UNLStaff("Mortimer Toynbee", 100000000, null, null, -10.00);
      String unlStaff1Correct = "Name: Victor Creed\nNUID: 99999999\nCampus Location: Lincoln\nMyUNLID: victor.creed\nPosition: Yard Services\nWage: $9.00";

      String unlStaff2Correct = "Name: Mortimer Toynbee\nNUID: NOT SET\nCampus Location: Lincoln\nMyUNLID: NOT SET\nPosition: NOT SET\nWage: NOT SET";


      System.out.printf("%s\n\n", unlStaff1);

      if(unlStaff1.toString().compareTo(unlStaff1Correct) == 0)
         System.out.println("UNL STAFF 1 TEST OK\n");
      else
         System.out.printf("UNL STAFF 1 TEST INCORRECT\nSHOULD BE:\n%s\n\n", unlStaff1Correct);

      System.out.printf("%s\n\n", unlStaff2);

      if(unlStaff2.toString().compareTo(unlStaff2Correct) == 0)
         System.out.println("UNL STAFF 2 TEST OK\n");
      else
         System.out.printf("UNL STAFF 2 TEST INCORRECT\nSHOULD BE:\n%s\n\n", unlStaff2Correct);

      //UNOFaculty Test
      UNOFaculty unoFaculty1 = new UNOFaculty("Charles Xavier", 58355934, "cxavier", "Computer Science", "Professor", 700000.00);
      UNOFaculty unoFaculty2 = new UNOFaculty("Bobby Drake", -47586650, null, null, null,  23659.99);
      String unoFaculty1Correct = "Name: Charles Xavier\nNUID: 58355934\nCampus Location: Omaha\nNetID: cxavier\nDepartment: Computer Science\nTitle: Professor\nSalary: $700000.00";

      String unoFaculty2Correct = "Name: Bobby Drake\nNUID: NOT SET\nCampus Location: Omaha\nNetID: NOT SET\nDepartment: NOT SET\nTitle: NOT SET\nSalary: NOT SET";

      System.out.printf("%s\n\n", unoFaculty1);

      if(unoFaculty1.toString().compareTo(unoFaculty1Correct) == 0)
         System.out.println("UNO FACULTY 1 TEST OK\n");
      else
         System.out.printf("UNO FACULTY 1 TEST INCORRECT\nSHOULD BE:\n%s\n\n", unoFaculty1Correct);

      System.out.printf("%s\n\n", unoFaculty2);

      if(unoFaculty2.toString().compareTo(unoFaculty2Correct) == 0)
         System.out.println("UNO FACULTY 2 TEST OK\n");
      else
         System.out.printf("UNO FACULTY 2 TEST INCORRECT\nSHOULD BE:\n%s\n\n", unoFaculty2Correct);

      //UNLFaculty Test
      UNLFaculty unlFaculty1 = new UNLFaculty("Erik Lehnsherr", 98658472, "erik.lehnsherr", "History", "Assistant Professor", 23660.00);
      UNLFaculty unlFaculty2 = new UNLFaculty("Arkady Rossovich", 0, null, null, null,  -30000.00);
      String unlFaculty1Correct = "Name: Erik Lehnsherr\nNUID: 98658472\nCampus Location: Lincoln\nMyUNLID: erik.lehnsherr\nDepartment: History\nTitle: Assistant Professor\nSalary: $23660.00";

      String unlFaculty2Correct = "Name: Arkady Rossovich\nNUID: NOT SET\nCampus Location: Lincoln\nMyUNLID: NOT SET\nDepartment: NOT SET\nTitle: NOT SET\nSalary: NOT SET";

      System.out.printf("%s\n\n", unlFaculty1);

      if(unlFaculty1.toString().compareTo(unlFaculty1Correct) == 0)
         System.out.println("UNL FACULTY 1 TEST OK\n");
      else
         System.out.printf("UNL FACULTY 1 TEST INCORRECT\nSHOULD BE:\n%s\n\n", unlFaculty1Correct);

      System.out.printf("%s\n\n", unlFaculty2);

      if(unlFaculty2.toString().compareTo(unlFaculty2Correct) == 0)
         System.out.println("UNL FACULTY 2 TEST OK\n");
      else
         System.out.printf("UNL FACULTY 2 TEST INCORRECT\nSHOULD BE:\n%s\n\n", unlFaculty2Correct);

   }//END MAIN
}//END CLASS