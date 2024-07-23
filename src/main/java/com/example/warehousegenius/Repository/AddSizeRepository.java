package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.AddSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddSizeRepository extends JpaRepository<AddSize, Long> {
    // You can define custom query methods if needed
}
