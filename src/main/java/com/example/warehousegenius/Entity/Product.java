package com.example.warehousegenius.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "color")
    private String color;

    @Column(name = "category")
    private String category;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @ManyToOne()
    @JoinColumn(name = "add_size_range_id")
    private AddSizeRange addSizeRange;
    
    @ManyToMany
    @JoinTable(
            name = "product_add_size",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "add_size_id")
    )
    private List<AddSize> available_sizes;

    @Column(name = "avg_price")
    private Double avgPrice;

    @Column(name = "avg_mrp")
    private Double avgMrp;

    @Column(name = "avg_cost")
    private Double avgCost;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerMaster supplier;

    @Column(name = "supplier_product_name")
    private String supplierProductName;

    @Column(name = "supplier_product_color")
    private String supplierProductColor;

    @Column(name = "per_box")
    private String perBox;

    @Column(name = "unit")
    private String unit;

    @Column(name = "taxes_included")
    private Boolean taxesIncluded;
    
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<ProductPriceList> productPriceLists;

    public Product(){

    }

    public Product(Long productId, String productName, String color, String category, String type, String description,
            AddSizeRange addSizeRange, List<AddSize> available_sizes, Double avgPrice, Double avgMrp, Double avgCost,
            CustomerMaster supplier, String supplierProductName, String supplierProductColor, String perBox,
            String unit, Boolean taxesIncluded, List<ProductPriceList> productPriceLists) {
        this.productId = productId;
        this.productName = productName;
        this.color = color;
        this.category = category;
        this.type = type;
        this.description = description;
        this.addSizeRange = addSizeRange;
        this.available_sizes = available_sizes;
        this.avgPrice = avgPrice;
        this.avgMrp = avgMrp;
        this.avgCost = avgCost;
        this.supplier = supplier;
        this.supplierProductName = supplierProductName;
        this.supplierProductColor = supplierProductColor;
        this.perBox = perBox;
        this.unit = unit;
        this.taxesIncluded = taxesIncluded;
        this.productPriceLists = productPriceLists;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AddSizeRange getAddSizeRange() {
        return addSizeRange;
    }

    public void setAddSizeRange(AddSizeRange addSizeRange) {
        this.addSizeRange = addSizeRange;
    }

    public List<AddSize> getAvailable_sizes() {
        return available_sizes;
    }

    public void setAvailable_sizes(List<AddSize> available_sizes) {
        this.available_sizes = available_sizes;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Double getAvgMrp() {
        return avgMrp;
    }

    public void setAvgMrp(Double avgMrp) {
        this.avgMrp = avgMrp;
    }

    public Double getAvgCost() {
        return avgCost;
    }

    public void setAvgCost(Double avgCost) {
        this.avgCost = avgCost;
    }

    public CustomerMaster getSupplier() {
        return supplier;
    }

    public void setSupplier(CustomerMaster supplier) {
        this.supplier = supplier;
    }

    public String getSupplierProductName() {
        return supplierProductName;
    }

    public void setSupplierProductName(String supplierProductName) {
        this.supplierProductName = supplierProductName;
    }

    public String getSupplierProductColor() {
        return supplierProductColor;
    }

    public void setSupplierProductColor(String supplierProductColor) {
        this.supplierProductColor = supplierProductColor;
    }

    public String getPerBox() {
        return perBox;
    }

    public void setPerBox(String perBox) {
        this.perBox = perBox;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Boolean getTaxesIncluded() {
        return taxesIncluded;
    }

    public void setTaxesIncluded(Boolean taxesIncluded) {
        this.taxesIncluded = taxesIncluded;
    }

    public List<ProductPriceList> getProductPriceLists() {
        return productPriceLists;
    }

    public void setProductPriceLists(List<ProductPriceList> productPriceLists) {
        this.productPriceLists = productPriceLists;
    }
    
}
