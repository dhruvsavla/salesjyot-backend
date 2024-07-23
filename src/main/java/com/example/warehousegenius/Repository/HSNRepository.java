package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.HSN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HSNRepository extends JpaRepository<HSN, Long> {
}

