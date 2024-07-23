package com.example.warehousegenius.Service;

import com.example.warehousegenius.Entity.AccountingHead;
import com.example.warehousegenius.Entity.BankMaster;
import com.example.warehousegenius.Repository.BankMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BankMasterService {

    @Autowired
    private BankMasterRepository bankMasterRepository;

    @Autowired
    private AccountingHeadService accountingHeadService;

    public List<BankMaster> getAllBanks() {
        return bankMasterRepository.findAll();
    }

    public Optional<BankMaster> getBankById(Long id) {
        return bankMasterRepository.findById(id);
    }

    @Transactional
    public BankMaster createOrUpdateBank(BankMaster bank) {
        AccountingHead accountingHead = new AccountingHead();
        accountingHead.setDisplayName(bank.getBankName());
        accountingHead.setBankAccount(bank);
        accountingHeadService.saveAccountingHead(accountingHead);
        System.out.println("company = " + bank.getCompany());
        return bankMasterRepository.save(bank);
    }

    public void deleteBank(Long id) {
        bankMasterRepository.deleteById(id);
    }
}
