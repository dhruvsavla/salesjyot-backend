package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.UserScreenRights;
import com.example.warehousegenius.Service.UserScreenRightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-screen-rights")
public class UserScreenRightsController {

    @Autowired
    private UserScreenRightsService userScreenRightsService;

    @GetMapping
    public List<UserScreenRights> getAllUserScreenRights() {
        return userScreenRightsService.getAllUserScreenRights();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserScreenRights> getUserScreenRightsById(@PathVariable Long id) {
        Optional<UserScreenRights> userScreenRights = userScreenRightsService.getUserScreenRightsById(id);
        if (userScreenRights.isPresent()) {
            return ResponseEntity.ok(userScreenRights.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public UserScreenRights createUserScreenRights(@RequestBody UserScreenRights userScreenRights) {
        return userScreenRightsService.createUserScreenRights(userScreenRights);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserScreenRights> updateUserScreenRights(@PathVariable Long id, @RequestBody UserScreenRights userScreenRightsDetails) {
        UserScreenRights updatedUserScreenRights = userScreenRightsService.updateUserScreenRights(id, userScreenRightsDetails);
        if (updatedUserScreenRights != null) {
            return ResponseEntity.ok(updatedUserScreenRights);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserScreenRights(@PathVariable Long id) {
        userScreenRightsService.deleteUserScreenRights(id);
        return ResponseEntity.noContent().build();
    }
}

