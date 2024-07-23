package com.example.warehousegenius.Entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "site_master")
public class SiteMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long siteId;

    @Column(name = "site_name")
    private String siteName;

    @Column(name = "site_code")
    private String siteCode;

    @Column(name = "stores_stock")
    private Boolean storesStock;

    @Column(name = "has_transaction_nos")
    private Boolean hasTransactionNos;

    @Column(name = "is_primary")
    private Boolean isPrimary;

    @Column(name = "site_for_stock_keeping")
    private String siteForStockKeeping;

    @Column(name = "site_for_transaction_nos")
    private String siteForTransactionNos;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @JsonIgnore
    @OneToMany(mappedBy = "site")
    private List<AddRack> racks;

    @JsonIgnore
    @OneToOne(mappedBy = "site")
    private TransactionSettings transactionSettings;

    @JsonIgnore
    @OneToOne(mappedBy = "site")
    private MonthWiseSetting monthWiseSetting;

    @JsonIgnore
    @OneToMany(mappedBy = "siteName")
    private List<SiteWiseSettings> siteWiseSettings;

    @JsonIgnore
    @OneToMany(mappedBy = "defaultStockSite")
    private List<SiteWiseSettings> defaultStockSiteSettings;

    @JsonIgnore
    @OneToMany(mappedBy = "site")
    private Set<UserScreenRights> userScreenRights;

    @ManyToOne
    @JoinColumn(name = "edited_by")
    private User editedBy;

    @Column(name = "edited_date")
    private Date editedDate;

    public SiteMaster() {
        
    }

    public SiteMaster(Long siteId, String siteName, String siteCode, Boolean storesStock, Boolean hasTransactionNos,
            Boolean isPrimary, String siteForStockKeeping, String siteForTransactionNos) {
        this.siteId = siteId;
        this.siteName = siteName;
        this.siteCode = siteCode;
        this.storesStock = storesStock;
        this.hasTransactionNos = hasTransactionNos;
        this.isPrimary = isPrimary;
        this.siteForStockKeeping = siteForStockKeeping;
        this.siteForTransactionNos = siteForTransactionNos;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public Boolean getStoresStock() {
        return storesStock;
    }

    public void setStoresStock(Boolean storesStock) {
        this.storesStock = storesStock;
    }

    public Boolean getHasTransactionNos() {
        return hasTransactionNos;
    }

    public void setHasTransactionNos(Boolean hasTransactionNos) {
        this.hasTransactionNos = hasTransactionNos;
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public String getSiteForStockKeeping() {
        return siteForStockKeeping;
    }

    public void setSiteForStockKeeping(String siteForStockKeeping) {
        this.siteForStockKeeping = siteForStockKeeping;
    }

    public String getSiteForTransactionNos() {
        return siteForTransactionNos;
    }

    public void setSiteForTransactionNos(String siteForTransactionNos) {
        this.siteForTransactionNos = siteForTransactionNos;
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

    public List<AddRack> getRacks() {
        return racks;
    }

    public void setRacks(List<AddRack> racks) {
        this.racks = racks;
    }

    public TransactionSettings getTransactionSettings() {
        return transactionSettings;
    }

    public void setTransactionSettings(TransactionSettings transactionSettings) {
        this.transactionSettings = transactionSettings;
    }

    public MonthWiseSetting getMonthWiseSetting() {
        return monthWiseSetting;
    }

    public void setMonthWiseSetting(MonthWiseSetting monthWiseSetting) {
        this.monthWiseSetting = monthWiseSetting;
    }

    public List<SiteWiseSettings> getSiteWiseSettings() {
        return siteWiseSettings;
    }

    public void setSiteWiseSettings(List<SiteWiseSettings> siteWiseSettings) {
        this.siteWiseSettings = siteWiseSettings;
    }

    public List<SiteWiseSettings> getDefaultStockSiteSettings() {
        return defaultStockSiteSettings;
    }

    public void setDefaultStockSiteSettings(List<SiteWiseSettings> defaultStockSiteSettings) {
        this.defaultStockSiteSettings = defaultStockSiteSettings;
    }

    public Set<UserScreenRights> getUserScreenRights() {
        return userScreenRights;
    }

    public void setUserScreenRights(Set<UserScreenRights> userScreenRights) {
        this.userScreenRights = userScreenRights;
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
