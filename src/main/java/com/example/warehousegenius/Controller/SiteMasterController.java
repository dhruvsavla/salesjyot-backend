package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.SiteMaster;
import com.example.warehousegenius.Service.SiteMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/sites")
public class SiteMasterController {

    @Autowired
    private SiteMasterService siteMasterService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // GET method to fetch all sites
    @GetMapping
    public List<SiteMaster> getAllSites() {
        return siteMasterService.getAllSites();
    }

    // POST method to create a site
    @PostMapping
    public SiteMaster createSite(@RequestBody SiteMaster site) {
        SiteMaster createdSite = siteMasterService.saveSite(site);
        messagingTemplate.convertAndSend("/topic/sites", createdSite);
        return createdSite;
    }

    // PUT method to update a site
    @PutMapping("/{id}")
    public ResponseEntity<SiteMaster> updateSite(@PathVariable Long id, @RequestBody SiteMaster siteDetails) {
        Optional<SiteMaster> site = siteMasterService.getSiteId(id);
        if (site.isPresent()) {
            SiteMaster updatedSite = site.get();
            updatedSite.setSiteName(siteDetails.getSiteName());
            updatedSite.setSiteCode(siteDetails.getSiteCode());
            updatedSite.setStoresStock(siteDetails.getStoresStock());
            updatedSite.setHasTransactionNos(siteDetails.getHasTransactionNos());
            updatedSite.setIsPrimary(siteDetails.getIsPrimary());
            updatedSite.setSiteForStockKeeping(siteDetails.getSiteForStockKeeping());
            updatedSite.setSiteForTransactionNos(siteDetails.getSiteForTransactionNos());

            messagingTemplate.convertAndSend("/topic/sites", updatedSite);
            return ResponseEntity.ok(siteMasterService.saveSite(updatedSite));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE method to delete a site
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSite(@PathVariable Long id) {
        siteMasterService.deleteSite(id);
        messagingTemplate.convertAndSend("/topic/sites", id);
        return ResponseEntity.ok().build();
    }
}
