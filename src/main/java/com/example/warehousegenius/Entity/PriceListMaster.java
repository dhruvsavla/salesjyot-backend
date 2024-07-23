package com.example.warehousegenius.Entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pricelist_master")
public class PriceListMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceListId;

    @Column(name = "pricelist_name")
    private String priceListName;

    @Column(name = "is_default")
    private Boolean isDefault;

    @OneToMany(mappedBy = "priceList")
    @JsonIgnore
    private List<CustomerMaster> customers;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "edited_by")
    private User editedBy;

    @Column(name = "edited_date")
    private Date editedDate;

    @JsonIgnore
    @OneToMany(mappedBy = "priceList")
    private List<ProductPriceList> productPriceLists;

    public PriceListMaster(){
        
    }

    public PriceListMaster(Long priceListId, String priceListName, Boolean isDefault) {
        this.priceListId = priceListId;
        this.priceListName = priceListName;
        this.isDefault = isDefault;
    }

    public Long getPriceListId() {
        return priceListId;
    }

    public void setPriceListId(Long priceListId) {
        this.priceListId = priceListId;
    }

    public String getPriceListName() {
        return priceListName;
    }

    public void setPriceListName(String priceListName) {
        this.priceListName = priceListName;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public List<CustomerMaster> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerMaster> customers) {
        this.customers = customers;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(User editedBy) {
        this.editedBy = editedBy;
    }

    public Date getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(Date editedDate) {
        this.editedDate = editedDate;
    }

    public List<ProductPriceList> getProductPriceLists() {
        return productPriceLists;
    }

    public void setProductPriceLists(List<ProductPriceList> productPriceLists) {
        this.productPriceLists = productPriceLists;
    }

}
