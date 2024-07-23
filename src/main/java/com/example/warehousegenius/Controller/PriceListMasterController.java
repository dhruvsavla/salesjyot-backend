package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.PriceListMaster;
import com.example.warehousegenius.Service.PriceListMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/priceLists")
public class PriceListMasterController {

    @Autowired
    private PriceListMasterService priceListMasterService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // GET method to fetch all price lists
    @GetMapping
    public List<PriceListMaster> getAllPriceLists() {
        return priceListMasterService.getAllPriceLists();
    }

    // GET method to fetch a price list by ID
    @GetMapping("/{id}")
    public ResponseEntity<PriceListMaster> getPriceListById(@PathVariable("id") Long id) {
        Optional<PriceListMaster> priceList = priceListMasterService.getPriceListById(id);
        return priceList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST method to create a new price list
    @PostMapping
    public ResponseEntity<PriceListMaster> createPriceList(@RequestBody PriceListMaster priceList) {
        PriceListMaster createdPriceList = priceListMasterService.createOrUpdatePriceList(priceList);
        messagingTemplate.convertAndSend("/topic/priceLists", createdPriceList);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPriceList);
    }

    // PUT method to update an existing price list
    @PutMapping("/{id}")
    public ResponseEntity<PriceListMaster> updatePriceList(
            @PathVariable("id") Long id,
            @RequestBody PriceListMaster priceListDetails
    ) {
        Optional<PriceListMaster> existingPriceList = priceListMasterService.getPriceListById(id);
        if (existingPriceList.isPresent()) {
            PriceListMaster updatedPriceList = existingPriceList.get();
            updatedPriceList.setPriceListName(priceListDetails.getPriceListName());
            updatedPriceList.setIsDefault(priceListDetails.getIsDefault());

            PriceListMaster savedPriceList = priceListMasterService.createOrUpdatePriceList(updatedPriceList);
            messagingTemplate.convertAndSend("/topic/priceLists", savedPriceList);
            return ResponseEntity.ok(savedPriceList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE method to delete a price list
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePriceList(@PathVariable("id") Long id) {
        Optional<PriceListMaster> priceList = priceListMasterService.getPriceListById(id);
        if (priceList.isPresent()) {
            priceListMasterService.deletePriceList(id);
            messagingTemplate.convertAndSend("/topic/priceLists", id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
