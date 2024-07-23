package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.TaxMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxMasterRepository extends JpaRepository<TaxMaster, Long> {
}

