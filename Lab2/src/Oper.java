// Name: Benjamin Godwin
// File Name: Oper.java
// I assert that the program I am submitting is the result of my own efforts.

public class Oper
{
    public static void main(String[] args)
    {
        //
        // ---------------- Part 1 --------------------
        //


        System.out.println("*******************************************");
        System.out.println("*******************************************");
        System.out.println("**                                       **");
        System.out.println("**                Ben Godwin             **");
        System.out.println("**               CSC 1051-001            **");
        System.out.println("**                Project #2             **");
        System.out.println("**                                       **");
        System.out.println("*******************************************");
        System.out.println("*******************************************\n");


        //
        // ---------------- Part 2-A --------------------
        //

        // 1. One println that concatenates two strings
        System.out.println("Hi " + " there");

        // 2. One println that concatenates a string and a number
        System.out.println("My age is " + 26);

        // 3. One println that concatenates a string and the result of an arithmetic expression.
        System.out.println("19 + 24 = " + (19 + 24));

        // 4. One that is a print and then a println using any strings and/or numbers you like
        System.out.print("This is a print, ");
        System.out.println("and this is a println.");

        // 5. One that is a print, and then a print, and then a println using any 3 strings you like
        System.out.print("First I was a print, ");
        System.out.print("then I was still a print, ");
        System.out.println("but eventually I was a println");

        //
        // ---------------- Part 2-B --------------------
        //

        System.out.println();

        String myName = "Ben", myPet = "Sylvie";
        int myAge = 26;

        System.out.println("Hello, my name is " + myName + " and I am " + myAge + " years\n" +
                "old. I'm enjoying my time at Villanova, though\nI miss my pet \"" + myPet + "\" very much!");

        //
        // ---------------- Part 3 --------------------
        //

        System.out.println();

        int pearCan = 7, pearPrice = 75, totalPears = 0, cornCan = 3, cornPrice = 80, totalCorn = 0, grandTotal = 0;

        totalPears = pearCan * pearPrice;
        System.out.println("Total Pears " + totalPears);

        totalCorn = cornCan * cornPrice;
        System.out.println("Total Corn " + totalCorn);

        grandTotal = totalCorn + totalPears;
        System.out.println("Grand total " + grandTotal);

        System.out.println("\n\n");

        //
        // ---------------- Part 4 --------------------
        //

        double pearCanDec = 7, pearPriceDec = .75, totalPearDec = 0, cornCanDec = 3, cornPriceDec = .80, totalCornDec = 0, grandTotalDec = 0;

        totalCornDec = cornCanDec * cornPriceDec;
        System.out.println("Total Corn " + totalCornDec);

        totalPearDec = pearCanDec * pearPriceDec;
        System.out.println("Total Pears " + totalPearDec);

        grandTotalDec = totalCornDec + totalPearDec;
        System.out.println("Grand Total " + grandTotalDec);

        System.out.println("\n\n");

        //
        // ---------------- Part 5 --------------------
        //

        int remainder = 0, quotient = 0;

        remainder = 10 % 3;
        System.out.println("The remainder of ten divided by three is: " + remainder);

        remainder = 3 % 10;
        System.out.println("The remainder of three divided by ten is: " + remainder);

        quotient = 5 / 3;
        System.out.println("The TRUNCATED quotient of five divided by three is: " + quotient);

        double remainderDec = 0, quotientDec = 0, tenDec = 10.0, threeDec = 3.0, fiveDec = 5.0;

        remainderDec = tenDec % threeDec;
        System.out.println("\nThe double remainder of ten divided by three is: " + remainderDec);

        quotientDec = fiveDec / threeDec;
        System.out.println("The double quotient of five divided by three is: " + quotientDec);

    }
}
