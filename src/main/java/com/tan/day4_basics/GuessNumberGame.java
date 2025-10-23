package com.tan.day4_basics;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1; // 1–100
        int attempts = 0;
        int guess;

        System.out.println("🎯 Guess the number (1–100)!");

        do {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else {
                System.out.println("🎉 Correct! You guessed it in " + attempts + " attempts.");
            }
        } while (guess != numberToGuess);

        sc.close();
    }
}
