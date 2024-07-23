package com.example.warehousegenius.Entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tax_form")
public class TaxForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taxFormId;

    @Column(name = "tax_form_name")
    private String taxFormName;

    @ManyToMany
    @JoinTable(
        name = "tax_form_tax_master",
        joinColumns = @JoinColumn(name = "tax_form_id"),
        inverseJoinColumns = @JoinColumn(name = "tax_master_id")
    )
    private List<TaxMaster> taxMasters;

    @ManyToMany
    @JoinTable(
        name = "tax_form_hsn",
        joinColumns = @JoinColumn(name = "tax_form_id"),
        inverseJoinColumns = @JoinColumn(name = "hsn_id")
    )
    private List<HSN> hsns;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    @Column(name = "min_sales")
    private Double minSales;
    
    @Column(name = "max_sales")
    private Double maxSales;

    @Column(name = "tax_pct")
    private Double taxPct;

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

    public TaxForm(){

    }

    public TaxForm(Long taxFormId, String taxFormName, LocalDate fromDate, LocalDate toDate, Double minSales,
            Double maxSales, Double taxPct) {
        this.taxFormId = taxFormId;
        this.taxFormName = taxFormName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.minSales = minSales;
        this.maxSales = maxSales;
        this.taxPct = taxPct;
    }

    public Long getTaxFormId() {
        return taxFormId;
    }

    public void setTaxFormId(Long taxFormId) {
        this.taxFormId = taxFormId;
    }

    public String getTaxFormName() {
        return taxFormName;
    }

    public void setTaxFormName(String taxFormName) {
        this.taxFormName = taxFormName;
    }

    public List<TaxMaster> getTaxMasters() {
        return taxMasters;
    }

    public void setTaxMasters(List<TaxMaster> taxMasters) {
        this.taxMasters = taxMasters;
    }

    public List<HSN> getHsns() {
        return hsns;
    }

    public void setHsns(List<HSN> hsns) {
        this.hsns = hsns;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Double getMinSales() {
        return minSales;
    }

    public void setMinSales(Double minSales) {
        this.minSales = minSales;
    }

    public Double getMaxSales() {
        return maxSales;
    }

    public void setMaxSales(Double maxSales) {
        this.maxSales = maxSales;
    }

    public Double getTaxPct() {
        return taxPct;
    }

    public void setTaxPct(Double taxPct) {
        this.taxPct = taxPct;
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
