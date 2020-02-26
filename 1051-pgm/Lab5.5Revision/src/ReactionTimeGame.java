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

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class ReactionTimeGame {

    public static void main(String[] args) {
        // Declare variables from algorithm
        String name, response;
        int first, second, answer, number;
        long startTime, endTime, reactionTime;
        double seconds;

        Scanner scan = new Scanner(System.in);
        Random gen = new Random();
        DecimalFormat fmtSeconds = new DecimalFormat("#,##0.###");

        System.out.println("Enter your name:");
        name = scan.nextLine();

        System.out.println("\nHello " + name + ", answer the question as fast as you can!" +
                "\nHit <ENTER> when ready for the question");
        scan.nextLine();

        first = gen.nextInt(99);
        second = gen.nextInt(99);
        answer = first + second;

        startTime = System.currentTimeMillis();

        System.out.print(first + " + " + second + " = ");
        response = scan.nextLine();

        endTime = System.currentTimeMillis();
        reactionTime = endTime - startTime;

        number = Integer.parseInt(response);

        if (number == answer) {
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect. Correct answer is " + answer);
        }

        seconds = ((double) reactionTime) / 1000;

        System.out.println("Reaction time was " + fmtSeconds.format(seconds));
        System.out.println("Thanks, " + name + "! Goodbye\n");

        //
        // ---- CHALLENGE 1 ----
        //

        int again;

        System.out.println("STARTING CHALLENGE 1");
        System.out.println("Would you like to repeat the game? Enter 1 for yes or 2 for no");
        again = scan.nextInt();
        scan.nextLine();

        while (again == 1) {
            System.out.println("\nHit <ENTER> when ready for the question");
            scan.nextLine();

            first = gen.nextInt(99);
            second = gen.nextInt(99);
            answer = first + second;

            startTime = System.currentTimeMillis();

            System.out.print(first + " + " + second + " = ");
            response = scan.nextLine();

            endTime = System.currentTimeMillis();
            reactionTime = endTime - startTime;

            number = Integer.parseInt(response);

            if (number == answer) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect. Correct answer is " + answer);
            }

            seconds = ((double) reactionTime) / 1000;
            System.out.println("Reaction time was " + fmtSeconds.format(seconds));
            System.out.println("\nWould you like to repeat the game? Enter 1 for yes or 2 for no");

            again = scan.nextInt();
            scan.nextLine();
        }

        System.out.println("Thanks, " + name + "! Goodbye\n");

        //
        // ---- CHALLENGE 2 -----
        //

        int userMaxValue;
        long answer2, number2;

        System.out.println("STARTING CHALLENGE 2");

        System.out.println("Would you like to repeat the game? Enter 1 for yes or 2 for no");
        again = scan.nextInt();
        scan.nextLine();

        while (again == 1) {
            System.out.println("\nEnter your Maximum Value for randomly generated numbers");
            userMaxValue = scan.nextInt();
            scan.nextLine();

            System.out.println("\nHit <ENTER> when ready for the question");
            scan.nextLine();

            first = gen.nextInt(99);
            second = gen.nextInt(99);
            answer = first + second;

            first = gen.nextInt(userMaxValue + 1);
            second = gen.nextInt(userMaxValue + 1);
            answer2 = first + second;

            startTime = System.currentTimeMillis();

            System.out.print(first + " + " + second + " = ");
            response = scan.nextLine();

            endTime = System.currentTimeMillis();
            reactionTime = endTime - startTime;

            number2 = Integer.parseInt(response);

            if (number2 == answer2) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect. Correct answer is " + answer2);
            }

            seconds = ((double) reactionTime) / 1000;
            System.out.println("Reaction time was " + fmtSeconds.format(seconds));
            System.out.println("\nWould you like to repeat the game? Enter 1 for yes or 2 for no");

            again = scan.nextInt();
            scan.nextLine();
        }

        System.out.println("Thanks, " + name + "! Goodbye\n");

        printBox();
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
