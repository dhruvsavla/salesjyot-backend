package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.CompanySetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanySettingRepository extends JpaRepository<CompanySetting, Long> {
}
