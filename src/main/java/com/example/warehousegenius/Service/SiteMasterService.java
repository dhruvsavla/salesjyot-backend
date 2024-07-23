package com.example.warehousegenius.Service;

import com.example.warehousegenius.Entity.SiteMaster;
import com.example.warehousegenius.Repository.SiteMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiteMasterService {

    @Autowired
    private SiteMasterRepository siteMasterRepository;

    public List<SiteMaster> getAllSites() {
        return siteMasterRepository.findAll();
    }

    public Optional<SiteMaster> getSiteId(Long id) {
        return siteMasterRepository.findById(id);
    }

    public SiteMaster saveSite(SiteMaster taxMaster) {
        return siteMasterRepository.save(taxMaster);
    }

    public void deleteSite(Long id) {
        siteMasterRepository.deleteById(id);
    }
}

