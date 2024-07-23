package com.example.warehousegenius.Service;

import com.example.warehousegenius.Entity.AddSizeRange;
import com.example.warehousegenius.Repository.AddSizeRangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddSizeRangeService{

    @Autowired
    private AddSizeRangeRepository addSizeRepository;

    public AddSizeRange saveAddSize(AddSizeRange addSize) {
        return addSizeRepository.save(addSize);
    }

    public AddSizeRange getAddSizeById(Long id) {
        Optional<AddSizeRange> optionalAddSize = addSizeRepository.findById(id);
        return optionalAddSize.orElse(null);
    }

    public List<AddSizeRange> getAllAddSizes() {
        return addSizeRepository.findAll();
    }

    public void deleteAddSize(Long id) {
        addSizeRepository.deleteById(id);
    }

    public AddSizeRange getSizeRangeByName(String sizeRange) {
        return addSizeRepository.findBySizeRange(sizeRange);
    }
}
