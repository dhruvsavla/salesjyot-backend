package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.AddSizeRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddSizeRangeRepository extends JpaRepository<AddSizeRange, Long> {
    // You can add custom query methods here if needed
    AddSizeRange findBySizeRange(String sizeRange);
}
