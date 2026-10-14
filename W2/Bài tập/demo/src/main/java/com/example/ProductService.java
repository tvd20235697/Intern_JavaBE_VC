package com.example;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Long getPriceById(Long id) {
        Long price = productRepository.findPriceById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));
        return price - 100;
    }
}
