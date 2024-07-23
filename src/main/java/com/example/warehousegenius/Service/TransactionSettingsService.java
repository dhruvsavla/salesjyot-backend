package com.example.warehousegenius.Service;

import com.example.warehousegenius.Entity.TransactionSettings;
import com.example.warehousegenius.Repository.TransactionSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionSettingsService {

    @Autowired
    private TransactionSettingsRepository transactionSettingsRepository;

    public TransactionSettings saveTransactionSettings(TransactionSettings transactionSettings) {
        return transactionSettingsRepository.save(transactionSettings);
    }

    public Optional<TransactionSettings> getTransactionSettingsById(Long id) {
        return transactionSettingsRepository.findById(id); 
    }

    public List<TransactionSettings> getAllTransactionSettings() {
        return transactionSettingsRepository.findAll();
    }

    public void deleteTransactionSettings(Long id) {
        transactionSettingsRepository.deleteById(id);
    }
}
