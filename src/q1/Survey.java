package q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Driver class for household assignment.
 * @author Marc Vouve
 * @version 1.0
 *
 */
public class Survey {

    /** An array list of all the houses in the document. */
    private static ArrayList<Household> houses = new ArrayList<Household>();

    /**
     * the main method for household program.
     * @param args command line argument
     */
    public static void main(String[] args) {

        Scanner fileScan = null;
        File surveyResults;
        String fileName = "survey.txt";
        NumberFormat money = NumberFormat.getCurrencyInstance();
        int id = 0;
        double income = 0;
        int members = 0;
        int lowIncome = 0;


        surveyResults = new File("src" + File.separator + "q1" 
                + File.separator + fileName);
        try {
            fileScan = new Scanner(surveyResults).useDelimiter("\n| ");
        } catch (FileNotFoundException e) {
            System.out.println("file: \"" + fileName + "\" not found"
                    + "please make sure it is in the src\\q1 directory");

        }
        while (fileScan.hasNext()) {
            id = Integer.parseInt(fileScan.next().replaceAll("[^\\d.]", ""));
            if (fileScan.hasNext()) {
                income = Double.parseDouble(fileScan.next().
                        replaceAll("[^\\d.]", ""));
                if (fileScan.hasNext()) {
                    members = Integer.parseInt(fileScan.next().
                            replaceAll("[^\\d.]", ""));
                    houses.add(new Household(id, income, members));
                }
            }
        }
        System.out.println("Number of Houses:" + houses.size());
        System.out.println("ID\tIncome\t\tMembers");
        for (Household h : houses) {
            System.out.println(h);
        }
        System.out.println("Average household Income: "
                + money.format(average())
                + "\nHouses with incomes over the average: "
                + "\nID\tIncome");
        for (Household h  : houses) {
            if (h.getIncome() > average()) {
                System.out.println(h.getId() + "\t"
                        + money.format(h.getIncome()));
            }
            if (h.lowIncomeCheck()) {
                lowIncome++;
            }
        }
        System.out.println("Number of houses with low income: " + lowIncome);


        System.out.println("Question one was called and ran sucessfully.");
    }

    /** finds the average income among households. 
     * @return average income */
    public static double average() {
        double sum = 0;

        for (Household h : houses) {
            sum += h.getIncome();
        }

        return sum / houses.size();
    }
}
