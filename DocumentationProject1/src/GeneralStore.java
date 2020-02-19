// GeneralStore.java, Benjamin Godwin, CSC 1051 - 001
// I assert that this program I am submitting is the result of my own efforts.

/* GeneralStore specification - program that computes and outputs the total
    dollar amount of pears, cans, and the grand total, given the number of pear cans (7)
    and corn cans (3) to be purchased, and the prices of pear cans (70) and corn cans (80) */

// Variables: cornCan, pearCan, cornPrice, pearPrice, totalCorn, totalPears, grandTotal

// Processing:
// 1. totalPears = pearCan * pearPrice
// 2. Print total cost of pears
// 3. totalCorn = cornCan * cornPrice
// 4. Print total cost of corn
// 5. grandTotal = totalPears + totalCorn
// 6. Print grand total


public class GeneralStore {

    // -----------------------------------------------
    // Calculates total cost of cans of pears and corn
    // -----------------------------------------------
    public static void main(String[] args) {
        int cornCan, pearCan, cornPrice, pearPrice, totalCorn, totalPears, grandTotal;
        totalCorn = 0;
        totalPears = 0;
        grandTotal = 0;

        // Pass in initial values from specification
        pearCan = 7;
        cornCan = 3;
        pearPrice = 70;
        cornPrice = 80;

        // Calculate pear total and print in dollars
        totalPears = pearCan * pearPrice;
        System.out.println("Total Pears = " + formatDollars(totalPears));

        // Calculate corn total and print in dollars
        totalCorn = cornCan * cornPrice;
        System.out.println("Total Corn = " + formatDollars(totalCorn));

        // Calculate grant total and print in dollars
        grandTotal = totalPears + totalCorn;
        System.out.println("Grand Total = " + formatDollars(grandTotal));
    }

    // Formats integer amount, in cents, as a human-friendly currency string in dollars and cents
    public static String formatDollars(int amount) {
        return "$" + (amount / 100) + "." + (amount % 100);
    }
}
