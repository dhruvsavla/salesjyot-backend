package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.FinancialYear;
import com.example.warehousegenius.Service.FinancialYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Adjust the origin URL as needed
@RequestMapping("/api/financial-years")
public class FinancialYearController {

    @Autowired
    private FinancialYearService financialYearService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // GET method to fetch all financial years
    @GetMapping
    public List<FinancialYear> getAllFinancialYears() {
        return financialYearService.getAllFinancialYears();
    }

    // POST method to create a financial year
    @PostMapping
    public FinancialYear createFinancialYear(@RequestBody FinancialYear financialYear) {
        FinancialYear createdFinancialYear = financialYearService.createOrUpdateFinancialYear(financialYear);
        messagingTemplate.convertAndSend("/topic/financial-years", createdFinancialYear);
        return createdFinancialYear;
    }

    // PUT method to update a financial year
    @PutMapping("/{id}")
    public ResponseEntity<FinancialYear> updateFinancialYear(@PathVariable Long id, @RequestBody FinancialYear financialYearDetails) {
        Optional<FinancialYear> financialYear = financialYearService.getFinancialYearById(id);
        if (financialYear.isPresent()) {
            FinancialYear updatedFinancialYear = financialYear.get();
            updatedFinancialYear.setFinancialYear(financialYearDetails.getFinancialYear());
            updatedFinancialYear.setStartDate(financialYearDetails.getStartDate());
            updatedFinancialYear.setEndDate(financialYearDetails.getEndDate());
            updatedFinancialYear.setClosed(financialYearDetails.getClosed());

            FinancialYear savedFinancialYear = financialYearService.createOrUpdateFinancialYear(updatedFinancialYear);
            messagingTemplate.convertAndSend("/topic/financial-years", savedFinancialYear);
            return ResponseEntity.ok(savedFinancialYear);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE method to delete a financial year
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFinancialYear(@PathVariable Long id) {
        try {
            financialYearService.deleteFinancialYear(id);
            messagingTemplate.convertAndSend("/topic/financial-years", id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
