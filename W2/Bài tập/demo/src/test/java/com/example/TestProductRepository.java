package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TestProductRepository {
    @Autowired
    private ProductRepository productRepository;

    @Test 
    public void testSaveAndFindProduct() {
        Product product = new Product( 1L, 1200L);
        productRepository.save(product);
        Long foundProduct = productRepository.findPriceById(product.getId()).orElse(null);
        assertNotNull(foundProduct);
        assertEquals(1200L, foundProduct);
        assertEquals(1200L, product.getPrice());
    }
}
