package com.tan.day5_test;

import com.tan.methods_day5.SimpleMathUtility;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleMathUtilityTest {
    @Test
    void testAdd() {
        assertEquals(8, SimpleMathUtility.add(5, 3));
    }

    @Test
    void testDivideByZero() {
        assertEquals(0, SimpleMathUtility.divide(5, 0));
    }
}
