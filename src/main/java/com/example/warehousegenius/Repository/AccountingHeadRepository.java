package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.AccountingHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingHeadRepository extends JpaRepository<AccountingHead, Long> {
    // Custom queries can be defined here if needed
    AccountingHead findByAccountingHeadId(Long accountingHeadId);

}
