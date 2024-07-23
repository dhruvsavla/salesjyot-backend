package com.example.warehousegenius.Entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "add_size_range")
public class AddSizeRange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addSizeRangeId;

    @Column(name = "size_range")
    private String sizeRange;

    @Column(name = "is_primary")
    private Boolean isPrimary;

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
    @OneToMany(mappedBy = "addSizeRange", cascade = CascadeType.ALL)
    private List<SizeAlias> sizeAliases;

    @JsonIgnore
    @OneToMany(mappedBy = "addSizeRange")
    private List<Product> products;

    public AddSizeRange(){
        
    }

    public AddSizeRange(Long addSizeRangeId, String sizeRange, Boolean isPrimary) {
        this.addSizeRangeId = addSizeRangeId;
        this.sizeRange = sizeRange;
        this.isPrimary = isPrimary;
    }

    public Long getAddSizeRangeId() {
        return addSizeRangeId;
    }

    public void setAddSizeRangeId(Long addSizeRangeeId) {
        this.addSizeRangeId = addSizeRangeId;
    }

    public String getSizeRange() {
        return sizeRange;
    }

    public void setSizeRange(String sizeRange) {
        this.sizeRange = sizeRange;
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
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

    public List<SizeAlias> getSizeAliases() {
        return sizeAliases;
    }

    public void setSizeAliases(List<SizeAlias> sizeAliases) {
        this.sizeAliases = sizeAliases;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString(){
        return this.addSizeRangeId + " " + this.sizeRange;
    }

}
