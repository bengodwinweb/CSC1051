//Test Integer Class
import java.util.Scanner;

public class TestInt
{
   public static void main (String[] args)
   {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter an integer");
      String snumber = scan.nextLine();
      System.out.println (snumber + 10); 
      int number = Integer.parseInt(snumber);
      System.out.println (number + 10);
   }
}
