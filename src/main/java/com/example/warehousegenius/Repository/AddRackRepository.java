package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.AddRack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddRackRepository extends JpaRepository<AddRack, Long> {
    // Define custom queries if needed
}
