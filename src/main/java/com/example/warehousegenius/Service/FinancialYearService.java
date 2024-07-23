package com.example.warehousegenius.Service;

import com.example.warehousegenius.Entity.FinancialYear;
import com.example.warehousegenius.Repository.FinancialYearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinancialYearService {

    private final FinancialYearRepository financialYearRepository;

    @Autowired
    public FinancialYearService(FinancialYearRepository financialYearRepository) {
        this.financialYearRepository = financialYearRepository;
    }

    public List<FinancialYear> getAllFinancialYears() {
        return financialYearRepository.findAll();
    }

    public Optional<FinancialYear> getFinancialYearById(Long id) {
        return financialYearRepository.findById(id);
    }

    public FinancialYear createOrUpdateFinancialYear(FinancialYear financialYear) {
        return financialYearRepository.save(financialYear);
    }

    public void deleteFinancialYear(Long id) {
        financialYearRepository.deleteById(id);
    }
}
