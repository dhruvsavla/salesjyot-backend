package com.example.warehousegenius.Service;

import com.example.warehousegenius.Entity.AccountingHead;
import com.example.warehousegenius.Entity.TaxMaster;
import com.example.warehousegenius.Service.AccountingHeadService;
import com.example.warehousegenius.Repository.TaxMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaxMasterService {

    @Autowired
    private TaxMasterRepository taxMasterRepository;

    @Autowired
    private AccountingHeadService accountingHeadService;

    public List<TaxMaster> getAllTaxes() {
        return taxMasterRepository.findAll();
    }

    public Optional<TaxMaster> getTaxById(Long id) {
        return taxMasterRepository.findById(id);
    }

    @Transactional
    public TaxMaster saveTax(TaxMaster taxMaster) {
        AccountingHead accountingHead = new AccountingHead();
        accountingHead.setDisplayName(taxMaster.getDisplayName());
        accountingHeadService.saveAccountingHead(accountingHead);
        accountingHead.setTax(taxMaster);
        return taxMasterRepository.save(taxMaster);
    }

    public void deleteTax(Long id) {
        taxMasterRepository.deleteById(id);
    }
}

