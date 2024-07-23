package com.example.warehousegenius.Repository;

import com.example.warehousegenius.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserEmail(String email);
    User findByUserEmailAndAndPassword(String email, String password);
}

