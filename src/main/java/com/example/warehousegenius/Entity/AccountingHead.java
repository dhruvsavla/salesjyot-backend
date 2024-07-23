package com.example.warehousegenius.Entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounting_head")
public class AccountingHead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accounting_head_id")
    private Long accountingHeadId;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "parent_account")
    private String parentAccount;

    @Column(name = "display_in_trial_balance")
    private boolean displayInTrialBalance;

    @Column(name = "trial_balance_side")
    private String trialBalanceSide;

    @Column(name = "display_in_pnl")
    private boolean displayInPnl;

    @Column(name = "pnl_side")
    private String pnlSide;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerMaster customer;

    @ManyToOne
    @JoinColumn(name = "tax_id")
    private TaxMaster tax;

    @ManyToOne()
    @JoinColumn(name = "bank_account_id")
    private BankMaster bankAccount;

    @JsonIgnore
    @OneToMany(mappedBy = "accountHead")
    private List<Address> addresses;

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

    public AccountingHead() {

    }

    public AccountingHead(Long accountingHeadId, String accountName, String displayName, String parentAccount,
            boolean displayInTrialBalance, String trialBalanceSide, boolean displayInPnl, String pnlSide) {
        this.accountingHeadId = accountingHeadId;
        this.accountName = accountName;
        this.displayName = displayName;
        this.parentAccount = parentAccount;
        this.displayInTrialBalance = displayInTrialBalance;
        this.trialBalanceSide = trialBalanceSide;
        this.displayInPnl = displayInPnl;
        this.pnlSide = pnlSide;
        
    }

    public Long getAccountingHeadId() {
        return accountingHeadId;
    }

    public void setAccountingHeadId(Long accountingHeadId) {
        this.accountingHeadId = accountingHeadId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getParentAccount() {
        return parentAccount;
    }

    public void setParentAccount(String parentAccount) {
        this.parentAccount = parentAccount;
    }

    public boolean isDisplayInTrialBalance() {
        return displayInTrialBalance;
    }

    public void setDisplayInTrialBalance(boolean displayInTrialBalance) {
        this.displayInTrialBalance = displayInTrialBalance;
    }

    public String getTrialBalanceSide() {
        return trialBalanceSide;
    }

    public void setTrialBalanceSide(String trialBalanceSide) {
        this.trialBalanceSide = trialBalanceSide;
    }

    public boolean isDisplayInPnl() {
        return displayInPnl;
    }

    public void setDisplayInPnl(boolean displayInPnl) {
        this.displayInPnl = displayInPnl;
    }

    public String getPnlSide() {
        return pnlSide;
    }

    public void setPnlSide(String pnlSide) {
        this.pnlSide = pnlSide;
    }

    public CustomerMaster getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerMaster customer) {
        this.customer = customer;
    }

    public TaxMaster getTax() {
        return tax;
    }

    public void setTax(TaxMaster tax) {
        this.tax = tax;
    }

    public BankMaster getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankMaster bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
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