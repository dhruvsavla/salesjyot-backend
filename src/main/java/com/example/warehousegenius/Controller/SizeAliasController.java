package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.SizeAlias;
import com.example.warehousegenius.Service.SizeAliasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/size-aliases")
public class SizeAliasController {

    private final SizeAliasService sizeAliasService;
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public SizeAliasController(SizeAliasService sizeAliasService, SimpMessagingTemplate messagingTemplate) {
        this.sizeAliasService = sizeAliasService;
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping
    public ResponseEntity<List<SizeAlias>> getAllSizeAliases() {
        List<SizeAlias> sizeAliases = sizeAliasService.getAllSizeAliases();
        return new ResponseEntity<>(sizeAliases, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SizeAlias> getSizeAliasById(@PathVariable Long id) {
        Optional<SizeAlias> sizeAlias = Optional.ofNullable(sizeAliasService.getSizeAliasById(id));
        return sizeAlias.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SizeAlias> createOrUpdateSizeAlias(@RequestBody SizeAlias sizeAlias) {
        SizeAlias createdSizeAlias = sizeAliasService.createSizeAlias(sizeAlias);
        messagingTemplate.convertAndSend("/topic/size-aliases", createdSizeAlias); // WebSocket notification
        return new ResponseEntity<>(createdSizeAlias, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SizeAlias> updateSizeAlias(@PathVariable Long id, @RequestBody SizeAlias sizeAliasDetails) {
        Optional<SizeAlias> existingSizeAlias = Optional.ofNullable(sizeAliasService.getSizeAliasById(id));
        if (existingSizeAlias.isPresent()) {
            SizeAlias updatedSizeAlias = existingSizeAlias.get();
            updatedSizeAlias.setAlias(sizeAliasDetails.getAlias());
            updatedSizeAlias.setAddSizeRange(sizeAliasDetails.getAddSizeRange());
            updatedSizeAlias.setAddSize(sizeAliasDetails.getAddSize());

            SizeAlias savedSizeAlias = sizeAliasService.updateSizeAlias(id, updatedSizeAlias);
            messagingTemplate.convertAndSend("/topic/size-aliases", savedSizeAlias); // WebSocket notification
            return ResponseEntity.ok(savedSizeAlias);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSizeAlias(@PathVariable Long id) {
        sizeAliasService.deleteSizeAlias(id);
        messagingTemplate.convertAndSend("/topic/size-aliases", id); // WebSocket notification
        return ResponseEntity.ok().build();
    }
}
