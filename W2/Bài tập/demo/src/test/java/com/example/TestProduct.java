package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestProduct {
    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    public void testGetPriceById() {
        when(productRepository.findPriceById(1L)).thenReturn(Optional.of(1200L));
        Long result = productService.getPriceById(1L);
        assertEquals(1100, result);
    }
    @Test 
    public void testGetPriceByIdNotFound() {
        when(productRepository.findPriceById(2L)).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> productService.getPriceById(2L));
    }
}
