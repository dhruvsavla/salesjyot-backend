package com.example.warehousegenius.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.warehousegenius.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Additional query methods (if needed) can be defined here
}
