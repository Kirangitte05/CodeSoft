import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;
        int roundsWon = 0;

        System.out.println("🎮 Welcome to Number Guessing Game!");

        while (true) {
            int number = rand.nextInt(100) + 1; // 1 to 100
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nI have generated a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("✅ Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;

                    // Score calculation (more attempts = less score)
                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;

                    System.out.println("🎯 You earned " + score + " points.");
                    break;
                } else if (guess < number) {
                    System.out.println("📉 Too low!");
                } else {
                    System.out.println("📈 Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You lost! The correct number was: " + number);
            }

            // Ask to play again
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String choice = sc.next().toLowerCase();

            if (!choice.equals("yes")) {
                break;
            }
        }

        // Final Score
        System.out.println("\n🏁 Game Over!");
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Total Score: " + totalScore);

        sc.close();
    }
}