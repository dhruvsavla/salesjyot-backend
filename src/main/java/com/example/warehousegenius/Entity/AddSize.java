package com.example.warehousegenius.Entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "add_size")
public class AddSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addSizeId;
    
    @Column(name = "size")
    private String size;

    @Column(name = "position")
    private String position;

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
    @OneToMany(mappedBy = "addSize", cascade = CascadeType.ALL)
    private List<SizeAlias> sizeAliases;

    @JsonIgnore
    @ManyToMany(mappedBy = "available_sizes")
    private List<Product> products;
    
    public AddSize() {
        
    }

    public AddSize(Long addSizeId, String size, String position) {
        this.addSizeId = addSizeId;
        this.size = size;
        this.position = position;
    }

    public Long getAddSizeId() {
        return addSizeId;
    }

    public void setAddSizeId(Long addSizeId) {
        this.addSizeId = addSizeId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

}
