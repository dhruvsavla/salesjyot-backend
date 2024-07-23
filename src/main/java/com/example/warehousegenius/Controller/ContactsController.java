package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.Contacts;
import com.example.warehousegenius.Service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/contacts")
public class ContactsController {

    @Autowired
    private ContactsService contactsService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // GET method to fetch all Contacts
    @GetMapping
    public List<Contacts> getAllContacts() {
        return contactsService.getAllContacts();
    }

    // GET method to fetch a Contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<Contacts> getContactById(@PathVariable Long id) {
        Optional<Contacts> contact = contactsService.getContactById(id);
        return contact.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST method to create a new Contact
    @PostMapping
    public Contacts createContact(@RequestBody Contacts contact) {
        Contacts createdContact = contactsService.createOrUpdateContact(contact);
        messagingTemplate.convertAndSend("/topic/contacts", createdContact);
        return createdContact;
    }

    // PUT method to update an existing Contact
    @PutMapping("/{id}")
    public ResponseEntity<Contacts> updateContact(@PathVariable Long id, @RequestBody Contacts contactDetails) {
        Optional<Contacts> contact = contactsService.getContactById(id);
        if (contact.isPresent()) {
            Contacts updatedContact = contact.get();
            updatedContact.setCustomer(contactDetails.getCustomer());
            updatedContact.setName(contactDetails.getName());
            updatedContact.setIsPrimary(contactDetails.getIsPrimary());
            updatedContact.setDesignation(contactDetails.getDesignation());
            updatedContact.setAddresses(contactDetails.getAddresses());
            updatedContact.setLandline(contactDetails.getLandline());
            updatedContact.setMobile(contactDetails.getMobile());
            updatedContact.setFax(contactDetails.getFax());
            updatedContact.setEmail(contactDetails.getEmail());

            Contacts savedContact = contactsService.createOrUpdateContact(updatedContact);
            messagingTemplate.convertAndSend("/topic/contacts", savedContact);
            return ResponseEntity.ok(savedContact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE method to delete a Contact
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        try {
            contactsService.deleteContact(id);
            messagingTemplate.convertAndSend("/topic/contacts", id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
