// Ben Godwin
// BMI.java
// I assert that the program I am submitting is the result of my own efforts

import java.text.DecimalFormat;
import java.util.Scanner;

public class BMI {

    public static void main(String[] args) {

        //
        // ---------- PART A -------------
        //

        String weightPhrase;
        String heightPhrase;
        int weight, height, iA, iB;
        double bmi, dC;

        Scanner scan = new Scanner(System.in);
        DecimalFormat fmt = new DecimalFormat("0.00");
        DecimalFormat fmt2 = new DecimalFormat("0.###");

        // Ask user for weight
        System.out.println("Input your weight by EXACTLY typing the following " +
                "sentence, replacing the Xs with your weight");
        System.out.println("My weight is XXX pounds.");

        // Get weight from user
        weightPhrase = scan.nextLine(); // assign user sentence to string
        weight = Integer.parseInt(weightPhrase.substring(13, 16)); // parse weight in lbs as an int

        // Ask user for height
        System.out.println("Input your height by EXACTLY typing the following " +
                "sentence, replacing the Ys with your height in inches");
        System.out.println("My height is YY inches.");

        // Get height from user
        heightPhrase = scan.nextLine(); // assign user sentence to string
        height = Integer.parseInt(heightPhrase.substring(13, 15)); // parse height in inches as an int


        //
        // ---------- PART B -------------
        //

        System.out.println("Your height is " + fmt.format(height) + " inches."); // print height
        System.out.println("Your height squared is " + fmt.format(Math.pow(height, 2))); // print height^2
        System.out.println("Your weight is " + fmt.format(weight) + " lbs."); // print weight

        // Calculate BMI using formula from directions
        bmi = (((double) weight) /  Math.pow(height, 2)) * 703;
        System.out.println("Your BMI is " + fmt2.format(bmi)); // print BMI


        //
        // ---------- PART C -------------
        //

        // Ask user for a positive integer and assign to iA
        System.out.println("Enter a positive integer");
        iA = scan.nextInt();
        // Print iA
        System.out.println("You entered " + iA);

        // Ask user for a negative integer and assign to iB
        System.out.println("Enter a negative integer");
        iB = scan.nextInt();
        // Print iB
        System.out.println("You entered " + iB);

        // Ask user for a positive decimal and assign to dC
        System.out.println("Enter a positive decimal");
        dC = scan.nextDouble();
        // Print dC
        System.out.println("You entered " + fmt.format(dC));

        // Print absolute value of iB
        System.out.println("The absolute value of iB is " + Math.abs(iB));
        // Print iA^5
        System.out.println("iA to the fifth power is " + Math.pow(iA, 5));
        // Print floor of dC
        System.out.println("The floor of dC is " + Math.floor(dC));


        //
        // ---------- PART D -------------
        //

        // Print box with name, section, and lab number
        printBox();
    }


    public static void printBox() {
        System.out.println("\n   *************************************");
        System.out.println(" *****************************************");
        System.out.println("**                                       **");
        System.out.println("**                Ben Godwin             **");
        System.out.println("**               CSC 1051-001            **");
        System.out.println("**                  Lab 6.0              **");
        System.out.println("**                                       **");
        System.out.println(" *****************************************");
        System.out.println("   *************************************\n");
    }
}
