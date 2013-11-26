package q2;

import java.util.Random;
import java.util.Scanner;

/**
 * <p>This program is a guessing game. Enter a number between 1 and 100 to see
 *  if you've won.</p>
 *
 * @author Marc Vouve
 * @version 1.0
 */
public class Guess {
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        String guessString;
        int guess = 0;
        int guesses = 0;
        int answer;
        final int max = 101;

        boolean valid = true;
        boolean exit = false;

        Random rand = new Random();
        answer = rand.nextInt(max);

        Scanner scan = new Scanner(System.in);
        do {

            do {
                System.out.println("Enter a number between 1 and 100 "
                        + "(Type \"quit\" to quit)");
                guessString = scan.next();
                guesses++;
                try {
                    guess = Integer.parseInt(guessString);
                    valid = true;
                } catch (NumberFormatException e) {
                    if (guessString.equalsIgnoreCase("quit")) {
                        exit = true;
                    } else {
                        System.out.println("\"" + guessString 
                                + "\" is not an number");
                    }
                    valid = false;
                }
                if (valid) {
                    if (guess > answer) {
                        System.out.println(guess + " is too high");
                    } else if (guess < answer) {
                        System.out.println(guess + " is too low");
                    }
                }
            } while((guess != answer) && !exit);

            if (!exit) {
                System.out.println("***** Congradulations you won! "
                        + "It took you " + guesses + " tries to answer *****");
                System.out.println("Play again? (yes/no)");
                if (scan.next().equalsIgnoreCase("no")) {
                    exit = true;
                }
            }
        } while(!exit);
        scan.close();
        System.out.println("Question two was called and ran sucessfully.");
    }

};
