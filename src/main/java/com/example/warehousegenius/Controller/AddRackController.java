package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.AddRack;
import com.example.warehousegenius.Service.AddRackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Adjust the origin URL as needed
@RequestMapping("/api/racks")
public class AddRackController {

    private final AddRackService addRackService;
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public AddRackController(AddRackService addRackService, SimpMessagingTemplate messagingTemplate) {
        this.addRackService = addRackService;
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping
    public List<AddRack> getAllRacks() {
        return addRackService.getAllRacks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddRack> getRackById(@PathVariable Long id) {
        Optional<AddRack> rack = addRackService.getRackById(id);
        return rack.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AddRack> createRack(@RequestBody AddRack rack) {
        AddRack createdRack = addRackService.createOrUpdateRack(rack);
        messagingTemplate.convertAndSend("/topic/racks", createdRack);
        return ResponseEntity.ok(createdRack);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddRack> updateRack(@PathVariable Long id, @RequestBody AddRack rackDetails) {
        Optional<AddRack> rack = addRackService.getRackById(id);
        if (rack.isPresent()) {
            AddRack updatedRack = rack.get();
            updatedRack.setRackName(rackDetails.getRackName());
            // Set other fields if needed
            AddRack savedRack = addRackService.createOrUpdateRack(updatedRack);
            messagingTemplate.convertAndSend("/topic/racks", savedRack);
            return ResponseEntity.ok(savedRack);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRack(@PathVariable Long id) {
        addRackService.deleteRack(id);
        messagingTemplate.convertAndSend("/topic/racks", id);
        return ResponseEntity.ok().build();
    }
}
