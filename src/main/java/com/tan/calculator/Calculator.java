package com.tan.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("===== SIMPLE CALCULATOR =====");
            System.out.println("1. Add (+)");
            System.out.println("2. Subtract (-)");
            System.out.println("3. Multiply (*)");
            System.out.println("4. Divide (/)");
            System.out.println("5. Exit");
            System.out.println("6. Power (a^b)");
            System.out.println("7. Square Root (Va)");
            System.out.print("Choose an operation: ");

            int choice = scanner.nextInt();

            if (choice == 5) {
                running = false;
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            double result = 0;
            try {
                switch (choice) {
                    case 1 -> result = add(num1, num2);
                    case 2 -> result = subtract(num1, num2);
                    case 3 -> result = multiply(num1, num2);
                    case 4 -> result = divide(num1, num2);
                    default -> System.out.println("Invalid choice!");
                    case 6 -> result = calculatePower(num1, num2);
                    case 7 -> result = calculateSqrt(num1);
                }
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }

    static double add(double a, double b) { return a + b; }
    static double subtract(double a, double b) { return a - b; }
    static double multiply(double a, double b) { return a * b; }
    static double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }

    static double calculatePower(double a, double b) {
        return Math.pow(a, b);
    }

    static double calculateSqrt(double a) {
        return Math.sqrt(a);
    }
}
