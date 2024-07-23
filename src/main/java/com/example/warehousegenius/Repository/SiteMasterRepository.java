package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.SiteMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteMasterRepository extends JpaRepository<SiteMaster, Long> {
    // You can add custom query methods here if needed
}
