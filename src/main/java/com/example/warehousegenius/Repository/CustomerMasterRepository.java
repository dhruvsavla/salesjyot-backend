package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.CustomerMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, Long> {

}
