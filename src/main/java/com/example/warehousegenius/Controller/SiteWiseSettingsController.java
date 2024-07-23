package com.example.warehousegenius.Controller;


import com.example.warehousegenius.Entity.SiteWiseSettings;
import com.example.warehousegenius.Service.SiteWiseSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/site-wise-settings")
public class SiteWiseSettingsController {

    @Autowired
    private SiteWiseSettingsService service;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // GET method to fetch all SiteWiseSettings
    @GetMapping
    public List<SiteWiseSettings> getAllSiteWiseSettings() {
        return service.getAllSiteWiseSettings();
    }

    // POST method to create SiteWiseSettings
    @PostMapping
    public SiteWiseSettings createSiteWiseSettings(@RequestBody SiteWiseSettings siteWiseSettings) {
        SiteWiseSettings createdSiteWiseSettings = service.createSiteWiseSettings(siteWiseSettings);
        messagingTemplate.convertAndSend("/topic/site-wise-settings", createdSiteWiseSettings);
        return createdSiteWiseSettings;
    }

    // PUT method to update SiteWiseSettings
    @PutMapping("/{id}")
    public ResponseEntity<SiteWiseSettings> updateSiteWiseSettings(@PathVariable Long id, @RequestBody SiteWiseSettings siteWiseSettingsDetails) {
        Optional<SiteWiseSettings> siteWiseSettings = service.getSiteWiseSettingsById(id);
        if (siteWiseSettings.isPresent()) {
            SiteWiseSettings updatedSiteWiseSettings = siteWiseSettings.get();
            updatedSiteWiseSettings.setSiteName(siteWiseSettingsDetails.getSiteName());
            updatedSiteWiseSettings.setDefaultTax(siteWiseSettingsDetails.getDefaultTax());
            updatedSiteWiseSettings.setDefaultStockSite(siteWiseSettingsDetails.getDefaultStockSite());
            updatedSiteWiseSettings.setRackWiseStock(siteWiseSettingsDetails.isRackWiseStock());

            SiteWiseSettings savedSiteWiseSettings = service.createSiteWiseSettings(updatedSiteWiseSettings);
            messagingTemplate.convertAndSend("/topic/site-wise-settings", savedSiteWiseSettings);
            return ResponseEntity.ok(savedSiteWiseSettings);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE method to delete SiteWiseSettings
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSiteWiseSettings(@PathVariable Long id) {
        try {
            service.deleteSiteWiseSettings(id);
            messagingTemplate.convertAndSend("/topic/site-wise-settings", id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

