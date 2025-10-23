package com.tan.methods_day5;

public class PassByValueDemo {
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Inside method: a = " + a + ", b = " + b);
    }

    public static void main(String[] args) {
        int x = 5, y = 10;
        System.out.println("Before method call: x = " + x + ", y = " + y);
        swap(x, y);
        System.out.println("After method call: x = " + x + ", y = " + y);
    }
}
