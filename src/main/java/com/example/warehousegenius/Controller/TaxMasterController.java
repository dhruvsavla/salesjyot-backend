package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.TaxMaster;
import com.example.warehousegenius.Service.TaxMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/tax")
public class TaxMasterController {

    @Autowired
    private TaxMasterService taxMasterService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // GET method to fetch all taxes
    @GetMapping
    public List<TaxMaster> getAllTaxes() {
        return taxMasterService.getAllTaxes();
    }

    // POST method to create a tax
    @PostMapping
    public TaxMaster createTax(@RequestBody TaxMaster taxMaster) {
        TaxMaster createdTax = taxMasterService.saveTax(taxMaster);
        messagingTemplate.convertAndSend("/topic/tax", createdTax);
        return createdTax;
    }

    // PUT method to update a tax
    @PutMapping("/{id}")
    public ResponseEntity<TaxMaster> updateTax(@PathVariable Long id, @RequestBody TaxMaster taxDetails) {
        Optional<TaxMaster> tax = taxMasterService.getTaxById(id);
        if (tax.isPresent()) {
            TaxMaster updatedTax = tax.get();
            updatedTax.setTaxName(taxDetails.getTaxName());
            updatedTax.setDisplayName(taxDetails.getDisplayName());
            updatedTax.setTaxPercentage(taxDetails.getTaxPercentage());

            TaxMaster savedTax = taxMasterService.saveTax(updatedTax);
            messagingTemplate.convertAndSend("/topic/tax", savedTax);
            return ResponseEntity.ok(savedTax);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE method to delete a tax
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTax(@PathVariable Long id) {
        try {
            taxMasterService.deleteTax(id);
            messagingTemplate.convertAndSend("/topic/tax", id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
