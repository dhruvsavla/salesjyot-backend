package com.example.warehousegenius.Controller;

import com.example.warehousegenius.Entity.UserPreferences;
import com.example.warehousegenius.Service.UserPreferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Adjust the origin URL as needed
@RequestMapping("/api/user-preferences")
public class UserPreferencesController {

    @Autowired
    private UserPreferencesService userPreferencesService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping
    public List<UserPreferences> getAllUserPreferences() {
        return userPreferencesService.getAllUserPreferences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserPreferences> getUserPreferencesById(@PathVariable Long id) {
        Optional<UserPreferences> userPreferences = userPreferencesService.getUserPreferencesById(id);
        return userPreferences.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserPreferences createUserPreferences(@RequestBody UserPreferences userPreferences) {
        UserPreferences createdUserPreferences = userPreferencesService.createOrUpdateUserPreferences(userPreferences);
        messagingTemplate.convertAndSend("/topic/user-preferences", createdUserPreferences);
        return createdUserPreferences;
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserPreferences> updateUserPreferences(@PathVariable Long id, @RequestBody UserPreferences userPreferencesDetails) {
        Optional<UserPreferences> userPreferences = userPreferencesService.getUserPreferencesById(id);
        if (userPreferences.isPresent()) {
            UserPreferences updatedUserPreferences = userPreferences.get();
            updatedUserPreferences.setViewDashboardOnStart(userPreferencesDetails.getViewDashboardOnStart());
            updatedUserPreferences.setPasswordExpiresInDays(userPreferencesDetails.getPasswordExpiresInDays());
            updatedUserPreferences.setEnableReminders(userPreferencesDetails.getEnableReminders());

            UserPreferences updatedEntity = userPreferencesService.createOrUpdateUserPreferences(updatedUserPreferences);
            messagingTemplate.convertAndSend("/topic/user-preferences", updatedEntity);
            return ResponseEntity.ok(updatedEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserPreferences(@PathVariable Long id) {
        userPreferencesService.deleteUserPreferences(id);
        messagingTemplate.convertAndSend("/topic/user-preferences", id);
        return ResponseEntity.ok().build();
    }
}
