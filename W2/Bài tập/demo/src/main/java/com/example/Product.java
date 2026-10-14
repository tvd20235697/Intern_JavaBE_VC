package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long price;

    protected Product() {
    }

    public Product(Long id, Long price) {
        this.id = id;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Long getPrice() {
        return price;
    }
}
