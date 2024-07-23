package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.CompanyMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyMasterRepository extends JpaRepository<CompanyMaster, Long> {
}
