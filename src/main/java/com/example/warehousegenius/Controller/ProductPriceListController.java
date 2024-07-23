package com.example.warehousegenius.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import com.example.warehousegenius.Entity.ProductPriceList;
import com.example.warehousegenius.Service.ProductPriceListService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/product-price-lists")
public class ProductPriceListController {

    @Autowired
    private ProductPriceListService productPriceListService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // GET method to fetch all product price lists
    @GetMapping
    public List<ProductPriceList> getAllProductPriceLists() {
        return productPriceListService.getAllProductPriceLists();
    }

    // POST method to create a product price list
    @PostMapping
    public ProductPriceList createProductPriceList(@RequestBody ProductPriceList productPriceList) {
        ProductPriceList createdProductPriceList = productPriceListService.createProductPriceList(productPriceList);
        messagingTemplate.convertAndSend("/topic/product-price-lists", createdProductPriceList);
        return createdProductPriceList;
    }

    // PUT method to update a product price list
    @PutMapping("/{id}")
    public ResponseEntity<ProductPriceList> updateProductPriceList(@PathVariable Long id, @RequestBody ProductPriceList productPriceListDetails) {
        Optional<ProductPriceList> updatedProductPriceList = productPriceListService.updateProductPriceList(id, productPriceListDetails);
        if (updatedProductPriceList.isPresent()) {
            messagingTemplate.convertAndSend("/topic/product-price-lists", updatedProductPriceList.get());
            return ResponseEntity.ok(updatedProductPriceList.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE method to delete a product price list
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductPriceList(@PathVariable Long id) {
        boolean isDeleted = productPriceListService.deleteProductPriceList(id);
        if (isDeleted) {
            messagingTemplate.convertAndSend("/topic/product-price-lists", id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GET method to fetch a product price list by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductPriceList> getProductPriceListById(@PathVariable Long id) {
        Optional<ProductPriceList> productPriceList = productPriceListService.getProductPriceListById(id);
        return productPriceList.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
