package com.example.SpringAnguleCRUD.repositories;

import com.example.SpringAnguleCRUD.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByAvailable(Boolean available);
    List<Product> findByCategory(Product.Category category);
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}