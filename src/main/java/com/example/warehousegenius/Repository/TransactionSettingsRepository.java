package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.TransactionSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionSettingsRepository extends JpaRepository<TransactionSettings, Long> {
    // You can add custom query methods here if needed
}
