package com.example.warehousegenius.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "financial_year")
public class FinancialYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long financialYearId;

    @Column(name = "financial_year")
    private String financialYear;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "closed")
    private Boolean closed;

    @JsonIgnore
    @OneToOne(mappedBy = "fyear")
    private TransactionSettings transactionSettings;

    @JsonIgnore
    @OneToOne(mappedBy = "financialYear")
    private MonthWiseSetting monthWiseSetting;

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

    public FinancialYear() {
    }

    public FinancialYear(Long financialYearId, String financialYear, LocalDateTime startDate, LocalDateTime endDate, Boolean closed) {
        this.financialYearId = financialYearId;
        this.financialYear = financialYear;
        this.startDate = startDate;
        this.endDate = endDate;
        this.closed = closed;
    }

    public Long getFinancialYearId() {
        return financialYearId;
    }

    public void setFinancialYearId(Long financialYearId) {
        this.financialYearId = financialYearId;
    }

    public String getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(String financialYear) {
        this.financialYear = financialYear;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
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
