package com.example;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select product.price from Product product where product.id = :id")
    Optional<Long> findPriceById(@Param("id") Long id);
}
