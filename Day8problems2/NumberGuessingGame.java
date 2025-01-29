import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Think of a number between 1 and 100, and I'll try to guess it.");

        int lowerBound = 1;
        int upperBound = 100;
        boolean guessedCorrectly = false;
        int guess;

        while (!guessedCorrectly) {
            guess = generateGuess(lowerBound, upperBound);
            System.out.println("Is the number " + guess + "?");

            String feedback = getFeedback(scanner);
            guessedCorrectly = processFeedback(feedback, guess);

            if (!guessedCorrectly) {
                if (feedback.equalsIgnoreCase("too high")) {
                    upperBound = guess - 1;
                } else if (feedback.equalsIgnoreCase("too low")) {
                    lowerBound = guess + 1;
                }
            }
        }

        System.out.println("Yay! I've guessed the number correctly!");
        scanner.close();
    }

    public static int generateGuess(int lowerBound, int upperBound) {
        Random rand = new Random();
        return rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    public static String getFeedback(Scanner scanner) {
        System.out.print("Enter feedback (too high, too low, or correct): ");
        return scanner.nextLine();
    }

    public static boolean processFeedback(String feedback, int guess) {
        if (feedback.equalsIgnoreCase("correct")) {
            return true;
        }
        return false;
    }
}

