package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.CompanySetting;
import com.example.warehousegenius.Service.CompanySettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/company-settings")
public class CompanySettingController {

    @Autowired
    private CompanySettingService companySettingService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping
    public List<CompanySetting> getAllCompanySettings() {
        return companySettingService.getAllCompanySettings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanySetting> getCompanySettingById(@PathVariable Long id) {
        Optional<CompanySetting> companySetting = companySettingService.getCompanySettingById(id);
        return companySetting.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CompanySetting createCompanySetting(@RequestBody CompanySetting companySetting) {
        CompanySetting createdCompanySetting = companySettingService.createOrUpdateCompanySetting(companySetting);
        messagingTemplate.convertAndSend("/topic/company-settings", createdCompanySetting);
        return createdCompanySetting;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanySetting> updateCompanySetting(@PathVariable Long id, @RequestBody CompanySetting companySettingDetails) {
        Optional<CompanySetting> companySetting = companySettingService.getCompanySettingById(id);
        if (companySetting.isPresent()) {
            CompanySetting updatedCompanySetting = companySetting.get();
            updatedCompanySetting.setEnableSizeWiseStock(companySettingDetails.getEnableSizeWiseStock());
            updatedCompanySetting.setGodownSiteWiseStock(companySettingDetails.getGodownSiteWiseStock());
            updatedCompanySetting.setSmsVia(companySettingDetails.getSmsVia());
            updatedCompanySetting.setDefaultMargin(companySettingDetails.getDefaultMargin());
            updatedCompanySetting.setRoundTotalForTransactionScreens(companySettingDetails.getRoundTotalForTransactionScreens());
            updatedCompanySetting.setMultiplePriceList(companySettingDetails.getMultiplePriceList());
            updatedCompanySetting.setStockAlertInOrderForm(companySettingDetails.getStockAlertInOrderForm());
            updatedCompanySetting.setStopOrderIfNoStock(companySettingDetails.getStopOrderIfNoStock());
            updatedCompanySetting.setStockAlertInSalesForm(companySettingDetails.getStockAlertInSalesForm());
            updatedCompanySetting.setStopSalesIfNoStock(companySettingDetails.getStopSalesIfNoStock());
            updatedCompanySetting.setMonthWiseTransactionNo(companySettingDetails.getMonthWiseTransactionNo());
            updatedCompanySetting.setCreditnoteNoSameAsSalesreturnNo(companySettingDetails.getCreditnoteNoSameAsSalesreturnNo());
            updatedCompanySetting.setInvoiceNoSameAsChallanNo(companySettingDetails.getInvoiceNoSameAsChallanNo());
            updatedCompanySetting.setContinuousInvoiceNo(companySettingDetails.getContinuousInvoiceNo());
            updatedCompanySetting.setContinuousCNNo(companySettingDetails.getContinuousCNNo());
            updatedCompanySetting.setTaxesIncludedInRate(companySettingDetails.getTaxesIncludedInRate());
            updatedCompanySetting.setBarcodeRows(companySettingDetails.getBarcodeRows());
            updatedCompanySetting.setBarcodeCols(companySettingDetails.getBarcodeCols());
            updatedCompanySetting.setGodownSiteWiseTransactionNo(companySettingDetails.getGodownSiteWiseTransactionNo());

            CompanySetting updatedEntity = companySettingService.createOrUpdateCompanySetting(updatedCompanySetting);
            messagingTemplate.convertAndSend("/topic/company-settings", updatedEntity);
            return ResponseEntity.ok(updatedEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanySetting(@PathVariable Long id) {
        companySettingService.deleteCompanySetting(id);
        messagingTemplate.convertAndSend("/topic/company-settings", id);
        return ResponseEntity.ok().build();
    }
}
