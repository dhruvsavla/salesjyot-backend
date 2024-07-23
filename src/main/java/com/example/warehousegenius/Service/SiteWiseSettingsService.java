package com.example.warehousegenius.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.warehousegenius.Entity.SiteWiseSettings;
import com.example.warehousegenius.Repository.SiteWiseSettingsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SiteWiseSettingsService {

    @Autowired
    private SiteWiseSettingsRepository repository;

    public List<SiteWiseSettings> getAllSiteWiseSettings() {
        return repository.findAll();
    }

    public Optional<SiteWiseSettings> getSiteWiseSettingsById(Long id) {
        return repository.findById(id);
    }

    public SiteWiseSettings createSiteWiseSettings(SiteWiseSettings siteWiseSettings) {
        return repository.save(siteWiseSettings);
    }

    public SiteWiseSettings updateSiteWiseSettings(Long id, SiteWiseSettings siteWiseSettingsDetails) {
        Optional<SiteWiseSettings> siteWiseSettingsOptional = repository.findById(id);

        if (siteWiseSettingsOptional.isPresent()) {
            SiteWiseSettings siteWiseSettings = siteWiseSettingsOptional.get();
            siteWiseSettings.setSiteName(siteWiseSettingsDetails.getSiteName());
            siteWiseSettings.setDefaultTax(siteWiseSettingsDetails.getDefaultTax());
            siteWiseSettings.setDefaultStockSite(siteWiseSettingsDetails.getDefaultStockSite());
            siteWiseSettings.setRackWiseStock(siteWiseSettingsDetails.isRackWiseStock());
            return repository.save(siteWiseSettings);
        } else {
            throw new RuntimeException("SiteWiseSettings not found with id " + id);
        }
    }

    public void deleteSiteWiseSettings(Long id) {
        repository.deleteById(id);
    }
}

