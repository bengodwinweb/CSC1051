// Ben Godwin
// Lab5.5 - ReactionTimeGame.java
// I assert that the program I am submitting is the result of my own efforts
// Measures response time for an addition problem

// Algorithm Follows
//
// Specification - measures response time for an addition problem
// Variables - name, first, second, startTime, endTime, answer, reactionTime
// Input - name, answer to addition problem
// Output - correct or incorrect, reaction time
//
// Processing
// 1. Input name
// 2. Print personalized welcome message and instructions
// 3. first = random int
// 4. second = random int
// 5. startTime = current time
// 6. print question asking for sum, using first and second
// 7. input answer
// 8. endTime = current time
// 9. reactionTime = endTime - startTime
// 10. print outcome as "Correct" or "Incorrect"
// 11. print goodbye

import java.util.Scanner;
import java.util.Random;
import java.text.NumberFormat;

public class ReactionTimeGame {
    public enum MODE { // enum to define what difficulty player is using
        EASY(10), // integers between 0 - 9
        MEDIUM(100), // integers between 0 - 99
        HARD(1000), // integers between 0 - 999
        EXTREME(Integer.MAX_VALUE); // any integer greater than or equal to 0

        private final int value;

        MODE(final int value) { // constructor, sets value equal to what is specified above
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        // Define variables from algorithm
        int first, second;
        long answer, startTime, endTime, reactionTime; // answer must be long for extreme mode
        String name, result;

        Scanner scan = new Scanner(System.in);
        Random gen = new Random();
        NumberFormat myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true); // can use myFormat to format a number with commas

        // 1. Input Name
        System.out.println("Enter your name:");
        name = scan.nextLine();

        // 2. Print personalized welcome message and instructions
        System.out.println("\nHello " + name + ",\nAnswer the questions as fast as you can!\n");

        boolean quit = false; // flag to break while loop, defaulted to false
        MODE difficulty = MODE.MEDIUM; // sets default difficulty to MEDIUM (randoms are 0 - 99)
        while(!quit) {
            printMenu(); // separate function so it's easy to find and change
            if (scan.hasNextInt()) { // user input was an int, proceed to appropriate menu option
                switch (scan.nextInt()) {
                    case 0: // user wants to quit
                        quit = true;
                        // 11. Print Goodbye
                        System.out.println("\nThanks " + name + ", Goodbye!");
                        break;
                    case 1: // user wants to play a round
                        // 3. first = random int
                        first = gen.nextInt(difficulty.getValue()); // generate a random int from 0 - difficulty
                        // 4. second = random int
                        second = gen.nextInt(difficulty.getValue()); // generate a random int from 0 - difficulty
                        // 5. startTime = current time
                        startTime = System.currentTimeMillis(); // gets current time in milliseconds from system
                        // 6. Print question asking for sum, using first and second
                        System.out.println("\n" + myFormat.format(first) +
                                " + " + myFormat.format(second) + " =");
                        // 7. input answer
                        if (scan.hasNextLong()) { // checks that user input for answer is a valid integer
                            answer = scan.nextLong(); // has to use long because of extreme mode
                            // 8. endTime = current time
                            endTime = System.currentTimeMillis();
                            // 9. reactionTime = endTime - startTime
                            reactionTime = endTime - startTime;
                            // 10. print outcome as "Correct" or "Incorrect"
                            // assigns "Correct" or "Incorrect" to result based on answer
                            result = answer == first + second ? "Correct!" : "Incorrect.";
                            System.out.println(result + " Reaction Time was " + millisToTime(reactionTime));
                        } else { // user input was not valid
                            System.out.println("Invalid input, must be an integer");
                            scan.nextLine(); // avoids accidental loops
                        }
                        break;
                    case 2:
                        difficulty = changeDifficulty(difficulty, scan);
                        System.out.println("Mode is set to " + difficulty);
                        break;
                    default: // user input was an int, but not a menu option
                        System.out.println("Invalid choice");
                        scan.nextLine(); // avoids accidental loops
                        break;
                }
            } else { // user input was not an int
                System.out.println("Invalid choice");
            }
            scan.nextLine(); // avoids accidental loops
            System.out.println();
        }

        scan.close();

        printBox();
    }

    // Print the menu options for the game
    public static void printMenu() {
        System.out.println("Press \"1\" to play, \"2\" to change difficulty, or \"0\" to quit");
    }

    // changes difficulty of game based on user input
    public static MODE changeDifficulty(MODE difficulty, Scanner scan) {
        System.out.println("\nCurrent mode is: " + difficulty + ", Choose your mode:");
        System.out.println("\tPress \"1\" for EASY");
        System.out.println("\tPress \"2\" for MEDIUM");
        System.out.println("\tPress \"3\" for HARD");
        System.out.println("\tPress \"4\" for EXTREME");

        if (scan.hasNextInt()) { // checks if user input was an int
            switch (scan.nextInt()) {
                case 1:
                    return MODE.EASY;
                case 2:
                    return MODE.MEDIUM;
                case 3:
                    return MODE.HARD;
                case 4:
                    return MODE.EXTREME;
                default: // user input was an int but not a menu option
                    System.out.println("Invalid selection");
                    break;
            }
        } else { // user input not an int
            System.out.println("Invalid selection");
            scan.nextLine(); // avoids unexpected behavior from while loop
        }

        return difficulty; // if input was invalid, keep same difficulty by returning parameter
    }

    // takes in milliseconds and returns a human readable string of secs.millis
    public static String millisToTime(long m) {
        int secs, mils;
        secs = (int) (m / 1000);
        mils = (int) (m % 1000);

        return secs + "." + mils + " seconds.";
    }

    // Prints a box with name, section, and lab #
    public static void printBox() {
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        System.out.println("**                                       **");
        System.out.println("**                Ben Godwin             **");
        System.out.println("**               CSC 1051-001            **");
        System.out.println("**                 Lab #5.5              **");
        System.out.println("**                                       **");
        System.out.println("*******************************************");
        System.out.println("*******************************************");
    }
}
