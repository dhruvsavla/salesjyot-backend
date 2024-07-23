package com.example.warehousegenius.Service;

import com.example.warehousegenius.Entity.AccountingHead;
import com.example.warehousegenius.Entity.CustomerMaster;
import com.example.warehousegenius.Service.AccountingHeadService;

import com.example.warehousegenius.Repository.CustomerMasterRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerMasterService {

    private final CustomerMasterRepository customerMasterRepository;

    private final AccountingHeadService accountingHeadService;

    @Autowired
    public CustomerMasterService(CustomerMasterRepository customerMasterRepository, AccountingHeadService accountingHeadService) {
        this.customerMasterRepository = customerMasterRepository;
        this.accountingHeadService = accountingHeadService;
    }

    public List<CustomerMaster> getAllCustomers() {
        return customerMasterRepository.findAll();
    }

    public Optional<CustomerMaster> getCustomerById(Long id) {
        return customerMasterRepository.findById(id);
    }

    @Transactional
    public CustomerMaster createOrUpdateCustomer(CustomerMaster customer) {
        AccountingHead accountingHead = new AccountingHead();
        accountingHead.setDisplayName(customer.getCustomerName());
        accountingHead.setCustomer(customer);
        accountingHeadService.saveAccountingHead(accountingHead);
        return customerMasterRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerMasterRepository.deleteById(id);
    }
}
