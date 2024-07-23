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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "hsn")
public class HSN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hsnId;

    @Column(name = "hsn_code")
    private String hsnCode;

    @Column(name = "hsn_description")
    private String hsnDescription;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @JsonIgnore
    @ManyToMany
    private List<TaxForm> taxForms;

    @ManyToOne
    @JoinColumn(name = "edited_by")
    private User editedBy;

    @Column(name = "edited_date")
    private Date editedDate;

    public HSN(){

    }

    public HSN(Long hsnId, String hsnCode, String hsnDescription) {
        this.hsnId = hsnId;
        this.hsnCode = hsnCode;
        this.hsnDescription = hsnDescription;
    }

    public Long getHsnId() {
        return hsnId;
    }

    public void setHsnId(Long hsnId) {
        this.hsnId = hsnId;
    }

    public String getHsnCode() {
        return hsnCode;
    }

    public void setHsnCode(String hsnCode) {
        this.hsnCode = hsnCode;
    }

    public String getHsnDescription() {
        return hsnDescription;
    }

    public void setHsnDescription(String hsnDescription) {
        this.hsnDescription = hsnDescription;
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

    public List<TaxForm> getTaxForms() {
        return taxForms;
    }

    public void setTaxForms(List<TaxForm> taxForms) {
        this.taxForms = taxForms;
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
    
}
