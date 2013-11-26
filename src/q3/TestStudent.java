package q3;

import java.util.Scanner;

/**
 * <p>Tests the modifications to the student class.</p>
 *
 * @author Marc Vouve
 * @version 1.0
 */
public class TestStudent {
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        final int three = 3;
        Student studentOne = new Student();
        Scanner scan = new Scanner(System.in);
        boolean retry = false;
        String result;

        System.out.println(studentOne);

        for (int i = 1; i <= three; i++) {
            do {   
                try {
                    retry = false;
                    System.out.println("enter the results of test " + i
                            + " value must be between 0 and 100");
                    //scans as a string so value can be validated, Input 
                    //mismatch from scan.nextInt() would not work in a loop.
                    result = scan.next();
                    studentOne.setTestScore(i, Double.parseDouble(result));
                } catch (IllegalArgumentException e) {
                    System.out.print("That value is invalid, please re-");
                    retry = true;
                }
            } while(retry);
        }
        System.out.println();
        System.out.println(studentOne);
        System.out.println("Question three was called and ran sucessfully.");
        scan.close();
    }

};
