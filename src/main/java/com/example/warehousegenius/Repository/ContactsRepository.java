package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Long> {

}
