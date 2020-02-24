// Ben Godwin
// UseRandom.java - Documentation Project #2
// I assert that the program I am submitting is the result of my own efforts

//
// ---------- PART A ---------------
//
// 1. Asserts that the Random class of the java.util package may be used in the program
// 2. nextInt()
// 3. Can be either positive or negative
// 4. Random generator = new Random()
// 5. num1 = generator.nextInt()
// 6. -2147483648 to 2147483647
// 7. num1 = generator.nextInt(10) + 1;

//
// ---------- PART B ---------------
//
// Specification - takes a number of seconds and returns the whole number of
// hours, minutes, and seconds. Minutes and seconds must be between 0 and 59
//
// ALGORITHM FOLLOWS
//
// Variables - totalSec, hour, min, seconds, remainingSeconds
// Input: Total Seconds - random integer from 1 to 10 multiplied by 20,000
// Output: Hours, Minutes, and Seconds that make up TotalSeconds
//
// Processing:
// 1. hours = total seconds / seconds in an hour
// 2. remaining seconds = total seconds % seconds in an hour
// 3. minutes = remaining seconds / seconds in a minute
// 4. seconds = remaining seconds % seconds in a minute
// 5. Print the output

import java.util.Random;

public class UseRandom {

    public static void main(String[] args) {
        int totalSec, hour, min, seconds, remainingSeconds; // defines variables listed in specification
        int totalHours, totalDays, remainingDays, years, weeks, days; // variables for challenge
        Random gen = new Random(); // defines a new object gen of class Random

        int num1 = gen.nextInt(); // generates a random int and assigns to num1
        System.out.println("Here is the number from the random number generator: " + num1);

        int num2 = gen.nextInt(10) + 1; // generates a random int from 1-10 and assigns to num2
        System.out.println("Here is a positive number in the range 1-10: " + num2);

        totalSec = num2 * 20_000; // multiply num2 by 20,000 and assign to totalSec
        System.out.println("Here is the Total Number of Seconds: " + totalSec);
        System.out.println();

        // 1. Calculate whole hours - seconds / seconds in an hour
        hour = totalSec / (60 * 60); // assign whole hours to hour

        // 2. Calculate remaining Seconds - seconds % seconds in an hour
        remainingSeconds = totalSec % (60 * 60); // assign remaining seconds to remainingSeconds

        // 3. Calculate whole minutes - remaining seconds / seconds in a minute
        min = remainingSeconds / 60; // assign to min, must be between 0 and 59

        // 4. Calculate seconds - remaining seconds % seconds in a minute
        seconds = remainingSeconds % 60; // assign to seconds, must be between 0 and 59

        // 5. Print hours, minutes, and seconds
        System.out.println("Hours = " + hour); // prints hours
        System.out.println("Minutes = " + min); // prints minutes
        System.out.println("Seconds = " + seconds); // prints seconds

        // Prints a box with Name, section number, and Lab 5
        printBox();

        // Challenge - multiply hours found and multiply by 50,000. Find years, weeks, and days
        totalHours = hour * 50_000;
        totalDays = totalHours / 24; // easier to work with since smallest output asked for is days

        // Calculate years, weeks, and days using the same algorithm
        years = totalDays / 365; // replace seconds in an hour with days in a year
        remainingDays = totalDays % 365; // replace seconds in an hour with days in a year
        weeks = remainingDays / 7; // replace seconds in a minute with days in a week
        days = remainingDays % 7; // replace seconds in a minute with days in a week

        // prints out a string showing the years, weeks, and days
        System.out.println(formatDays(years, weeks, days));
    }

    // takes in years, weeks, and days, and returns a formatted string
    public static String formatDays(int y, int w, int d) {
        String formattedDays = y + " years, " + w + " week"; // years and weeks
        formattedDays += w != 1 ? "s, " : ", "; // adds s to the word week if weeks != 1
        formattedDays += "and " + d + " day"; // adds days
        formattedDays += d != 1 ? "s." : "."; // adds s to the word day if days != 1
        return formattedDays;
    }

    public static void printBox() {
        System.out.println("\n*******************************************");
        System.out.println("*******************************************");
        System.out.println("**                                       **");
        System.out.println("**                Ben Godwin             **");
        System.out.println("**               CSC 1051-001            **");
        System.out.println("**                  Lab #5               **");
        System.out.println("**                                       **");
        System.out.println("*******************************************");
        System.out.println("*******************************************\n");
    }
}
