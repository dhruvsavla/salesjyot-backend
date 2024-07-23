package com.example.warehousegenius.Entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "site_settings")
public class SiteWiseSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "site_name")
    private SiteMaster siteName;

    @ManyToOne
    @JoinColumn(name = "default_tax_id")
    private TaxMaster defaultTax;

    @ManyToOne
    @JoinColumn(name = "default_stock_site_id")
    private SiteMaster defaultStockSite;

    @Column(name = "rack_wise_stock")
    private boolean rackWiseStock;

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

    public SiteWiseSettings() {

    }


    public SiteWiseSettings(Long id, SiteMaster siteName, TaxMaster defaultTax, SiteMaster defaultStockSite,
            boolean rackWiseStock) {
        this.id = id;
        this.siteName = siteName;
        this.defaultTax = defaultTax;
        this.defaultStockSite = defaultStockSite;
        this.rackWiseStock = rackWiseStock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SiteMaster getSiteName() {
        return siteName;
    }

    public void setSiteName(SiteMaster siteName) {
        this.siteName = siteName;
    }

    public TaxMaster getDefaultTax() {
        return defaultTax;
    }

    public void setDefaultTax(TaxMaster defaultTax) {
        this.defaultTax = defaultTax;
    }

    public SiteMaster getDefaultStockSite() {
        return defaultStockSite;
    }

    public void setDefaultStockSite(SiteMaster defaultStockSite) {
        this.defaultStockSite = defaultStockSite;
    }

    public boolean isRackWiseStock() {
        return rackWiseStock;
    }

    public void setRackWiseStock(boolean rackWiseStock) {
        this.rackWiseStock = rackWiseStock;
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

}

