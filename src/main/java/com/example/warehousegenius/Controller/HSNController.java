package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.HSN;
import com.example.warehousegenius.Service.HSNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/hsn")
public class HSNController {

    @Autowired
    private HSNService hsnService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // GET method to fetch all HSNs
    @GetMapping
    public List<HSN> getAllHSNs() {
        return hsnService.getAllHSNs();
    }

    // POST method to create an HSN
    @PostMapping
    public HSN createHSN(@RequestBody HSN hsn) {
        HSN createdHSN = hsnService.saveHSN(hsn);
        messagingTemplate.convertAndSend("/topic/hsn", createdHSN);
        return createdHSN;
    }

    // PUT method to update an HSN
    @PutMapping("/{id}")
    public ResponseEntity<HSN> updateHSN(@PathVariable Long id, @RequestBody HSN hsnDetails) {
        Optional<HSN> hsn = hsnService.getHSNById(id);
        if (hsn.isPresent()) {
            HSN updatedHSN = hsn.get();
            updatedHSN.setHsnCode(hsnDetails.getHsnCode());
            updatedHSN.setHsnDescription(hsnDetails.getHsnDescription());

            HSN savedHSN = hsnService.saveHSN(updatedHSN);
            messagingTemplate.convertAndSend("/topic/hsn", savedHSN);
            return ResponseEntity.ok(savedHSN);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE method to delete an HSN
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHSN(@PathVariable Long id) {
        try {
            hsnService.deleteHSN(id);
            messagingTemplate.convertAndSend("/topic/hsn", id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
