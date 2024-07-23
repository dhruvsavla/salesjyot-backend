package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.TaxForm;
import com.example.warehousegenius.Service.TaxFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/taxForms")
public class TaxFormController {

    @Autowired
    private TaxFormService taxFormService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // GET method to fetch all tax forms
    @GetMapping
    public List<TaxForm> getAllTaxForms() {
        return taxFormService.getAllTaxForms();
    }

    // POST method to create a tax form
    @PostMapping
    public TaxForm createTaxForm(@RequestBody TaxForm taxForm) {
        TaxForm createdTaxForm = taxFormService.saveTaxForm(taxForm);
        messagingTemplate.convertAndSend("/topic/taxForms", createdTaxForm);
        return createdTaxForm;
    }

    // PUT method to update a tax form
    @PutMapping("/{id}")
    public ResponseEntity<TaxForm> updateTaxForm(@PathVariable Long id, @RequestBody TaxForm taxFormDetails) {
        Optional<TaxForm> taxForm = taxFormService.getTaxFormById(id);
        if (taxForm.isPresent()) {
            TaxForm existingTaxForm = taxForm.get();
            existingTaxForm.setTaxFormName(taxFormDetails.getTaxFormName());
            existingTaxForm.setFromDate(taxFormDetails.getFromDate());
            existingTaxForm.setToDate(taxFormDetails.getToDate());
            existingTaxForm.setMinSales(taxFormDetails.getMinSales());
            existingTaxForm.setMaxSales(taxFormDetails.getMaxSales());
            existingTaxForm.setTaxPct(taxFormDetails.getTaxPct());
            existingTaxForm.setTaxMasters(taxFormDetails.getTaxMasters());
            existingTaxForm.setHsns(taxFormDetails.getHsns());

            TaxForm updatedTaxForm = taxFormService.saveTaxForm(existingTaxForm);
            messagingTemplate.convertAndSend("/topic/taxForms", updatedTaxForm);
            return ResponseEntity.ok(updatedTaxForm);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE method to delete a tax form
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaxForm(@PathVariable Long id) {
        try {
            taxFormService.deleteTaxForm(id);
            messagingTemplate.convertAndSend("/topic/taxForms", id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
