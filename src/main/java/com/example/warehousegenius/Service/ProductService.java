package com.example.warehousegenius.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.warehousegenius.Entity.AddSizeRange;
import com.example.warehousegenius.Entity.Product;
import com.example.warehousegenius.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AddSizeRangeService addSizeRangeService;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        AddSizeRange sizeRange = addSizeRangeService.getSizeRangeByName(product.getAddSizeRange().getSizeRange());
        product.setAddSizeRange(sizeRange);
        return productRepository.save(product);
    }

    public Optional<Product> updateProduct(Long id, Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setProductName(productDetails.getProductName());
            product.setColor(productDetails.getColor());
            product.setCategory(productDetails.getCategory());
            product.setType(productDetails.getType());
            product.setDescription(productDetails.getDescription());
            product.setAddSizeRange(productDetails.getAddSizeRange());
            product.setAvailable_sizes(productDetails.getAvailable_sizes());
            product.setAvgPrice(productDetails.getAvgPrice());
            product.setAvgMrp(productDetails.getAvgMrp());
            product.setAvgCost(productDetails.getAvgCost());
            product.setSupplier(productDetails.getSupplier());
            product.setSupplierProductName(productDetails.getSupplierProductName());
            product.setSupplierProductColor(productDetails.getSupplierProductColor());
            product.setPerBox(productDetails.getPerBox());
            product.setUnit(productDetails.getUnit());
            product.setTaxesIncluded(productDetails.getTaxesIncluded());
            product.setProductPriceLists(productDetails.getProductPriceLists());

            Product updatedProduct = productRepository.save(product);
            return Optional.of(updatedProduct);
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            productRepository.delete(product.get());
            return true;
        } else {
            return false;
        }
    }
}
