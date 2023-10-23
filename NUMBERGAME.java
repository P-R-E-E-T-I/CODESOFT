
import java.util.Random;
import java.util.Scanner;

public class NUMBERGAME {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int totalRounds = 0;
        int roundsWon = 0;

        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;

            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out
                    .println("I've selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (hasGuessedCorrectly) {
                System.out.println("Congratulations! You've guessed the number: " + targetNumber);
                roundsWon++;
            } else {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }

            totalRounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();

            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }

        scanner.close();

        System.out.println("Thanks for playing!");
        System.out.println("Rounds played: " + totalRounds);
        System.out.println("Rounds won: " + roundsWon);
    }
}
