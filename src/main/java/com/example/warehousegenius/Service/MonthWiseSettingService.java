package com.example.warehousegenius.Service;

import com.example.warehousegenius.Entity.MonthWiseSetting;
import com.example.warehousegenius.Repository.MonthWiseSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonthWiseSettingService {

    @Autowired
    private MonthWiseSettingRepository monthWiseSettingRepository;

    public List<MonthWiseSetting> getAllMonthWiseSettings() {
        return monthWiseSettingRepository.findAll();
    }

    public Optional<MonthWiseSetting> getMonthWiseSettingById(Long id) {
        return monthWiseSettingRepository.findById(id);
    }

    public MonthWiseSetting saveMonthWiseSetting(MonthWiseSetting monthWiseSetting) {
        return monthWiseSettingRepository.save(monthWiseSetting);
    }

    public void deleteMonthWiseSetting(Long id) {
        monthWiseSettingRepository.deleteById(id);
    }
}
