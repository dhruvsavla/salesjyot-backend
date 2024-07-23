package com.example.warehousegenius.Service;

import com.example.warehousegenius.Entity.AddRack;
import com.example.warehousegenius.Repository.AddRackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddRackService {

    private final AddRackRepository addRackRepository;

    @Autowired
    public AddRackService(AddRackRepository addRackRepository) {
        this.addRackRepository = addRackRepository;
    }

    public List<AddRack> getAllRacks() {
        return addRackRepository.findAll();
    }

    public Optional<AddRack> getRackById(Long id) {
        return addRackRepository.findById(id);
    }

    public AddRack createOrUpdateRack(AddRack rack) {
        return addRackRepository.save(rack);
    }

    public void deleteRack(Long id) {
        addRackRepository.deleteById(id);
    }
}
