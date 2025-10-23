package com.tan.methods_day5;

public class DebugDemo {
    public static int addNumbers(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static void main(String[] args) {
        // 🔍 Set a breakpoint here and step through the code
        int result = addNumbers(5, 7);
        System.out.println("Result of addition: " + result);
    }
}
