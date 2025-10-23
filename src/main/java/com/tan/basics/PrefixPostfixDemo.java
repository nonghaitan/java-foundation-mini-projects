package com.tan.basics;

public class PrefixPostfixDemo {
    public static void main(String[] args) {
        int a = 5;
        int b = ++a; // prefix
        System.out.println("Prefix ++a: a = " + a + ", b = " + b);

        int x = 5;
        int y = x++; // postfix
        System.out.println("Postfix x++: x = " + x + ", y = " + y);

        int p = 10;
        int q = --p; // prefix decrement
        System.out.println("Prefix --p: p = " + p + ", q = " + q);

        int m = 10;
        int n = m--; // postfix decrement
        System.out.println("Postfix m--: m = " + m + ", n = " + n);

        // Bonus example inside a loop:
        System.out.println("\\nLoop difference:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Postfix loop i++ => " + i);
        }

        System.out.println();
        for (int i = 0; i < 3; ++i) {
            System.out.println("Prefix loop ++i => " + i);
        }
    }
}
