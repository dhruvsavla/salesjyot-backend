package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // Add custom query methods if needed
}
