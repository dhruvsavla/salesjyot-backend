package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.BankMaster;
import com.example.warehousegenius.Service.BankMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/banks")
public class BankMasterController {

    @Autowired
    private BankMasterService bankMasterService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // GET method to fetch all banks
    @GetMapping
    public List<BankMaster> getAllBanks() {
        return bankMasterService.getAllBanks();
    }

    // POST method to create a bank
    @PostMapping
    public BankMaster createBank(@RequestBody BankMaster bank) {
        BankMaster createdBank = bankMasterService.createOrUpdateBank(bank);
        messagingTemplate.convertAndSend("/topic/banks", createdBank);
        return createdBank;
    }

    // PUT method to update a bank
    @PutMapping("/{id}")
    public ResponseEntity<BankMaster> updateBank(@PathVariable Long id, @RequestBody BankMaster bankDetails) {
        Optional<BankMaster> bank = bankMasterService.getBankById(id);
        if (bank.isPresent()) {
            BankMaster updatedBank = bank.get();
            updatedBank.setBankName(bankDetails.getBankName());
            updatedBank.setAccountNo(bankDetails.getAccountNo());
            updatedBank.setCompany(bankDetails.getCompany());

            messagingTemplate.convertAndSend("/topic/banks", updatedBank);
            return ResponseEntity.ok(bankMasterService.createOrUpdateBank(updatedBank));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE method to delete a bank
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable Long id) {
        bankMasterService.deleteBank(id);
        messagingTemplate.convertAndSend("/topic/banks", id);
        return ResponseEntity.ok().build();
    }
}
