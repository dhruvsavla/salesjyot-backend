package com.example.warehousegenius.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.warehousegenius.Entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    
}
