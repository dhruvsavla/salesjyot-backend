package com.example.warehousegenius.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.warehousegenius.Entity.PriceListMaster;
import com.example.warehousegenius.Repository.PriceListMasterRepository;

@Service
public class PriceListMasterService {
    private final PriceListMasterRepository priceListMasterRepository;

    @Autowired
    public PriceListMasterService(PriceListMasterRepository priceListMasterRepository) {
        this.priceListMasterRepository = priceListMasterRepository;
    }

    public List<PriceListMaster> getAllPriceLists() {
        return priceListMasterRepository.findAll();
    }

    public Optional<PriceListMaster> getPriceListById(Long id) {
        return priceListMasterRepository.findById(id);
    }

    public PriceListMaster createOrUpdatePriceList(PriceListMaster priceList) {
        return priceListMasterRepository.save(priceList);
    }

    public void deletePriceList(Long id) {
        priceListMasterRepository.deleteById(id);
    }
}
