package com.example;

public class DiscountService {
    public Long applyDiscount(Long price) {
        if(price > 1000) {
            return price - 200;
        } else {
            return price;
        }
    }
}
