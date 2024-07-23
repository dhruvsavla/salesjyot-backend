package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.MonthWiseSetting;
import com.example.warehousegenius.Service.MonthWiseSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Adjust the origin URL as needed
@RequestMapping("/api/monthwise-settings")
public class MonthWiseSettingController {

    @Autowired
    private MonthWiseSettingService monthWiseSettingService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping
    public ResponseEntity<List<MonthWiseSetting>> getAllMonthWiseSettings() {
        List<MonthWiseSetting> monthWiseSettings = monthWiseSettingService.getAllMonthWiseSettings();
        return new ResponseEntity<>(monthWiseSettings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonthWiseSetting> getMonthWiseSettingById(@PathVariable Long id) {
        Optional<MonthWiseSetting> monthWiseSetting = monthWiseSettingService.getMonthWiseSettingById(id);
        return monthWiseSetting.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MonthWiseSetting> createMonthWiseSetting(@RequestBody MonthWiseSetting monthWiseSetting) {
        MonthWiseSetting createdMonthWiseSetting = monthWiseSettingService.saveMonthWiseSetting(monthWiseSetting);
        sendWebSocketUpdate(createdMonthWiseSetting);
        return new ResponseEntity<>(createdMonthWiseSetting, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonthWiseSetting> updateMonthWiseSetting(@PathVariable Long id, @RequestBody MonthWiseSetting monthWiseSettingDetails) {
        Optional<MonthWiseSetting> monthWiseSetting = monthWiseSettingService.getMonthWiseSettingById(id);
        if (monthWiseSetting.isPresent()) {
            MonthWiseSetting updatedMonthWiseSetting = monthWiseSetting.get();
            // Update fields here
            updatedMonthWiseSetting.setCompany(monthWiseSettingDetails.getCompany());
            updatedMonthWiseSetting.setSite(monthWiseSettingDetails.getSite());
            updatedMonthWiseSetting.setFinancialYear(monthWiseSettingDetails.getFinancialYear());
            updatedMonthWiseSetting.setSalesChallanNo(monthWiseSettingDetails.getSalesChallanNo());
            updatedMonthWiseSetting.setSalesInvoiceNo(monthWiseSettingDetails.getSalesInvoiceNo());
            updatedMonthWiseSetting.setPurchaseChallanNo(monthWiseSettingDetails.getPurchaseChallanNo());
            updatedMonthWiseSetting.setSalesReturnNo(monthWiseSettingDetails.getSalesReturnNo());
            updatedMonthWiseSetting.setCreditNoteNo(monthWiseSettingDetails.getCreditNoteNo());
            updatedMonthWiseSetting.setPurchaseReturnChallanNo(monthWiseSettingDetails.getPurchaseReturnChallanNo());
            updatedMonthWiseSetting.setOrderFormNo(monthWiseSettingDetails.getOrderFormNo());
            updatedMonthWiseSetting.setPurchaseOrderNo(monthWiseSettingDetails.getPurchaseOrderNo());
            updatedMonthWiseSetting.setProcessEntryNo(monthWiseSettingDetails.getProcessEntryNo());
            updatedMonthWiseSetting.setStockEntryNo(monthWiseSettingDetails.getStockEntryNo());
            updatedMonthWiseSetting.setStockConversionEntryNo(monthWiseSettingDetails.getStockConversionEntryNo());
            updatedMonthWiseSetting.setVoucherEntryNo(monthWiseSettingDetails.getVoucherEntryNo());
            updatedMonthWiseSetting.setCuttingEntryNo(monthWiseSettingDetails.getCuttingEntryNo());
            updatedMonthWiseSetting.setOrderCancellationFormNo(monthWiseSettingDetails.getOrderCancellationFormNo());

            MonthWiseSetting updatedEntity = monthWiseSettingService.saveMonthWiseSetting(updatedMonthWiseSetting);
            sendWebSocketUpdate(updatedEntity);
            return ResponseEntity.ok(updatedEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMonthWiseSetting(@PathVariable Long id) {
        monthWiseSettingService.deleteMonthWiseSetting(id);
        sendWebSocketDelete(id);
        return ResponseEntity.ok().build();
    }

    // Helper method to send WebSocket update message
    private void sendWebSocketUpdate(MonthWiseSetting updatedMonthWiseSetting) {
        messagingTemplate.convertAndSend("/topic/monthwise-settings/update", updatedMonthWiseSetting);
    }

    // Helper method to send WebSocket delete message
    private void sendWebSocketDelete(Long id) {
        messagingTemplate.convertAndSend("/topic/monthwise-settings/delete", id);
    }
}
