package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.FinancialYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialYearRepository extends JpaRepository<FinancialYear, Long> {
}
