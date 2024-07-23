package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.Address;
import com.example.warehousegenius.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // GET method to fetch all addresses
    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    // GET method to fetch an address by ID
    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Optional<Address> address = addressService.getAddressById(id);
        return address.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // POST method to create an address
    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address createdAddress = addressService.saveAddress(address);
        messagingTemplate.convertAndSend("/topic/addresses", createdAddress);
        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }

    // PUT method to update an address
    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address addressDetails) {
        Optional<Address> existingAddress = addressService.getAddressById(id);
        if (existingAddress.isPresent()) {
            Address updatedAddress = existingAddress.get();
            updatedAddress.setAccountHead(addressDetails.getAccountHead());
            updatedAddress.setAddressName(addressDetails.getAddressName());
            updatedAddress.setPrimary(addressDetails.isPrimary());
            updatedAddress.setLine1(addressDetails.getLine1());
            updatedAddress.setLine2(addressDetails.getLine2());
            updatedAddress.setCity(addressDetails.getCity());
            updatedAddress.setState(addressDetails.getState());
            updatedAddress.setCountry(addressDetails.getCountry());
            updatedAddress.setPincode(addressDetails.getPincode());
            updatedAddress.setArea(addressDetails.getArea());
            updatedAddress.setLandline(addressDetails.getLandline());
            updatedAddress.setFax(addressDetails.getFax());
            updatedAddress.setEmail(addressDetails.getEmail());
            updatedAddress.setDefaultTax(addressDetails.getDefaultTax());
            updatedAddress.setVatNo(addressDetails.getVatNo());
            updatedAddress.setCstNo(addressDetails.getCstNo());
            updatedAddress.setTinNo(addressDetails.getTinNo());
            updatedAddress.setLbtNo(addressDetails.getLbtNo());
            updatedAddress.setDefaultTransport(addressDetails.getDefaultTransport());

            Address savedAddress = addressService.saveAddress(updatedAddress);
            messagingTemplate.convertAndSend("/topic/addresses", savedAddress);
            return ResponseEntity.ok(savedAddress);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE method to delete an address
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        messagingTemplate.convertAndSend("/topic/addresses", id);
        return ResponseEntity.ok().build();
    }
}
