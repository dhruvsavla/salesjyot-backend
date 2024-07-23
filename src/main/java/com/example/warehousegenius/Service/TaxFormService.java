package com.example.warehousegenius.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.warehousegenius.Entity.TaxForm;
import com.example.warehousegenius.Repository.TaxFormRepository;

@Service
public class TaxFormService {

    @Autowired
    private TaxFormRepository taxFormRepository;

    public List<TaxForm> getAllTaxForms() {
        return taxFormRepository.findAll();
    }

    public Optional<TaxForm> getTaxFormById(Long id) {
        return taxFormRepository.findById(id);
    }

    public TaxForm saveTaxForm(TaxForm taxForm) {
        return taxFormRepository.save(taxForm);
    }

    public void deleteTaxForm(Long id) {
        taxFormRepository.deleteById(id);
    }
}
