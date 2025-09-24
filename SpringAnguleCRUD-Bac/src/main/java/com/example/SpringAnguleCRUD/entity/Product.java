package com.example.SpringAnguleCRUD.entity;


import jakarta.persistence.*;
import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private Boolean available;
    private String supplierEmail;
    private LocalDate manufacturingDate;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ElementCollection
    private List<String> tags;
    @Lob
    private String description;
    @Column(columnDefinition = "TEXT")
    private String longDescription;
    public enum Category {
        ELECTRONICS, CLOTHING, BOOKS, FOOD, OTHER
    }

    // Constructors
    public Product() {
        this.createdAt = LocalDateTime.now();
    }
}