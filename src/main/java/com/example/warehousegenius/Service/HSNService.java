package com.example.warehousegenius.Service;

import com.example.warehousegenius.Entity.HSN;
import com.example.warehousegenius.Repository.HSNRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HSNService {

    @Autowired
    private HSNRepository hsnRepository;

    public List<HSN> getAllHSNs() {
        return hsnRepository.findAll();
    }

    public Optional<HSN> getHSNById(Long id) {
        return hsnRepository.findById(id);
    }

    public HSN saveHSN(HSN hsn) {
        return hsnRepository.save(hsn);
    }

    public void deleteHSN(Long id) {
        hsnRepository.deleteById(id);
    }

    public HSN updateHSN(Long id, HSN hsnDetails) {
        HSN hsn = hsnRepository.findById(id).orElseThrow(() -> new RuntimeException("HSN not found"));
        hsn.setHsnCode(hsnDetails.getHsnCode());
        hsn.setHsnDescription(hsnDetails.getHsnDescription());
        return hsnRepository.save(hsn);
    }
}

