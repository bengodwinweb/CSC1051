// Ben Godwin
// Lab 3.0 - TestRead
// I assert that the program I am submitting is the result of my own efforts.

import java.util.Scanner;

public class TestRead {

    public static void main(String[] args) {
        String name, petName, petType, petGender, message;
        int age;

        Scanner scan = new Scanner(System.in);

        System.out.println("What is your name?");
        name = scan.nextLine();

        System.out.println("What type of pet do you have?");
        petType = scan.nextLine();

        System.out.println("What is your pet's name?");
        petName = scan.nextLine();

        System.out.println("What is your pet's gender? (Please enter M, F, or N)");
        petGender = getGender(scan);

        System.out.println("What is your age?");
        age = getAge(scan);

        message = "Hi my name is " + name + ", I am " + age + " years old. " +
                "I have a\n" + petType + " named " + petName + ". " + petGender + " is a " +
                "wonderful friend. We\ngo everywhere together";

        System.out.println(message);

    }

    public static String getGender(Scanner scan) {
        String gender = "X";
        boolean isValid = false;
        while(!isValid) {
            gender = scan.nextLine().toUpperCase();
            if (gender.equals("M") || gender.equals("F") || gender.equals("N")) {
                if (gender.equals("M")) {
                    gender = "He";
                } else if (gender.equals("F")) {
                    gender = "She";
                } else {
                    gender = "They";
                }

                isValid = true;
                break;
            }
            System.out.println("Options are M, F, or N");
        }
        return gender;
    }

    public static int getAge(Scanner scan) {
        int age = -1;
        boolean isInt = false;
        while(!isInt) {
            if (scan.hasNextInt()) {
                age = scan.nextInt();
                isInt = true;
                break;
            }
            System.out.println("Please enter a valid int");
            scan.nextLine();
        }

        return age;
    }
}
