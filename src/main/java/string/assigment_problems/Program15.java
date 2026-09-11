package string.assigment_problems;

import java.util.Scanner;

public class Program15 {

    public static void guessTheNumber(int secretNumber,
                                      int maxTries,
                                      int[] guesses) {

        int tries = 0;
        boolean guessed = false;

        while (tries < maxTries
                && tries < guesses.length
                && !guessed) {

            int guess = guesses[tries];

            if (guess > secretNumber) {
                System.out.println("Too high");

            } else if (guess < secretNumber) {
                System.out.println("Too low");

            } else {
                System.out.println("Correct! You guessed it");
                guessed = true;
                break;
            }

            tries++;
        }

        if (!guessed) {
            System.out.println("Out of tries — the number was "
                    + secretNumber);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter secret number: ");
        int secretNumber = sc.nextInt();

        System.out.print("Enter maximum tries: ");
        int maxTries = sc.nextInt();

        System.out.print("Enter number of guesses: ");
        int n = sc.nextInt();

        int[] guesses = new int[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter guess " + (i + 1) + ": ");
            guesses[i] = sc.nextInt();
        }

        guessTheNumber(secretNumber, maxTries, guesses);
    }
}