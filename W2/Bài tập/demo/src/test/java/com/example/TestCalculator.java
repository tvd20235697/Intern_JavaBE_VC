package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestCalculator {
    @BeforeAll 
    public static void init() {
        System.out.println("Before All");
    }
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        System.out.println("Test Add");
        assertEquals(5, calculator.add(2, 3));
    }
    @Test 
    public void testSubtract(){
        Calculator calculator = new Calculator();
        System.out.println("Test Subtract");
        assertEquals(1, calculator.subtract(3,2));
    }
    @Test
    @DisplayName ("Test multiplication of two numbers")
    public void testMultiply(){
        Calculator calculator = new Calculator();
        System.out.println("Test Multiply");
        assertEquals(6, calculator.multiply(2,3));
    }
    @Test
    public void testDivide(){
        Calculator calculator = new Calculator();
        System.out.println("Test Divide");
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(3, 0);
        });
        assertEquals(2, calculator.divide(6,3));
    }
    @AfterAll 
    public static void afterAll() {
        System.out.println("After All");
    }
    @ParameterizedTest 
    @CsvSource ({
        "1, 2, 3",
        "7, 3, 10",
        "5, 5, 10"      
    })
    public void testAddWP(int a, int b, int expected) {
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.add(a, b));
    }
}
