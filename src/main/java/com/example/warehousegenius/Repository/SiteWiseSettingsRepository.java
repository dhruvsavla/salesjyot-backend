package com.example.warehousegenius.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.warehousegenius.Entity.SiteWiseSettings;

@Repository
public interface SiteWiseSettingsRepository extends JpaRepository<SiteWiseSettings, Long> {
}

