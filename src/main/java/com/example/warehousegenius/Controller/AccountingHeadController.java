package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.AccountingHead;
import com.example.warehousegenius.Service.AccountingHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Adjust origin URL as needed
@RequestMapping("/api/accounting-heads")
public class AccountingHeadController {

    @Autowired
    private AccountingHeadService accountingHeadService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // GET method to fetch all accounting heads
    @GetMapping
    public List<AccountingHead> getAllAccountingHeads() {
        return accountingHeadService.getAllAccountingHeads();
    }

    // POST method to create an accounting head
    @PostMapping
    public ResponseEntity<AccountingHead> createAccountingHead(@RequestBody AccountingHead accountingHead) {
        AccountingHead createdAccountingHead = accountingHeadService.saveAccountingHead(accountingHead);
        return new ResponseEntity<>(createdAccountingHead, HttpStatus.CREATED);
    }

    // PUT method to update an accounting head
    @PutMapping("/{id}")
    public ResponseEntity<AccountingHead> updateAccountingHead(@PathVariable Long id, @RequestBody AccountingHead accountingHeadDetails) {
        Optional<AccountingHead> accountingHead = accountingHeadService.getAccountingHeadById(id);
        if (accountingHead.isPresent()) {
            AccountingHead updatedAccountingHead = accountingHead.get();
            updatedAccountingHead.setAccountName(accountingHeadDetails.getAccountName());
            updatedAccountingHead.setDisplayName(accountingHeadDetails.getDisplayName());
            updatedAccountingHead.setParentAccount(accountingHeadDetails.getParentAccount());
            updatedAccountingHead.setDisplayInTrialBalance(accountingHeadDetails.isDisplayInTrialBalance());
            updatedAccountingHead.setTrialBalanceSide(accountingHeadDetails.getTrialBalanceSide());
            updatedAccountingHead.setDisplayInPnl(accountingHeadDetails.isDisplayInPnl());
            updatedAccountingHead.setPnlSide(accountingHeadDetails.getPnlSide());

            // Update related entities if needed (customer, tax, bankAccount)
            updatedAccountingHead.setCustomer(accountingHeadDetails.getCustomer());
            updatedAccountingHead.setTax(accountingHeadDetails.getTax());
            updatedAccountingHead.setBankAccount(accountingHeadDetails.getBankAccount());

            // Save updated accounting head
            AccountingHead savedAccountingHead = accountingHeadService.saveAccountingHead(updatedAccountingHead);

            // Send WebSocket update message
            messagingTemplate.convertAndSend("/topic/accounting-heads", savedAccountingHead);

            return ResponseEntity.ok(savedAccountingHead);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE method to delete an accounting head
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountingHead(@PathVariable Long id) {
        accountingHeadService.deleteAccountingHead(id);

        // Send WebSocket delete message
        messagingTemplate.convertAndSend("/topic/accounting-heads/delete", id);

        return ResponseEntity.ok().build();
    }

    // GET method to fetch an accounting head by ID
    @GetMapping("/{id}")
    public ResponseEntity<AccountingHead> getAccountingHeadById(@PathVariable Long id) {
        Optional<AccountingHead> accountingHead = accountingHeadService.getAccountingHeadById(id);
        return accountingHead.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
