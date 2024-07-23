package com.example.warehousegenius.Service;

import com.example.warehousegenius.Entity.UserPreferences;
import com.example.warehousegenius.Repository.UserPreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPreferencesService {

    private final UserPreferencesRepository userPreferencesRepository;

    @Autowired
    public UserPreferencesService(UserPreferencesRepository userPreferencesRepository) {
        this.userPreferencesRepository = userPreferencesRepository;
    }

    public List<UserPreferences> getAllUserPreferences() {
        return userPreferencesRepository.findAll();
    }

    public Optional<UserPreferences> getUserPreferencesById(Long id) {
        return userPreferencesRepository.findById(id);
    }

    public UserPreferences createOrUpdateUserPreferences(UserPreferences userPreferences) {
        return userPreferencesRepository.save(userPreferences);
    }

    public void deleteUserPreferences(Long id) {
        userPreferencesRepository.deleteById(id);
    }
}
