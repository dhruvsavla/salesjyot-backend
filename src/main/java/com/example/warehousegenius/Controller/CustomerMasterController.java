package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.CustomerMaster;
import com.example.warehousegenius.Service.CustomerMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/customers")
public class CustomerMasterController {

    private final CustomerMasterService customerMasterService;
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public CustomerMasterController(CustomerMasterService customerMasterService, SimpMessagingTemplate messagingTemplate) {
        this.customerMasterService = customerMasterService;
        this.messagingTemplate = messagingTemplate;
    }

    // GET method to fetch all customers
    @GetMapping
    public List<CustomerMaster> getAllCustomers() {
        return customerMasterService.getAllCustomers();
    }

    // GET method to fetch a customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerMaster> getCustomerById(@PathVariable("id") Long id) {
        Optional<CustomerMaster> customer = customerMasterService.getCustomerById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST method to create a customer
    @PostMapping
    public CustomerMaster createCustomer(@RequestBody CustomerMaster customer) {
        CustomerMaster createdCustomer = customerMasterService.createOrUpdateCustomer(customer);
        messagingTemplate.convertAndSend("/topic/customers", createdCustomer);
        return createdCustomer;
    }

    // PUT method to update a customer
    @PutMapping("/{id}")
    public ResponseEntity<CustomerMaster> updateCustomer(@PathVariable Long id, @RequestBody CustomerMaster customerDetails) {
        Optional<CustomerMaster> customer = customerMasterService.getCustomerById(id);
        if (customer.isPresent()) {
            CustomerMaster updatedCustomer = customer.get();
            updatedCustomer.setCustomerName(customerDetails.getCustomerName());
            updatedCustomer.setCustomerType(customerDetails.getCustomerType());
            updatedCustomer.setBroker(customerDetails.getBroker());
            updatedCustomer.setBrokerage(customerDetails.getBrokerage());
            updatedCustomer.setDiscount(customerDetails.getDiscount());
            updatedCustomer.setCreditLimitDays(customerDetails.getCreditLimitDays());
            updatedCustomer.setCreditLimitAmount(customerDetails.getCreditLimitAmount());
            updatedCustomer.setSpecialNote(customerDetails.getSpecialNote());
            updatedCustomer.setPriceList(customerDetails.getPriceList());

            messagingTemplate.convertAndSend("/topic/customers", updatedCustomer);
            return ResponseEntity.ok(customerMasterService.createOrUpdateCustomer(updatedCustomer));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE method to delete a customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        Optional<CustomerMaster> customer = customerMasterService.getCustomerById(id);
        if (customer.isPresent()) {
            customerMasterService.deleteCustomer(id);
            messagingTemplate.convertAndSend("/topic/customers", id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
