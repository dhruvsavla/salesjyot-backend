package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.PriceListMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceListMasterRepository extends JpaRepository<PriceListMaster, Long> {

}
