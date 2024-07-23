package com.example.warehousegenius.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.warehousegenius.Entity.TaxForm;

@Repository
public interface TaxFormRepository extends JpaRepository<TaxForm, Long> {
}
