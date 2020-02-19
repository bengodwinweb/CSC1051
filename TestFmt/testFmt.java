//testFmt
import java.util.Scanner;
import java.text.DecimalFormat;
//
public class testFmt
{
public static void main(String[] args)
{
double myNumber;
Scanner scan = new Scanner(System.in);
DecimalFormat fmt1=new DecimalFormat("0.###");
DecimalFormat fmt2=new DecimalFormat("0.000");
//
System.out.println("Please enter a decimal number");
myNumber = scan.nextDouble();
System.out.println(fmt1.format(myNumber));
System.out.println(fmt2.format(myNumber));


}
}