package com.example.warehousegenius.Entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_master")
public class BankMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankId;
    
    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "account_no")
    private String accountNo;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyMaster company;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @JsonIgnore
    @OneToMany(mappedBy = "bankAccount")
    private List<AccountingHead> accountingHeads;

    @ManyToOne
    @JoinColumn(name = "edited_by")
    private User editedBy;

    @Column(name = "edited_date")
    private Date editedDate;

    public BankMaster() {}

    public BankMaster(Long bankId, String bankName, String accountNo, CompanyMaster company) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.accountNo = accountNo;
        this.company = company;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public CompanyMaster getCompany() {
        return company;
    }

    public void setCompany(CompanyMaster company) {
        this.company = company;
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
