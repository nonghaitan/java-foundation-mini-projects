package com.tan.methods_day5;

public class MethodExample {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        System.out.println("Sum: " + add(5, 3));
        System.out.println("Difference: " + subtract(10, 4));
    }
}
