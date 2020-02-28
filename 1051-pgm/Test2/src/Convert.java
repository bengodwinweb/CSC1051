// Ben Godwin
// CSC 1051-001
// Convert.java - Test 2

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Convert {

    public static void main(String[] args) {

        // Declare variables from specification
        double c, f;
        int num, randNum;
        String mutation, message;

        // Declare objects
        Scanner scan = new Scanner(System.in);
        Random gen = new Random();
        DecimalFormat temperatureFormat = new DecimalFormat("0.00"); // formats a decimal to show two decimal places

        //
        // ------- PART 1 ---------
        //
        message = "Celsius and Fahrenheit are related.";
        mutation = message.toUpperCase();
        System.out.println("Mutated message is: " + mutation);

        //
        // ------- PART 2 ---------
        //
        randNum = gen.nextInt(6) + 5;
        System.out.println("\nRandom integer between 5 and 10 is: " + randNum);

        //
        // ------- PART 3 ---------
        //
        System.out.print("\nPlease enter an integer between 4 and 40: ");
        num = scan.nextInt();

        f = num * randNum;
        System.out.println("\nHere is your fahrenheit temperature: " + temperatureFormat.format(f));

        c = ((f - 32) * 5.0) / 9.0;
        System.out.println("Here is your celsius temperature: " + temperatureFormat.format(c));


    }
}
