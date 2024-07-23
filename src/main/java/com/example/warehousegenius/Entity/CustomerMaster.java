package com.example.warehousegenius.Entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_master")
public class CustomerMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_type")
    private String customerType;

    @Column(name = "broker")
    private String broker;

    @Column(name = "brokerage")
    private String brokerage;

    @Column(name = "category")
    private String category;

    @Column(name = "discount")
    private String discount;

    @Column(name = "credit_limit_days")
    private String creditLimitDays;

    @Column(name = "credit_limit_amount")
    private String creditLimitAmount;

    @Column(name = "special_note")
    private String specialNote;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "price_list_id")
    private PriceListMaster priceList;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<AccountingHead> accountingHeads;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Contacts> contacts;

    @JsonIgnore
    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "edited_by")
    private User editedBy;

    @Column(name = "edited_date")
    private Date editedDate;

    public CustomerMaster() {
    }

    public CustomerMaster(Long customerId, String customerName, String customerType, String broker, String brokerage,
            String discount, String creditLimitDays, String creditLimitAmount, String specialNote, String category) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerType = customerType;
        this.broker = broker;
        this.brokerage = brokerage;
        this.discount = discount;
        this.creditLimitDays = creditLimitDays;
        this.creditLimitAmount = creditLimitAmount;
        this.specialNote = specialNote;
        this.category = category;
    }

    // Getters and setters...

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public String getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(String brokerage) {
        this.brokerage = brokerage;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getCreditLimitDays() {
        return creditLimitDays;
    }

    public void setCreditLimitDays(String creditLimitDays) {
        this.creditLimitDays = creditLimitDays;
    }

    public String getCreditLimitAmount() {
        return creditLimitAmount;
    }

    public void setCreditLimitAmount(String creditLimitAmount) {
        this.creditLimitAmount = creditLimitAmount;
    }

    public String getSpecialNote() {
        return specialNote;
    }

    public void setSpecialNote(String specialNote) {
        this.specialNote = specialNote;
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

    public PriceListMaster getPriceList() {
        return priceList;
    }

    public void setPriceList(PriceListMaster priceList) {
        this.priceList = priceList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<AccountingHead> getAccountingHeads() {
        return accountingHeads;
    }

    public void setAccountingHeads(List<AccountingHead> accountingHeads) {
        this.accountingHeads = accountingHeads;
    }

    public Set<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contacts> contacts) {
        this.contacts = contacts;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
