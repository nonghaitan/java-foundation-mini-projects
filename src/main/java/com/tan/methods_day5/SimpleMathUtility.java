package com.tan.methods_day5;

import java.util.Scanner;

public class SimpleMathUtility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Simple Math Utility ===");
        System.out.println("1. Add\n2. Subtract\n3. Multiply\n4. Divide");
        System.out.print("Choose operation (1-4): ");
        int choice = sc.nextInt();

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        double result = 0;

        switch (choice) {
            case 1 -> result = add(a, b);
            case 2 -> result = subtract(a, b);
            case 3 -> result = multiply(a, b);
            case 4 -> result = divide(a, b);
            default -> System.out.println("Invalid choice!");
        }

        System.out.println("Result: " + result);
        sc.close();
    }

    public static double add(double a, double b) { return a + b; }
    public static double subtract(double a, double b) { return a - b; }
    public static double multiply(double a, double b) { return a * b; }
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero!");
            return 0;
        }
        return a / b;
    }
}
