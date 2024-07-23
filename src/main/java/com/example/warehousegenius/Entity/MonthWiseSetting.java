package com.example.warehousegenius.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "monthwise_setting")
public class MonthWiseSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long monthWiseSettingId;

    @OneToOne()
    private CompanyMaster company;

    @OneToOne()
    private SiteMaster site;

    @OneToOne()
    private FinancialYear financialYear;

    @Column(name = "sales_challan_no")
    private String salesChallanNo;

    @Column(name = "sales_invoice_no")
    private String salesInvoiceNo;

    @Column(name = "purchase_challan_no")
    private String purchaseChallanNo;

    @Column(name = "sales_return_no")
    private String salesReturnNo;

    @Column(name = "credit_note_no")
    private String creditNoteNo;

    @Column(name = "purchase_return_challan_no")
    private String purchaseReturnChallanNo;

    @Column(name = "order_form_no")
    private String orderFormNo;

    @Column(name = "purchase_order_no")
    private String purchaseOrderNo;

    @Column(name = "process_entry_no")
    private String processEntryNo;

    @Column(name = "stock_entry_no")
    private String stockEntryNo;

    @Column(name = "stock_conversion_entry_no")
    private String stockConversionEntryNo;

    @Column(name = "voucher_entry_no")
    private String voucherEntryNo;

    @Column(name = "cutting_entry_no")
    private String cuttingEntryNo;

    @Column(name = "order_cancellation_form_no")
    private String orderCancellationFormNo;

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

    public MonthWiseSetting(){
        
    }

    public MonthWiseSetting(Long monthWiseSettingId, CompanyMaster company, SiteMaster site,
            FinancialYear financialYear, String salesChallanNo, String salesInvoiceNo, String purchaseChallanNo,
            String salesReturnNo, String creditNoteNo, String purchaseReturnChallanNo, String orderFormNo,
            String purchaseOrderNo, String processEntryNo, String stockEntryNo, String stockConversionEntryNo,
            String voucherEntryNo, String cuttingEntryNo, String orderCancellationFormNo) {
        this.monthWiseSettingId = monthWiseSettingId;
        this.company = company;
        this.site = site;
        this.financialYear = financialYear;
        this.salesChallanNo = salesChallanNo;
        this.salesInvoiceNo = salesInvoiceNo;
        this.purchaseChallanNo = purchaseChallanNo;
        this.salesReturnNo = salesReturnNo;
        this.creditNoteNo = creditNoteNo;
        this.purchaseReturnChallanNo = purchaseReturnChallanNo;
        this.orderFormNo = orderFormNo;
        this.purchaseOrderNo = purchaseOrderNo;
        this.processEntryNo = processEntryNo;
        this.stockEntryNo = stockEntryNo;
        this.stockConversionEntryNo = stockConversionEntryNo;
        this.voucherEntryNo = voucherEntryNo;
        this.cuttingEntryNo = cuttingEntryNo;
        this.orderCancellationFormNo = orderCancellationFormNo;
    }

    public Long getMonthWiseSettingId() {
        return monthWiseSettingId;
    }

    public void setMonthWiseSettingId(Long monthWiseSettingId) {
        this.monthWiseSettingId = monthWiseSettingId;
    }

    public CompanyMaster getCompany() {
        return company;
    }

    public void setCompany(CompanyMaster company) {
        this.company = company;
    }

    public SiteMaster getSite() {
        return site;
    }

    public void setSite(SiteMaster site) {
        this.site = site;
    }

    public FinancialYear getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(FinancialYear financialYear) {
        this.financialYear = financialYear;
    }

    public String getSalesChallanNo() {
        return salesChallanNo;
    }

    public void setSalesChallanNo(String salesChallanNo) {
        this.salesChallanNo = salesChallanNo;
    }

    public String getSalesInvoiceNo() {
        return salesInvoiceNo;
    }

    public void setSalesInvoiceNo(String salesInvoiceNo) {
        this.salesInvoiceNo = salesInvoiceNo;
    }

    public String getPurchaseChallanNo() {
        return purchaseChallanNo;
    }

    public void setPurchaseChallanNo(String purchaseChallanNo) {
        this.purchaseChallanNo = purchaseChallanNo;
    }

    public String getSalesReturnNo() {
        return salesReturnNo;
    }

    public void setSalesReturnNo(String salesReturnNo) {
        this.salesReturnNo = salesReturnNo;
    }

    public String getCreditNoteNo() {
        return creditNoteNo;
    }

    public void setCreditNoteNo(String creditNoteNo) {
        this.creditNoteNo = creditNoteNo;
    }

    public String getPurchaseReturnChallanNo() {
        return purchaseReturnChallanNo;
    }

    public void setPurchaseReturnChallanNo(String purchaseReturnChallanNo) {
        this.purchaseReturnChallanNo = purchaseReturnChallanNo;
    }

    public String getOrderFormNo() {
        return orderFormNo;
    }

    public void setOrderFormNo(String orderFormNo) {
        this.orderFormNo = orderFormNo;
    }

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public String getProcessEntryNo() {
        return processEntryNo;
    }

    public void setProcessEntryNo(String processEntryNo) {
        this.processEntryNo = processEntryNo;
    }

    public String getStockEntryNo() {
        return stockEntryNo;
    }

    public void setStockEntryNo(String stockEntryNo) {
        this.stockEntryNo = stockEntryNo;
    }

    public String getStockConversionEntryNo() {
        return stockConversionEntryNo;
    }

    public void setStockConversionEntryNo(String stockConversionEntryNo) {
        this.stockConversionEntryNo = stockConversionEntryNo;
    }

    public String getVoucherEntryNo() {
        return voucherEntryNo;
    }

    public void setVoucherEntryNo(String voucherEntryNo) {
        this.voucherEntryNo = voucherEntryNo;
    }

    public String getCuttingEntryNo() {
        return cuttingEntryNo;
    }

    public void setCuttingEntryNo(String cuttingEntryNo) {
        this.cuttingEntryNo = cuttingEntryNo;
    }

    public String getOrderCancellationFormNo() {
        return orderCancellationFormNo;
    }

    public void setOrderCancellationFormNo(String orderCancellationFormNo) {
        this.orderCancellationFormNo = orderCancellationFormNo;
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
