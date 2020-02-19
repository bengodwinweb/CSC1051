// Ben Godwin
// CSC 1051 - 001

import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        double average, double1, double2, double3;
        String name;

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your name:");
        name = scan.nextLine();

        System.out.println("Enter a decimal:");
        double1 = scan.nextDouble();

        System.out.println("Enter another decimal:");
        double2 = scan.nextDouble();

        System.out.println("Enter another decimal:");
        double3 = scan.nextDouble();

        average = (double1 + double2 + double3) / 3;
        System.out.println("Dear " + name + " your values have an average of " + average);
    }
}
