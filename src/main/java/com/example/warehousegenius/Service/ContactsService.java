package com.example.warehousegenius.Service;

import com.example.warehousegenius.Entity.Contacts;
import com.example.warehousegenius.Repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactsService {

    @Autowired
    private ContactsRepository contactsRepository;

    public List<Contacts> getAllContacts() {
        return contactsRepository.findAll();
    }

    public Optional<Contacts> getContactById(Long id) {
        return contactsRepository.findById(id);
    }

    public Contacts createOrUpdateContact(Contacts contact) {
        return contactsRepository.save(contact);
    }

    public void deleteContact(Long id) {
        contactsRepository.deleteById(id);
    }
}
