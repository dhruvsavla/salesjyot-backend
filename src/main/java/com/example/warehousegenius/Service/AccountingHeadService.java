package com.example.warehousegenius.Service;

import com.example.warehousegenius.Entity.AccountingHead;
import com.example.warehousegenius.Repository.AccountingHeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountingHeadService {

    private final AccountingHeadRepository accountingHeadRepository;

    @Autowired
    public AccountingHeadService(AccountingHeadRepository accountingHeadRepository) {
        this.accountingHeadRepository = accountingHeadRepository;
    }

    public List<AccountingHead> getAllAccountingHeads() {
        return accountingHeadRepository.findAll();
    }

    public Optional<AccountingHead> getAccountingHeadById(Long id) {
        return accountingHeadRepository.findById(id);
    }

    public AccountingHead saveAccountingHead(AccountingHead accountingHead) {
        return accountingHeadRepository.save(accountingHead);
    }

    public void deleteAccountingHead(Long id) {
        accountingHeadRepository.deleteById(id);
    }
}
