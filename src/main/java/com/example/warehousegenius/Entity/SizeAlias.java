package com.example.warehousegenius.Entity;

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
import jakarta.persistence.Table;

@Entity
@Table(name = "size_alias")
public class SizeAlias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sizeAliasId;

    @Column(name = "alias")
    private String alias;

    @ManyToOne()
    @JoinColumn(name = "add_size_range_id")
    private AddSizeRange addSizeRange;

    @ManyToOne()
    @JoinColumn(name = "add_size_id")
    private AddSize addSize;

    public SizeAlias(){
        
    }

    public SizeAlias(Long sizeAliasId, String alias) {
        this.sizeAliasId = sizeAliasId;
        this.alias = alias;
    }

    public Long getSizeAliasId() {
        return sizeAliasId;
    }

    public void setSizeAliasId(Long sizeAliasId) {
        this.sizeAliasId = sizeAliasId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public AddSizeRange getAddSizeRange() {
        return addSizeRange;
    }

    public void setAddSizeRange(AddSizeRange addSizeRange) {
        this.addSizeRange = addSizeRange;
    }

    public AddSize getAddSize() {
        return addSize;
    }

    public void setAddSize(AddSize addSize) {
        this.addSize = addSize;
    }

}
