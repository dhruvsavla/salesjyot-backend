package com.example.warehousegenius.Service;


import com.example.warehousegenius.Entity.UserScreenRights;
import com.example.warehousegenius.Repository.UserScreenRightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserScreenRightsService {

    @Autowired
    private UserScreenRightsRepository userScreenRightsRepository;

    public List<UserScreenRights> getAllUserScreenRights() {
        return userScreenRightsRepository.findAll();
    }

    public Optional<UserScreenRights> getUserScreenRightsById(Long id) {
        return userScreenRightsRepository.findById(id);
    }

    public UserScreenRights createUserScreenRights(UserScreenRights userScreenRights) {
        return userScreenRightsRepository.save(userScreenRights);
    }

    public UserScreenRights updateUserScreenRights(Long id, UserScreenRights userScreenRightsDetails) {
        Optional<UserScreenRights> userScreenRights = userScreenRightsRepository.findById(id);

        if (userScreenRights.isPresent()) {
            UserScreenRights existingUserScreenRights = userScreenRights.get();
            existingUserScreenRights.setSite(userScreenRightsDetails.getSite());
            existingUserScreenRights.setUser(userScreenRightsDetails.getUser());
            existingUserScreenRights.setScreen(userScreenRightsDetails.getScreen());
            existingUserScreenRights.setCanView(userScreenRightsDetails.isCanView());
            existingUserScreenRights.setCanAdd(userScreenRightsDetails.isCanAdd());
            existingUserScreenRights.setCanEdit(userScreenRightsDetails.isCanEdit());
            existingUserScreenRights.setCanDelete(userScreenRightsDetails.isCanDelete());
            existingUserScreenRights.setCanPrint(userScreenRightsDetails.isCanPrint());
            existingUserScreenRights.setCanExport(userScreenRightsDetails.isCanExport());
            return userScreenRightsRepository.save(existingUserScreenRights);
        } else {
            return null;
        }
    }

    public void deleteUserScreenRights(Long id) {
        userScreenRightsRepository.deleteById(id);
    }
}

