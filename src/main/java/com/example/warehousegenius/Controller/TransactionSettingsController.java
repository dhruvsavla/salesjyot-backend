package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.TransactionSettings;
import com.example.warehousegenius.Service.TransactionSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Adjust the origin URL as needed
@RequestMapping("/api/transaction-settings")
public class TransactionSettingsController {

    @Autowired
    private TransactionSettingsService transactionSettingsService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping
    public List<TransactionSettings> getAllTransactionSettings() {
        return transactionSettingsService.getAllTransactionSettings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionSettings> getTransactionSettingsById(@PathVariable Long id) {
        Optional<TransactionSettings> transactionSettings = transactionSettingsService.getTransactionSettingsById(id);
        return transactionSettings.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TransactionSettings> createTransactionSettings(@RequestBody TransactionSettings transactionSettings) {
        TransactionSettings createdTransactionSettings = transactionSettingsService.saveTransactionSettings(transactionSettings);
        sendWebSocketUpdate(createdTransactionSettings);
        return new ResponseEntity<>(createdTransactionSettings, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionSettings> updateTransactionSettings(@PathVariable Long id, @RequestBody TransactionSettings transactionSettingsDetails) {
        Optional<TransactionSettings> transactionSettings = transactionSettingsService.getTransactionSettingsById(id);
        if (transactionSettings.isPresent()) {
            TransactionSettings updatedTransactionSettings = transactionSettings.get();
            // Update fields here
            updatedTransactionSettings.setCompany(transactionSettingsDetails.getCompany());
            updatedTransactionSettings.setSite(transactionSettingsDetails.getSite());
            updatedTransactionSettings.setFyear(transactionSettingsDetails.getFyear());
            updatedTransactionSettings.setSalesChallanNo(transactionSettingsDetails.getSalesChallanNo());
            updatedTransactionSettings.setSalesChallanPrefix(transactionSettingsDetails.getSalesChallanPrefix());
            updatedTransactionSettings.setSalesInvoiceNo(transactionSettingsDetails.getSalesInvoiceNo());
            updatedTransactionSettings.setSalesInvoicePrefix(transactionSettingsDetails.getSalesInvoicePrefix());
            updatedTransactionSettings.setPurchaseChallanNo(transactionSettingsDetails.getPurchaseChallanNo());
            updatedTransactionSettings.setPurchaseChallanPrefix(transactionSettingsDetails.getPurchaseChallanPrefix());
            updatedTransactionSettings.setSalesReturnNo(transactionSettingsDetails.getSalesReturnNo());
            updatedTransactionSettings.setSalesReturnPrefix(transactionSettingsDetails.getSalesReturnPrefix());
            updatedTransactionSettings.setCreditNoteNo(transactionSettingsDetails.getCreditNoteNo());
            updatedTransactionSettings.setCreditNotePrefix(transactionSettingsDetails.getCreditNotePrefix());
            updatedTransactionSettings.setPurchaseReturnChallanNo(transactionSettingsDetails.getPurchaseReturnChallanNo());
            updatedTransactionSettings.setPurchaseReturnChallanPrefix(transactionSettingsDetails.getPurchaseReturnChallanPrefix());
            updatedTransactionSettings.setOrderFormNo(transactionSettingsDetails.getOrderFormNo());
            updatedTransactionSettings.setOrderFormPrefix(transactionSettingsDetails.getOrderFormPrefix());
            updatedTransactionSettings.setPurchaseOrderNo(transactionSettingsDetails.getPurchaseOrderNo());
            updatedTransactionSettings.setPurchaseOrderPrefix(transactionSettingsDetails.getPurchaseOrderPrefix());
            updatedTransactionSettings.setProcessEntryNo(transactionSettingsDetails.getProcessEntryNo());
            updatedTransactionSettings.setProcessEntryPrefix(transactionSettingsDetails.getProcessEntryPrefix());
            updatedTransactionSettings.setStockEntryNo(transactionSettingsDetails.getStockEntryNo());
            updatedTransactionSettings.setStockEntryPrefix(transactionSettingsDetails.getStockEntryPrefix());
            updatedTransactionSettings.setStockConversionEntryNo(transactionSettingsDetails.getStockConversionEntryNo());
            updatedTransactionSettings.setStockConversionEntryPrefix(transactionSettingsDetails.getStockConversionEntryPrefix());
            updatedTransactionSettings.setVoucherEntryNo(transactionSettingsDetails.getVoucherEntryNo());
            updatedTransactionSettings.setVoucherEntryPrefix(transactionSettingsDetails.getVoucherEntryPrefix());
            updatedTransactionSettings.setCuttingEntryNo(transactionSettingsDetails.getCuttingEntryNo());
            updatedTransactionSettings.setCuttingEntryPrefix(transactionSettingsDetails.getCuttingEntryPrefix());
            updatedTransactionSettings.setOrderCancellationFormNo(transactionSettingsDetails.getOrderCancellationFormNo());
            updatedTransactionSettings.setOrderCancellationFormPrefix(transactionSettingsDetails.getOrderCancellationFormPrefix());

            TransactionSettings updatedEntity = transactionSettingsService.saveTransactionSettings(updatedTransactionSettings);
            sendWebSocketUpdate(updatedEntity);
            return ResponseEntity.ok(updatedEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionSettings(@PathVariable Long id) {
        transactionSettingsService.deleteTransactionSettings(id);
        sendWebSocketDelete(id);
        return ResponseEntity.ok().build();
    }

    // Helper method to send WebSocket update message
    private void sendWebSocketUpdate(TransactionSettings updatedTransactionSettings) {
        messagingTemplate.convertAndSend("/topic/transaction-settings/update", updatedTransactionSettings);
    }

    // Helper method to send WebSocket delete message
    private void sendWebSocketDelete(Long id) {
        messagingTemplate.convertAndSend("/topic/transaction-settings/delete", id);
    }
}
