package com.example.warehousegenius.Entity;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountingHead accountHead;

    @Column(name = "address_name")
    private String addressName;

    @Column(name = "is_primary")
    private boolean primary;

    @Column(name = "line1")
    private String line1;

    @Column(name = "line2")
    private String line2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "area")
    private String area;

    @Column(name = "landline")
    private String landline;

    @Column(name = "fax")
    private String fax;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "default_tax_id")
    private TaxMaster defaultTax;

    @Column(name = "vat_no")
    private String vatNo;

    @Column(name = "cst_no")
    private String cstNo;

    @Column(name = "tin_no")
    private String tinNo;

    @Column(name = "lbt_no")
    private String lbtNo;

    @Column(name = "default_transport")
    private String defaultTransport;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @JsonIgnore
    @ManyToMany(mappedBy = "addresses")
    private Set<Contacts> contacts;

    @ManyToOne
    @JoinColumn(name = "edited_by")
    private User editedBy;

    @Column(name = "edited_date")
    private Date editedDate;

    public Address() {
        
    }

    public Address(Long addressId, AccountingHead accountHead, String addressName, boolean primary, String line1,
            String line2, String city, String state, String country, String pincode, String area, String landline,
            String fax, String email, TaxMaster defaultTax, String vatNo, String cstNo, String tinNo, String lbtNo,
            String defaultTransport) {
        this.addressId = addressId;
        this.accountHead = accountHead;
        this.addressName = addressName;
        this.primary = primary;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.area = area;
        this.landline = landline;
        this.fax = fax;
        this.email = email;
        this.defaultTax = defaultTax;
        this.vatNo = vatNo;
        this.cstNo = cstNo;
        this.tinNo = tinNo;
        this.lbtNo = lbtNo;
        this.defaultTransport = defaultTransport;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public AccountingHead getAccountHead() {
        return accountHead;
    }

    public void setAccountHead(AccountingHead accountHead) {
        this.accountHead = accountHead;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TaxMaster getDefaultTax() {
        return defaultTax;
    }

    public void setDefaultTax(TaxMaster defaultTax) {
        this.defaultTax = defaultTax;
    }

    public String getVatNo() {
        return vatNo;
    }

    public void setVatNo(String vatNo) {
        this.vatNo = vatNo;
    }

    public String getCstNo() {
        return cstNo;
    }

    public void setCstNo(String cstNo) {
        this.cstNo = cstNo;
    }

    public String getTinNo() {
        return tinNo;
    }

    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }

    public String getLbtNo() {
        return lbtNo;
    }

    public void setLbtNo(String lbtNo) {
        this.lbtNo = lbtNo;
    }

    public String getDefaultTransport() {
        return defaultTransport;
    }

    public void setDefaultTransport(String defaultTransport) {
        this.defaultTransport = defaultTransport;
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
 
}
