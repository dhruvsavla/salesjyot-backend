package com.example.warehousegenius.Service;

import com.example.warehousegenius.Entity.CompanyMaster;
import com.example.warehousegenius.Repository.CompanyMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyMasterService {

    @Autowired
    private CompanyMasterRepository companyMasterRepository;

    public List<CompanyMaster> getAllCompanies() {
        return companyMasterRepository.findAll();
    }

    public Optional<CompanyMaster> getCompanyById(Long id) {
        return companyMasterRepository.findById(id);
    }

    public CompanyMaster createOrUpdateCompany(CompanyMaster company) {
        return companyMasterRepository.save(company);
    }

    public void deleteCompany(Long id) {
        companyMasterRepository.deleteById(id);
    }
}
