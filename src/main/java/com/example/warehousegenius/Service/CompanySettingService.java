package com.example.warehousegenius.Service;

import com.example.warehousegenius.Entity.CompanySetting;
import com.example.warehousegenius.Repository.CompanySettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanySettingService {

    @Autowired
    private CompanySettingRepository companySettingRepository;

    public List<CompanySetting> getAllCompanySettings() {
        return companySettingRepository.findAll();
    }

    public Optional<CompanySetting> getCompanySettingById(Long id) {
        return companySettingRepository.findById(id);
    }

    public CompanySetting createOrUpdateCompanySetting(CompanySetting companySetting) {
        return companySettingRepository.save(companySetting);
    }

    public void deleteCompanySetting(Long id) {
        companySettingRepository.deleteById(id);
    }
}
