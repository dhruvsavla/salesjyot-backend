package com.example.warehousegenius.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_price_list")
public class ProductPriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "pricelist_id")
    private PriceListMaster priceList;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private AddSize size;

    @Column(name = "cost_price")
    private Double costPrice;

    @Column(name = "selling_price")
    private Double sellingPrice;

    @Column(name = "mrp")
    private Double mrp;

    public ProductPriceList(){
        
    }

    public ProductPriceList(Long id, Product product, PriceListMaster priceList, AddSize size, Double costPrice,
            Double sellingPrice, Double mrp) {
        this.id = id;
        this.product = product;
        this.priceList = priceList;
        this.size = size;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.mrp = mrp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PriceListMaster getPriceList() {
        return priceList;
    }

    public void setPriceList(PriceListMaster priceList) {
        this.priceList = priceList;
    }

    public AddSize getSize() {
        return size;
    }

    public void setSize(AddSize size) {
        this.size = size;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Double getMrp() {
        return mrp;
    }

    public void setMrp(Double mrp) {
        this.mrp = mrp;
    }

}

