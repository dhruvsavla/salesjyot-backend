package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.AddSize;
import com.example.warehousegenius.Service.AddSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/add-sizes")
public class AddSizeController {

    private final AddSizeService addSizeService;
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public AddSizeController(AddSizeService addSizeService, SimpMessagingTemplate messagingTemplate) {
        this.addSizeService = addSizeService;
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping
    public ResponseEntity<List<AddSize>> getAllAddSizes() {
        List<AddSize> addSizes = addSizeService.getAllAddSizes();
        return new ResponseEntity<>(addSizes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddSize> getAddSizeById(@PathVariable Long id) {
        Optional<AddSize> addSize = addSizeService.getAddSizeById(id);
        return addSize.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AddSize> createAddSize(@RequestBody AddSize addSize) {
        AddSize createdAddSize = addSizeService.saveAddSize(addSize);
        messagingTemplate.convertAndSend("/topic/add-sizes", createdAddSize); // WebSocket notification
        return new ResponseEntity<>(createdAddSize, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddSize> updateAddSize(@PathVariable Long id, @RequestBody AddSize addSizeDetails) {
        Optional<AddSize> existingAddSize = addSizeService.getAddSizeById(id);
        if (existingAddSize.isPresent()) {
            AddSize updatedAddSize = existingAddSize.get();
            updatedAddSize.setSize(addSizeDetails.getSize());
            updatedAddSize.setPosition(addSizeDetails.getPosition());

            AddSize savedAddSize = addSizeService.saveAddSize(updatedAddSize);
            messagingTemplate.convertAndSend("/topic/add-sizes", savedAddSize); // WebSocket notification
            return ResponseEntity.ok(savedAddSize);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddSize(@PathVariable Long id) {
        addSizeService.deleteAddSize(id);
        messagingTemplate.convertAndSend("/topic/add-sizes", id); // WebSocket notification
        return ResponseEntity.ok().build();
    }
}
