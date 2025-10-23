package com.tan.basics;

import java.util.Scanner;

public class ControlFlowPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your score (0–100): ");
        int score = sc.nextInt();

        // if-else
        if (score >= 90) {
            System.out.println("Grade A");
        } else if (score >= 75) {
            System.out.println("Grade B");
        } else if (score >= 60) {
            System.out.println("Grade C");
        } else {
            System.out.println("Grade D – Failed!");
        }

        // switch-case
        System.out.print("Enter day of the week (1–7): ");
        int day = sc.nextInt();

        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");
            default -> System.out.println("Invalid day");
        }

        // Loop – for
        System.out.print("Numbers from 1 to 5: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }

        // while
        int count = 3;
        System.out.println("\nCountdown:");
        while (count > 0) {
            System.out.println(count--);
        }

        sc.close();
    }
}
