package com.example.warehousegenius.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.warehousegenius.Entity.ProductPriceList;

@Repository
public interface ProductPriceListRepository extends JpaRepository<ProductPriceList, Long> {
}
