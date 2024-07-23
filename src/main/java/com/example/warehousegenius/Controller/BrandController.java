package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.Brand;
import com.example.warehousegenius.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // GET method to fetch all brands
    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    // POST method to create a brand
    @PostMapping
    public Brand createBrand(@RequestBody Brand brand) {
        Brand createdBrand = brandService.saveBrand(brand);
        messagingTemplate.convertAndSend("/topic/brands", createdBrand);
        return createdBrand;
    }

    // PUT method to update a brand
    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @RequestBody Brand brandDetails) {
        Optional<Brand> brand = brandService.getBrandById(id);
        if (brand.isPresent()) {
            Brand updatedBrand = brand.get();
            updatedBrand.setBrandName(brandDetails.getBrandName());

            Brand savedBrand = brandService.saveBrand(updatedBrand);
            messagingTemplate.convertAndSend("/topic/brands", savedBrand);
            return ResponseEntity.ok(savedBrand);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE method to delete a brand
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        try {
            brandService.deleteBrand(id);
            messagingTemplate.convertAndSend("/topic/brands", id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
