package com.example.warehousegenius.Service;

import com.example.warehousegenius.Entity.AddSize;
import com.example.warehousegenius.Repository.AddSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddSizeService {

    private final AddSizeRepository addSizeRepository;

    @Autowired
    public AddSizeService(AddSizeRepository addSizeRepository) {
        this.addSizeRepository = addSizeRepository;
    }

    public List<AddSize> getAllAddSizes() {
        return addSizeRepository.findAll();
    }

    public Optional<AddSize> getAddSizeById(Long id) {
        return addSizeRepository.findById(id);
    }

    public AddSize saveAddSize(AddSize addSize) {
        return addSizeRepository.save(addSize);
    }

    public void deleteAddSize(Long id) {
        addSizeRepository.deleteById(id);
    }
}
