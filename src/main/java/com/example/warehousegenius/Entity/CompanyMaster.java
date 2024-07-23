package com.example.warehousegenius.Entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "company_master")
public class CompanyMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_description")
    private String companyDescription;

    @Column(name = "address")
    private String address;

    @Column(name = "landline")
    private String landline;

    @Column(name = "fax")
    private String fax;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "contact_persons")
    private String contactPersons;

    @Column(name = "vat_no")
    private String vatNo;

    @Column(name = "cst_no")
    private String cstNo;

    @Column(name = "tin_no")
    private String tinNo;

    @Column(name = "lbt_no")
    private String lbtNo;

    @Column(name = "excise_no")
    private String exciseNo;

    @Column(name = "excise_chap_heading")
    private String exciseChapHeading;

    @Column(name = "excise_range")
    private String exciseRange;

    @Column(name = "excise_division")
    private String exciseDivision;

    @Column(name = "excise_commissionerate")
    private String exciseCommiissionerate;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<BankMaster> banks;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @JsonIgnore
    @OneToOne(mappedBy = "company")
    private TransactionSettings transactionSettings;

    @JsonIgnore
    @OneToOne(mappedBy = "company")
    private MonthWiseSetting monthWiseSetting;

    @ManyToOne
    @JoinColumn(name = "edited_by")
    private User editedBy;

    @Column(name = "edited_date")
    private Date editedDate;

    public CompanyMaster() {

    }

    public CompanyMaster(Long companyId, String companyName, String companyDescription, String address,
                         String landline, String fax, String mobileNumber, String email, String contactPersons,
                         String vatNo, String cstNo, String tinNo, String exciseNo, String exciseChapHeading,
                         String exciseRange, String lbtNo, String exciseDivision, String exciseCommiissionerate) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyDescription = companyDescription;
        this.address = address;
        this.landline = landline;
        this.fax = fax;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.contactPersons = contactPersons;
        this.vatNo = vatNo;
        this.cstNo = cstNo;
        this.tinNo = tinNo;
        this.exciseNo = exciseNo;
        this.exciseChapHeading = exciseChapHeading;
        this.exciseRange = exciseRange;
        this.exciseDivision = exciseDivision;
        this.exciseCommiissionerate = exciseCommiissionerate;
        this.lbtNo = lbtNo;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactPersons() {
        return contactPersons;
    }

    public void setContactPersons(String contactPersons) {
        this.contactPersons = contactPersons;
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

    public String getExciseNo() {
        return exciseNo;
    }

    public void setExciseNo(String exciseNo) {
        this.exciseNo = exciseNo;
    }

    public String getExciseChapHeading() {
        return exciseChapHeading;
    }

    public void setExciseChapHeading(String exciseChapHeading) {
        this.exciseChapHeading = exciseChapHeading;
    }

    public String getExciseRange() {
        return exciseRange;
    }

    public void setExciseRange(String exciseRange) {
        this.exciseRange = exciseRange;
    }

    public String getExciseDivision() {
        return exciseDivision;
    }

    public void setExciseDivision(String exciseDivision) {
        this.exciseDivision = exciseDivision;
    }

    public String getExciseCommiissionerate() {
        return exciseCommiissionerate;
    }

    public void setExciseCommiissionerate(String exciseCommiissionerate) {
        this.exciseCommiissionerate = exciseCommiissionerate;
    }

    public String getLbtNo() {
        return lbtNo;
    }

    public void setLbtNo(String lbtNo) {
        this.lbtNo = lbtNo;
    }

    public List<BankMaster> getBanks() {
        return banks;
    }

    public void setBanks(List<BankMaster> banks) {
        this.banks = banks;
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

    @Override
    public String toString(){
        return this.companyName + " " + this.companyId + " " + this.companyDescription + " " + this.landline;
    }
    
}
