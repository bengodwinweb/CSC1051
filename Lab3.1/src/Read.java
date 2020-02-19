// Benjamin Godwin
// Read.java
// I assert that the program I am submitting is the result of my own efforts.

// Specification - program that reads different types of input from the user

// Variables: messageOne, messageTwo, myInt, myDouble, doubleTotal, floated, truncated

// Processing:
// 1. Instantiate Scanner object named scan
// 2. Ask user to enter a question and store it in messageOne, print messageOne
// 3. Ask user to enter one word and store it in messageTwo, print messageTwo
// 4. Ask user for an integer and store it in myInt, print myInt
// 5. Ask user for a double and store it in myDouble, print myDouble
// 6. Store the product of myInt and myDouble in doubleTotal, print doubleTotal
// 7. Cast myInt to a double and store in floated, print floated
// 8. Cast myDouble to an int and store in truncated, print truncated
// 9. Print a box with author name, course-section, and project number
// 10. Ask user to enter a url and print each part (use / to separate) on a separate line

import java.util.Scanner;

public class Read {

    // ----------------------------------------------
    // Exercises on reading user input
    // ----------------------------------------------
    public static void main(String[] args) {
        String messageOne, messageTwo;
        int myInt, truncated;
        double myDouble, doubleTotal, floated;

        Scanner scan = new Scanner(System.in);

        // Get question from user and print
        System.out.println("Please enter a question:");
        messageOne = scan.nextLine();
        System.out.println("Here is your question: \"" + messageOne + "\"");

        // Get word from user and print
        System.out.println("Please enter one word:");
        messageTwo = scan.next();
        System.out.println("Here is your word: \"" + messageTwo + "\"");

        // Get int from the user and print - use getUserInt method to handle input errors
        System.out.println("Please enter one integer:");
        myInt = getUserInt(scan);
        System.out.println("Here is your integer: \"" + myInt + "\"");

        // Get double from the user and print - use getUserDouble method to handle input errors
        System.out.println("Please enter one decimal:");
        myDouble = getUserDouble(scan);
        System.out.println("Here is your decimal: \"" + myDouble + "\"");

        // Empty println for whitespace
        System.out.println();

        // Calculate product of myDouble and myInt, store in doubleTotal
        doubleTotal = myDouble * myInt;
        System.out.println("You multiplied " + myInt + " times " + myDouble + " and got result " + doubleTotal);

        // Cast myInt to floated
        floated = myInt; // don't need to explicitly cast - widening
        System.out.println("Here is your integer floated: " + floated);

        // Cast myDouble to int
        truncated = (int) myDouble; // need to explicitly cast - narrowing
        System.out.println("Here is your double truncated: " + truncated);

        System.out.println("\n*******************************************");
        System.out.println("*******************************************");
        System.out.println("**                                       **");
        System.out.println("**                Ben Godwin             **");
        System.out.println("**               CSC 1051-001            **");
        System.out.println("**                Project #3             **");
        System.out.println("**                                       **");
        System.out.println("*******************************************");
        System.out.println("*******************************************\n");

        // Call to printUserUrl method to get url from user and print,
        // placed in separate method for readability
        printUserUrl(scan);

        // cleanup
        scan.close();
    }

    // Gets a valid integer from the user and returns it
    public static int getUserInt(Scanner scan) {
        // Checks if input is a valid input - if not,
        // ask user for another int and recursively call this method
        if (!scan.hasNextInt()) {
            scan.next(); // empty scanner to avoid infinite loop
            System.out.println("Please enter a valid integer");
            return getUserInt(scan);
        }
        return scan.nextInt(); // return the valid int
    }

    // Gets a valid double from the user and returns it
    public static double getUserDouble(Scanner scan) {
        // Checks if input is a valid input - if not,
        // ask user for another double and recursively call this method
        if (!scan.hasNextDouble()) {
            scan.next(); // empty scanner to avoid infinite loop
            System.out.println("Please enter a valid decimal");
            return getUserDouble(scan);
        }
        return scan.nextDouble(); // return valid double
    }

    // Gets a url from the user and prints its parts
    public static void printUserUrl(Scanner scan) {
        // Directions for user
        System.out.println("Enter a url below. End by typing a double slash (//) to exit");

        // Change delimiter of scanner to break up the input by "/" to separate url
        scan.useDelimiter("/");

        // Read the input from the user. While the next token has a length greater than zero,
        // print the next token. Once the length is zero, the user has entered "//",
        // break the loop
        String input;
        while(scan.hasNext()) {
            // set input to value of next token and check length
            if ((input = scan.next()).length() == 0) {
                break;
            }
            System.out.println(input);
        }

        // empty println for whitespace
        System.out.println();

        // reset scanner delimiter to " " in case scanner is used again
        scan.useDelimiter(" ");
    }
}
