package com.tan.methods_day5;

public class OverloadingDemo {

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static String multiply(String s, int times) {
        return s.repeat(times);
    }

    public static void main(String[] args) {
        System.out.println(multiply(2, 3));
        System.out.println(multiply(2.5, 4.0));
        System.out.println(multiply("Hi ", 3));
    }
}
