package com.example.warehousegenius.Service;

import com.example.warehousegenius.Entity.AddSizeRange;
import com.example.warehousegenius.Entity.SizeAlias;
import com.example.warehousegenius.Repository.SizeAliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeAliasService {

    @Autowired
    private SizeAliasRepository sizeAliasRepository;

    @Autowired
    private AddSizeRangeService addSizeRangeService;

    public List<SizeAlias> getAllSizeAliases() {
        return sizeAliasRepository.findAll();
    }

    public SizeAlias getSizeAliasById(Long id) {
        Optional<SizeAlias> optionalSizeAlias = sizeAliasRepository.findById(id);
        return optionalSizeAlias.orElse(null);
    }

    public SizeAlias createSizeAlias(SizeAlias sizeAlias) {
        AddSizeRange sizeRange = addSizeRangeService.getSizeRangeByName(sizeAlias.getAddSizeRange().getSizeRange());
        sizeAlias.setAddSizeRange(sizeRange);
        return sizeAliasRepository.save(sizeAlias);
    }

    public SizeAlias updateSizeAlias(Long id, SizeAlias sizeAlias) {
        Optional<SizeAlias> optionalSizeAlias = sizeAliasRepository.findById(id);
        if (optionalSizeAlias.isPresent()) {
            SizeAlias existingSizeAlias = optionalSizeAlias.get();
            existingSizeAlias.setAlias(sizeAlias.getAlias());
            existingSizeAlias.setAddSizeRange(sizeAlias.getAddSizeRange());
            existingSizeAlias.setAddSize(sizeAlias.getAddSize());
            return sizeAliasRepository.save(existingSizeAlias);
        }
        return null;
    }

    public void deleteSizeAlias(Long id) {
        sizeAliasRepository.deleteById(id);
    }
}
