package com.example.warehousegenius.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.warehousegenius.Entity.ProductPriceList;
import com.example.warehousegenius.Repository.ProductPriceListRepository;

@Service
public class ProductPriceListService {

    @Autowired
    private ProductPriceListRepository productPriceListRepository;

    public List<ProductPriceList> getAllProductPriceLists() {
        return productPriceListRepository.findAll();
    }

    public Optional<ProductPriceList> getProductPriceListById(Long id) {
        return productPriceListRepository.findById(id);
    }

    public ProductPriceList createProductPriceList(ProductPriceList productPriceList) {
        return productPriceListRepository.save(productPriceList);
    }

    public Optional<ProductPriceList> updateProductPriceList(Long id, ProductPriceList productPriceListDetails) {
        return productPriceListRepository.findById(id).map(existingProductPriceList -> {
            existingProductPriceList.setProduct(productPriceListDetails.getProduct());
            existingProductPriceList.setPriceList(productPriceListDetails.getPriceList());
            existingProductPriceList.setSize(productPriceListDetails.getSize());
            existingProductPriceList.setCostPrice(productPriceListDetails.getCostPrice());
            existingProductPriceList.setSellingPrice(productPriceListDetails.getSellingPrice());
            existingProductPriceList.setMrp(productPriceListDetails.getMrp());
            return productPriceListRepository.save(existingProductPriceList);
        });
    }

    public boolean deleteProductPriceList(Long id) {
        if (productPriceListRepository.existsById(id)) {
            productPriceListRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
