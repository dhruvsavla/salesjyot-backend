package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.AddSize;
import com.example.warehousegenius.Entity.AddSizeRange;
import com.example.warehousegenius.Entity.SizeAlias;
import com.example.warehousegenius.Service.AddSizeRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/add-sizeranges")
public class AddSizeRangeController {

    @Autowired
    private AddSizeRangeService addSizeService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // GET method to fetch all add sizes
    @GetMapping
    public List<AddSizeRange> getAllAddSizes() {
        return addSizeService.getAllAddSizes();
    }

    // POST method to create an add size
    @PostMapping
    public ResponseEntity<AddSizeRange> createAddSize(@RequestBody AddSizeRange addSize) {
        AddSizeRange createdAddSize = addSizeService.saveAddSize(addSize);
        messagingTemplate.convertAndSend("/topic/add-sizeranges", createdAddSize);
        return new ResponseEntity<>(createdAddSize, HttpStatus.CREATED);
    }

    // PUT method to update an add size
    @PutMapping("/{id}")
    public ResponseEntity<AddSizeRange> updateAddSize(@PathVariable Long id, @RequestBody AddSizeRange addSizeDetails) {
        AddSizeRange existingAddSize = addSizeService.getAddSizeById(id);
        if (existingAddSize != null) {
            existingAddSize.setSizeRange(addSizeDetails.getSizeRange());
            existingAddSize.setIsPrimary(addSizeDetails.getIsPrimary());

            AddSizeRange updatedAddSize = addSizeService.saveAddSize(existingAddSize);
            messagingTemplate.convertAndSend("/topic/add-sizeranges", updatedAddSize);
            return ResponseEntity.ok(updatedAddSize);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE method to delete an add size
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddSize(@PathVariable Long id) {
        addSizeService.deleteAddSize(id);
        messagingTemplate.convertAndSend("/topic/add-sizeranges", id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sizes")
    public List<SizeAlias> getSizes(@RequestParam Long sizeRange){
        AddSizeRange sizeRange2 = addSizeService.getAddSizeById(sizeRange);
        List<SizeAlias> sizes = new ArrayList<>();
        for (SizeAlias size : sizeRange2.getSizeAliases()){
            sizes.add(size);
        }
        return sizes;
    }

    @GetMapping("/by-size-range")
    public AddSizeRange getSizeRangeByName(@RequestParam String name) {
        return addSizeService.getSizeRangeByName(name);
    }
}
