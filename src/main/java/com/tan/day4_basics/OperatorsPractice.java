package com.tan.day4_basics;

public class OperatorsPractice {
    public static void main(String[] args) {
        int a = 10, b = 3;

        // Arithmetic operators
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

        // Comparison operators
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));

        // Logical operators
        boolean x = true, y = false;
        System.out.println("x && y: " + (x && y));
        System.out.println("x || y: " + (x || y));
        System.out.println("!x: " + (!x));

        // Assignment & increment/decrement
        int c = a;
        c += 5; // c = c + 5
        System.out.println("c after += 5: " + c);

        a++;
        System.out.println("a after increment: " + a);
    }
}
