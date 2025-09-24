package com.example.SpringAnguleCRUD.services;



import com.example.SpringAnguleCRUD.entity.Product;
import com.example.SpringAnguleCRUD.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        product.setAvailable(productDetails.getAvailable());
        product.setSupplierEmail(productDetails.getSupplierEmail());
        product.setManufacturingDate(productDetails.getManufacturingDate());
        product.setCategory(productDetails.getCategory());
        product.setTags(productDetails.getTags());
        product.setDescription(productDetails.getDescription());
        product.setLongDescription(productDetails.getLongDescription());

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAvailableProducts() {
        return productRepository.findByAvailable(true);
    }
    public List<Product> getProductsByStatus(Boolean status) {
        return productRepository.findByAvailable(status);
    }
}