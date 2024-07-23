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
@Table(name = "transaction_settings")
public class TransactionSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionSettingsId;

    @OneToOne
    @JoinColumn(name = "company_id", referencedColumnName = "companyId")
    private CompanyMaster company;

    @OneToOne
    @JoinColumn(name = "site_id")
    private SiteMaster site;

    @OneToOne
    @JoinColumn(name = "fyear_id")
    private FinancialYear fyear;

    @Column(name = "sales_challan_no")
    private Integer salesChallanNo;

    @Column(name = "sales_challan_prefix")
    private String salesChallanPrefix;

    @Column(name = "sales_invoice_no")
    private Integer salesInvoiceNo;

    @Column(name = "sales_invoice_prefix")
    private String salesInvoicePrefix;

    @Column(name = "purchase_challan_no")
    private Integer purchaseChallanNo;

    @Column(name = "purchase_challan_prefix")
    private String purchaseChallanPrefix;

    @Column(name = "sales_return_no")
    private Integer salesReturnNo;

    @Column(name = "sales_return_prefix")
    private String salesReturnPrefix;

    @Column(name = "credit_note_no")
    private Integer creditNoteNo;

    @Column(name = "credit_note_prefix")
    private String creditNotePrefix;

    @Column(name = "purchase_return_challan_no")
    private Integer purchaseReturnChallanNo;

    @Column(name = "purchase_return_challan_prefix")
    private String purchaseReturnChallanPrefix;

    @Column(name = "order_form_no")
    private Integer orderFormNo;

    @Column(name = "order_form_prefix")
    private String orderFormPrefix;

    @Column(name = "purchase_order_no")
    private Integer purchaseOrderNo;

    @Column(name = "purchase_order_prefix")
    private String purchaseOrderPrefix;

    @Column(name = "process_entry_no")
    private Integer processEntryNo;

    @Column(name = "process_entry_prefix")
    private String processEntryPrefix;

    @Column(name = "stock_entry_no")
    private Integer stockEntryNo;

    @Column(name = "stock_entry_prefix")
    private String stockEntryPrefix;

    @Column(name = "stock_conversion_entry_no")
    private Integer stockConversionEntryNo;

    @Column(name = "stock_conversion_entry_prefix")
    private String stockConversionEntryPrefix;

    @Column(name = "voucher_entry_no")
    private Integer voucherEntryNo;

    @Column(name = "voucher_entry_prefix")
    private String voucherEntryPrefix;

    @Column(name = "cutting_entry_no")
    private Integer cuttingEntryNo;

    @Column(name = "cutting_entry_prefix")
    private String cuttingEntryPrefix;

    @Column(name = "order_cancellation_form_no")
    private Integer orderCancellationFormNo;

    @Column(name = "order_cancellation_form_prefix")
    private String orderCancellationFormPrefix;

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

    public TransactionSettings() {

    }

    public TransactionSettings(Long transactionSettingsId, CompanyMaster company, SiteMaster site, FinancialYear fyear,
            Integer salesChallanNo, String salesChallanPrefix, Integer salesInvoiceNo, String salesInvoicePrefix,
            Integer purchaseChallanNo, String purchaseChallanPrefix, Integer salesReturnNo, String salesReturnPrefix,
            Integer creditNoteNo, String creditNotePrefix, Integer purchaseReturnChallanNo,
            String purchaseReturnChallanPrefix, Integer orderFormNo, String orderFormPrefix, Integer purchaseOrderNo,
            String purchaseOrderPrefix, Integer processEntryNo, String processEntryPrefix, Integer stockEntryNo,
            String stockEntryPrefix, Integer stockConversionEntryNo, String stockConversionEntryPrefix,
            Integer voucherEntryNo, String voucherEntryPrefix, Integer cuttingEntryNo, String cuttingEntryPrefix,
            Integer orderCancellationFormNo, String orderCancellationFormPrefix) {
        this.transactionSettingsId = transactionSettingsId;
        this.company = company;
        this.site = site;
        this.fyear = fyear;
        this.salesChallanNo = salesChallanNo;
        this.salesChallanPrefix = salesChallanPrefix;
        this.salesInvoiceNo = salesInvoiceNo;
        this.salesInvoicePrefix = salesInvoicePrefix;
        this.purchaseChallanNo = purchaseChallanNo;
        this.purchaseChallanPrefix = purchaseChallanPrefix;
        this.salesReturnNo = salesReturnNo;
        this.salesReturnPrefix = salesReturnPrefix;
        this.creditNoteNo = creditNoteNo;
        this.creditNotePrefix = creditNotePrefix;
        this.purchaseReturnChallanNo = purchaseReturnChallanNo;
        this.purchaseReturnChallanPrefix = purchaseReturnChallanPrefix;
        this.orderFormNo = orderFormNo;
        this.orderFormPrefix = orderFormPrefix;
        this.purchaseOrderNo = purchaseOrderNo;
        this.purchaseOrderPrefix = purchaseOrderPrefix;
        this.processEntryNo = processEntryNo;
        this.processEntryPrefix = processEntryPrefix;
        this.stockEntryNo = stockEntryNo;
        this.stockEntryPrefix = stockEntryPrefix;
        this.stockConversionEntryNo = stockConversionEntryNo;
        this.stockConversionEntryPrefix = stockConversionEntryPrefix;
        this.voucherEntryNo = voucherEntryNo;
        this.voucherEntryPrefix = voucherEntryPrefix;
        this.cuttingEntryNo = cuttingEntryNo;
        this.cuttingEntryPrefix = cuttingEntryPrefix;
        this.orderCancellationFormNo = orderCancellationFormNo;
        this.orderCancellationFormPrefix = orderCancellationFormPrefix;
    }

    public Long getTransactionSettingsId() {
        return transactionSettingsId;
    }

    public void setTransactionSettingsId(Long transactionSettingsId) {
        this.transactionSettingsId = transactionSettingsId;
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

    public FinancialYear getFyear() {
        return fyear;
    }

    public void setFyear(FinancialYear fyear) {
        this.fyear = fyear;
    }

    public Integer getSalesChallanNo() {
        return salesChallanNo;
    }

    public void setSalesChallanNo(Integer salesChallanNo) {
        this.salesChallanNo = salesChallanNo;
    }

    public String getSalesChallanPrefix() {
        return salesChallanPrefix;
    }

    public void setSalesChallanPrefix(String salesChallanPrefix) {
        this.salesChallanPrefix = salesChallanPrefix;
    }

    public Integer getSalesInvoiceNo() {
        return salesInvoiceNo;
    }

    public void setSalesInvoiceNo(Integer salesInvoiceNo) {
        this.salesInvoiceNo = salesInvoiceNo;
    }

    public String getSalesInvoicePrefix() {
        return salesInvoicePrefix;
    }

    public void setSalesInvoicePrefix(String salesInvoicePrefix) {
        this.salesInvoicePrefix = salesInvoicePrefix;
    }

    public Integer getPurchaseChallanNo() {
        return purchaseChallanNo;
    }

    public void setPurchaseChallanNo(Integer purchaseChallanNo) {
        this.purchaseChallanNo = purchaseChallanNo;
    }

    public String getPurchaseChallanPrefix() {
        return purchaseChallanPrefix;
    }

    public void setPurchaseChallanPrefix(String purchaseChallanPrefix) {
        this.purchaseChallanPrefix = purchaseChallanPrefix;
    }

    public Integer getSalesReturnNo() {
        return salesReturnNo;
    }

    public void setSalesReturnNo(Integer salesReturnNo) {
        this.salesReturnNo = salesReturnNo;
    }

    public String getSalesReturnPrefix() {
        return salesReturnPrefix;
    }

    public void setSalesReturnPrefix(String salesReturnPrefix) {
        this.salesReturnPrefix = salesReturnPrefix;
    }

    public Integer getCreditNoteNo() {
        return creditNoteNo;
    }

    public void setCreditNoteNo(Integer creditNoteNo) {
        this.creditNoteNo = creditNoteNo;
    }

    public String getCreditNotePrefix() {
        return creditNotePrefix;
    }

    public void setCreditNotePrefix(String creditNotePrefix) {
        this.creditNotePrefix = creditNotePrefix;
    }

    public Integer getPurchaseReturnChallanNo() {
        return purchaseReturnChallanNo;
    }

    public void setPurchaseReturnChallanNo(Integer purchaseReturnChallanNo) {
        this.purchaseReturnChallanNo = purchaseReturnChallanNo;
    }

    public String getPurchaseReturnChallanPrefix() {
        return purchaseReturnChallanPrefix;
    }

    public void setPurchaseReturnChallanPrefix(String purchaseReturnChallanPrefix) {
        this.purchaseReturnChallanPrefix = purchaseReturnChallanPrefix;
    }

    public Integer getOrderFormNo() {
        return orderFormNo;
    }

    public void setOrderFormNo(Integer orderFormNo) {
        this.orderFormNo = orderFormNo;
    }

    public String getOrderFormPrefix() {
        return orderFormPrefix;
    }

    public void setOrderFormPrefix(String orderFormPrefix) {
        this.orderFormPrefix = orderFormPrefix;
    }

    public Integer getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(Integer purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public String getPurchaseOrderPrefix() {
        return purchaseOrderPrefix;
    }

    public void setPurchaseOrderPrefix(String purchaseOrderPrefix) {
        this.purchaseOrderPrefix = purchaseOrderPrefix;
    }

    public Integer getProcessEntryNo() {
        return processEntryNo;
    }

    public void setProcessEntryNo(Integer processEntryNo) {
        this.processEntryNo = processEntryNo;
    }

    public String getProcessEntryPrefix() {
        return processEntryPrefix;
    }

    public void setProcessEntryPrefix(String processEntryPrefix) {
        this.processEntryPrefix = processEntryPrefix;
    }

    public Integer getStockEntryNo() {
        return stockEntryNo;
    }

    public void setStockEntryNo(Integer stockEntryNo) {
        this.stockEntryNo = stockEntryNo;
    }

    public String getStockEntryPrefix() {
        return stockEntryPrefix;
    }

    public void setStockEntryPrefix(String stockEntryPrefix) {
        this.stockEntryPrefix = stockEntryPrefix;
    }

    public Integer getStockConversionEntryNo() {
        return stockConversionEntryNo;
    }

    public void setStockConversionEntryNo(Integer stockConversionEntryNo) {
        this.stockConversionEntryNo = stockConversionEntryNo;
    }

    public String getStockConversionEntryPrefix() {
        return stockConversionEntryPrefix;
    }

    public void setStockConversionEntryPrefix(String stockConversionEntryPrefix) {
        this.stockConversionEntryPrefix = stockConversionEntryPrefix;
    }

    public Integer getVoucherEntryNo() {
        return voucherEntryNo;
    }

    public void setVoucherEntryNo(Integer voucherEntryNo) {
        this.voucherEntryNo = voucherEntryNo;
    }

    public String getVoucherEntryPrefix() {
        return voucherEntryPrefix;
    }

    public void setVoucherEntryPrefix(String voucherEntryPrefix) {
        this.voucherEntryPrefix = voucherEntryPrefix;
    }

    public Integer getCuttingEntryNo() {
        return cuttingEntryNo;
    }

    public void setCuttingEntryNo(Integer cuttingEntryNo) {
        this.cuttingEntryNo = cuttingEntryNo;
    }

    public String getCuttingEntryPrefix() {
        return cuttingEntryPrefix;
    }

    public void setCuttingEntryPrefix(String cuttingEntryPrefix) {
        this.cuttingEntryPrefix = cuttingEntryPrefix;
    }

    public Integer getOrderCancellationFormNo() {
        return orderCancellationFormNo;
    }

    public void setOrderCancellationFormNo(Integer orderCancellationFormNo) {
        this.orderCancellationFormNo = orderCancellationFormNo;
    }

    public String getOrderCancellationFormPrefix() {
        return orderCancellationFormPrefix;
    }

    public void setOrderCancellationFormPrefix(String orderCancellationFormPrefix) {
        this.orderCancellationFormPrefix = orderCancellationFormPrefix;
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

