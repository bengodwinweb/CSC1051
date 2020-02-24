// Ben Godwin, CSC 1051-001
// StringDemo.java, Lab 5.0
// I assert that this program is of my own efforts

// 1. Use println statement to form a nice box
// 2. Use the String Class methods
// 3. Use correct formatting and documentation in your program


import java.util.Scanner;

public class StringDemo {

    public static void main(String[] args) {

        //
        // ------------- PART 1 -----------------
        //

        // Including this in case the next method doesn't work on the grader's machine/IDE
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        System.out.println("**                                       **");
        System.out.println("**                Ben Godwin             **");
        System.out.println("**               CSC 1051-001            **");
        System.out.println("**                Project #2             **");
        System.out.println("**                                       **");
        System.out.println("*******************************************");
        System.out.println("*******************************************\n");


        // Prints a colorful box, in separate method to help with sanity
        // I don't think this works in jGrasp or on Windows :/
        printColorfulBox();

        //
        // ------------- PART 2 -----------------
        //

        String firstName, lastName, mutated;
        Scanner scan = new Scanner(System.in);

        // 1. Prompt the user for their first name and store in a string
        System.out.println("Enter your first name");
        firstName = scan.next();
        System.out.println();

        // 2. Prompt the user for last name (at least 5 chars), store in a string
        System.out.println("Enter your last name (if shorter than 5 letters, repeat the last name until there are 5");
        lastName = scan.next();
        System.out.println();

        // 3. Print first letter of first name, followed by a period, then
        //    the first 5 letters of the last name
        System.out.println(firstName.charAt(0) + ". " + lastName.substring(0, 5));

        // 4. Take the original first name and change it to all capital letters
        firstName = firstName.toUpperCase();
        // 5. Print the capitalized first name
        System.out.println(firstName);

        // 6. Fine out the length of the last name and print it and its length
        System.out.println("The last name: " + lastName + " has " + lastName.length() + " letters");

        // 7. Replace any letter i* with a Y in the last name and print the mutated last name
        // *This is a change from the directions because my last name doesn't have an e
        mutated = lastName.replace("i", "Y");
        System.out.println(mutated);


        //
        // ------------- PART 3 -----------------
        //

        // **** STEP 1 *****

        // 8. Declare five Strings
        String m1, m2, m3, m4, m5;

        // 9. Set m1 to value in directions
        m1 = "Quest for the Holy Grail";

        // 10. Print m1 with quotes around the statement
        System.out.println("\"" + m1 + "\"");

        // 11. Set m2 to be m1 in all lowercase
        m2 = m1.toLowerCase();

        // 12. Print m2
        System.out.println(m2);

        // 13. Store the concatenation of m1 with one space then m2 in m3.
        m3 = m1.concat(" " + m2);

        // 14. Print m3
        System.out.println(m3);

        // 15. Set m4 to be m3 with every g replaced with a z
        m4 = m3.replace("g", "z");

        // 16. Print m4
        System.out.println(m4);

        // 17. Set m5 to be a substring of m4 from the letter f to the end
        m5 = m4.substring(6);

        // 18. Print m5
        System.out.println(m5);

        // **** STEP 2 *****
        System.out.println(m1.replace("Grail", "Java SDK"));
    }

    public static void printColorfulBox() {
        // Declare ANSI constants
        final String ANSI_RESET  = "\u001B[0m";
        final String ANSI_RED    = "\u001B[31m";
        final String ANSI_BRIGHT_CYAN   = "\u001B[96m";
        final String ANSI_BG_BLUE   = "\u001B[44m";
        final String ANSI_BRIGHT_BG_RED    = "\u001B[101m";

        // Assign to easier to use constant names for later
        String FG1 = ANSI_RED;
        String FG2 = ANSI_BRIGHT_CYAN;
        String BG1 = ANSI_BG_BLUE;
        String BG2 = ANSI_BRIGHT_BG_RED;
        String RESET = ANSI_RESET;

        String message;
        message = "*******************************************\n" +
                "*******************************************\n" +
                "**                                       **\n" +
                "**                Ben Godwin             **\n" +
                "**               CSC 1051-001            **\n" +
                "**                Project 5.0            **\n" +
                "**                                       **\n" +
                "*******************************************\n" +
                "*******************************************\n\n";

        char[] messageChars = message.toCharArray();

        for (char c : messageChars) {
            if (c != '*' && c != '\n') {
                // Highlights middle of box
                System.out.print(FG2 + BG2 + c);
            } else if (c == '\n') {
                // Resets if printing a new line
                System.out.print(RESET + c);
            } else {
                // Highlights border of box
                System.out.print(FG1 + BG1 + c);
            }
        }
    }
}
