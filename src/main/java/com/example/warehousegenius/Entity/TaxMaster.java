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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tax")
public class TaxMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taxId;

    @Column(name = "tax_name")
    private String taxName;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "tax_percentage")
    private String taxPercentage;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @JsonIgnore
    @OneToMany(mappedBy = "tax")
    private List<AccountingHead> accountingHeads;

    @JsonIgnore
    @OneToMany(mappedBy = "defaultTax")
    private List<Address> address;

    @JsonIgnore
    @OneToMany(mappedBy = "defaultTax")
    private List<SiteWiseSettings> siteWiseSettings;

    @JsonIgnore
    @ManyToMany
    private List<TaxForm> taxForms;

    @ManyToOne
    @JoinColumn(name = "edited_by")
    private User editedBy;

    @Column(name = "edited_date")
    private Date editedDate;
    
    public TaxMaster(){

    }

    public TaxMaster(Long taxId, String taxName, String displayName, String taxPercentage) {
        this.taxId = taxId;
        this.taxName = taxName;
        this.displayName = displayName;
        this.taxPercentage = taxPercentage;
    }

    public Long getTaxId() {
        return taxId;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(String taxPercentage) {
        this.taxPercentage = taxPercentage;
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

    public List<AccountingHead> getAccountingHeads() {
        return accountingHeads;
    }

    public void setAccountingHeads(List<AccountingHead> accountingHeads) {
        this.accountingHeads = accountingHeads;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<SiteWiseSettings> getSiteWiseSettings() {
        return siteWiseSettings;
    }

    public void setSiteWiseSettings(List<SiteWiseSettings> siteWiseSettings) {
        this.siteWiseSettings = siteWiseSettings;
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
