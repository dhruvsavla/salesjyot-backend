package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.MonthWiseSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthWiseSettingRepository extends JpaRepository<MonthWiseSetting, Long> {
    // Define custom queries if needed
}
