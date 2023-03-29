import java.util.Scanner;
import java.util.Random;

public class Number_Guessing_Game {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Random rand = new Random();
            int numRounds = 3;
            int rangeMin = 1, rangeMax = 100;
            int maxAttempts = 5;
            int totalScore = 0;
            
            System.out.println("Welcome to Guess the Number game!\n");
            
            for (int round = 1; round <= numRounds; round++) {
                int secretNumber = rand.nextInt(rangeMax - rangeMin + 1) + rangeMin;
                int attemptsLeft = maxAttempts;
                int roundScore = 0;
                
                System.out.printf("Round %d - Guess the number between %d and %d.\n", round, rangeMin, rangeMax);
                
                while (attemptsLeft > 0) {
                    System.out.printf("\nYou have %d attempts left. Enter your guess: ", attemptsLeft);
                    int guess = input.nextInt();
                    roundScore += 10; // Award 10 points per attempt
                    
                    if (guess == secretNumber) {
                        System.out.println("Congratulations! You guessed the number.");
                        totalScore += roundScore;
                        break;
                    }
                    else if (guess < secretNumber) {
                        System.out.println("Your guess is low.");
                    }
                    else {
                        System.out.println("Your guess is  high.");
                    }
                    attemptsLeft--;
                }
                
                if (attemptsLeft == 0) {
                    System.out.printf("\nSorry, you have used all %d attempts. The secret number was %d.\n", maxAttempts, secretNumber);
                }
                System.out.printf("Your score for round %d is %d.\n\n", round, roundScore);
            }
            
            System.out.printf("Game over! Your total score is %d.\n", totalScore);
        }
    }
}