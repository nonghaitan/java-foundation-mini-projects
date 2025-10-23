package com.tan.day1_day2_tests;

import com.tan.day1_day2_calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5, Calculator.add(2, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(2, Calculator.subtract(5, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(15, Calculator.multiply(3, 5));
    }

    @Test
    void testDivide() {
        assertEquals(2, Calculator.divide(10, 5));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(5, 0));
    }

    @Test
    void testCalculatePower() {
        assertEquals(1, Calculator.calculatePower(5, 0));
        assertEquals(8, Calculator.calculatePower(2, 3));
    }

    @Test
    void testCalculateSqrt() {
        assertEquals(3, Calculator.calculateSqrt(9));
        assertEquals(0, Calculator.calculateSqrt(0));
    }
}
