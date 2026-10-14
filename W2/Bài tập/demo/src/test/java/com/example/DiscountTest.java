package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DiscountTest {
    private final DiscountService service = new DiscountService();

    @Test 
    public void testApplyDiscountIsPriceOver1000() {
        Long result = service.applyDiscount(1200L);
        assertEquals(1000, result);
    }
    @Test 
    public void testApplyDiscountIsPriceUnder1000() {
        System.out.println("May chay tao o dau?");
        Long result = service.applyDiscount(500L);
        assertEquals(500, result);
    }
}
