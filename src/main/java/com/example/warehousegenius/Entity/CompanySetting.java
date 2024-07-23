package com.example.warehousegenius.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "company_setting")
public class CompanySetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companySettingId;

    @Column(name = "enable_size_wise_stock")
    private Boolean enableSizeWiseStock;

    @Column(name = "godown_site_wise_stock")
    private Boolean godownSiteWiseStock;

    @Column(name = "sms_via")
    private String smsVia;

    @Column(name = "default_margin")
    private String defaultMargin;

    @Column(name = "round_total_for_transaction_screens")
    private Boolean roundTotalForTransactionScreens;

    @Column(name = "multiple_price_list")
    private Boolean multiplePriceList;

    @Column(name = "stock_alert_in_order_form")
    private Boolean stockAlertInOrderForm;

    @Column(name = "stop_order_if_no_stock")
    private Boolean stopOrderIfNoStock;

    @Column(name = "stock_alert_in_sales_form")
    private Boolean stockAlertInSalesForm;

    @Column(name = "stop_sales_if_no_stock")
    private Boolean stopSalesIfNoStock;

    @Column(name = "month_wise_transaction_no")
    private Boolean monthWiseTransactionNo;

    @Column(name = "creditnote_no_same_as_salesreturn_no")
    private Boolean creditnoteNoSameAsSalesreturnNo;

    @Column(name = "invoice_no_same_as_challan_no")
    private Boolean invoiceNoSameAsChallanNo;

    @Column(name = "continuous_invoice_no")
    private Boolean continuousInvoiceNo;

    @Column(name = "continuous_cn_no")
    private Boolean continuousCNNo;

    @Column(name = "taxes_included_in_rate")
    private Boolean taxesIncludedInRate;

    @Column(name = "barcode_rows")
    private String barcodeRows;

    @Column(name = "barcode_cols")
    private String barcodeCols;

    @Column(name = "godown_site_wise_transaction_no")
    private Boolean godownSiteWiseTransactionNo;

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

    public CompanySetting(){

    }

    public CompanySetting(Long companySettingId, Boolean enableSizeWiseStock, Boolean godownSiteWiseStock,
            String smsVia, String defaultMargin, Boolean roundTotalForTransactionScreens, Boolean multiplePriceList,
            Boolean stockAlertInOrderForm, Boolean stopOrderIfNoStock, Boolean stockAlertInSalesForm,
            Boolean stopSalesIfNoStock, Boolean monthWiseTransactionNo, Boolean creditnoteNoSameAsSalesreturnNo,
            Boolean invoiceNoSameAsChallanNo, Boolean continuousInvoiceNo, Boolean continuousCNNo,
            Boolean taxesIncludedInRate, String barcodeRows, String barcodeCols, Boolean godownSiteWiseTransactionNo) {
        this.companySettingId = companySettingId;
        this.enableSizeWiseStock = enableSizeWiseStock;
        this.godownSiteWiseStock = godownSiteWiseStock;
        this.smsVia = smsVia;
        this.defaultMargin = defaultMargin;
        this.roundTotalForTransactionScreens = roundTotalForTransactionScreens;
        this.multiplePriceList = multiplePriceList;
        this.stockAlertInOrderForm = stockAlertInOrderForm;
        this.stopOrderIfNoStock = stopOrderIfNoStock;
        this.stockAlertInSalesForm = stockAlertInSalesForm;
        this.stopSalesIfNoStock = stopSalesIfNoStock;
        this.monthWiseTransactionNo = monthWiseTransactionNo;
        this.creditnoteNoSameAsSalesreturnNo = creditnoteNoSameAsSalesreturnNo;
        this.invoiceNoSameAsChallanNo = invoiceNoSameAsChallanNo;
        this.continuousInvoiceNo = continuousInvoiceNo;
        this.continuousCNNo = continuousCNNo;
        this.taxesIncludedInRate = taxesIncludedInRate;
        this.barcodeRows = barcodeRows;
        this.barcodeCols = barcodeCols;
        this.godownSiteWiseTransactionNo = godownSiteWiseTransactionNo;
    }

    public Long getCompanySettingId() {
        return companySettingId;
    }

    public void setCompanySettingId(Long companySettingId) {
        this.companySettingId = companySettingId;
    }

    public Boolean getEnableSizeWiseStock() {
        return enableSizeWiseStock;
    }

    public void setEnableSizeWiseStock(Boolean enableSizeWiseStock) {
        this.enableSizeWiseStock = enableSizeWiseStock;
    }

    public Boolean getGodownSiteWiseStock() {
        return godownSiteWiseStock;
    }

    public void setGodownSiteWiseStock(Boolean godownSiteWiseStock) {
        this.godownSiteWiseStock = godownSiteWiseStock;
    }

    public String getSmsVia() {
        return smsVia;
    }

    public void setSmsVia(String smsVia) {
        this.smsVia = smsVia;
    }

    public String getDefaultMargin() {
        return defaultMargin;
    }

    public void setDefaultMargin(String defaultMargin) {
        this.defaultMargin = defaultMargin;
    }

    public Boolean getRoundTotalForTransactionScreens() {
        return roundTotalForTransactionScreens;
    }

    public void setRoundTotalForTransactionScreens(Boolean roundTotalForTransactionScreens) {
        this.roundTotalForTransactionScreens = roundTotalForTransactionScreens;
    }

    public Boolean getMultiplePriceList() {
        return multiplePriceList;
    }

    public void setMultiplePriceList(Boolean multiplePriceList) {
        this.multiplePriceList = multiplePriceList;
    }

    public Boolean getStockAlertInOrderForm() {
        return stockAlertInOrderForm;
    }

    public void setStockAlertInOrderForm(Boolean stockAlertInOrderForm) {
        this.stockAlertInOrderForm = stockAlertInOrderForm;
    }

    public Boolean getStopOrderIfNoStock() {
        return stopOrderIfNoStock;
    }

    public void setStopOrderIfNoStock(Boolean stopOrderIfNoStock) {
        this.stopOrderIfNoStock = stopOrderIfNoStock;
    }

    public Boolean getStockAlertInSalesForm() {
        return stockAlertInSalesForm;
    }

    public void setStockAlertInSalesForm(Boolean stockAlertInSalesForm) {
        this.stockAlertInSalesForm = stockAlertInSalesForm;
    }

    public Boolean getStopSalesIfNoStock() {
        return stopSalesIfNoStock;
    }

    public void setStopSalesIfNoStock(Boolean stopSalesIfNoStock) {
        this.stopSalesIfNoStock = stopSalesIfNoStock;
    }

    public Boolean getMonthWiseTransactionNo() {
        return monthWiseTransactionNo;
    }

    public void setMonthWiseTransactionNo(Boolean monthWiseTransactionNo) {
        this.monthWiseTransactionNo = monthWiseTransactionNo;
    }

    public Boolean getCreditnoteNoSameAsSalesreturnNo() {
        return creditnoteNoSameAsSalesreturnNo;
    }

    public void setCreditnoteNoSameAsSalesreturnNo(Boolean creditnoteNoSameAsSalesreturnNo) {
        this.creditnoteNoSameAsSalesreturnNo = creditnoteNoSameAsSalesreturnNo;
    }

    public Boolean getInvoiceNoSameAsChallanNo() {
        return invoiceNoSameAsChallanNo;
    }

    public void setInvoiceNoSameAsChallanNo(Boolean invoiceNoSameAsChallanNo) {
        this.invoiceNoSameAsChallanNo = invoiceNoSameAsChallanNo;
    }

    public Boolean getContinuousInvoiceNo() {
        return continuousInvoiceNo;
    }

    public void setContinuousInvoiceNo(Boolean continuousInvoiceNo) {
        this.continuousInvoiceNo = continuousInvoiceNo;
    }

    public Boolean getContinuousCNNo() {
        return continuousCNNo;
    }

    public void setContinuousCNNo(Boolean continuousCNNo) {
        this.continuousCNNo = continuousCNNo;
    }

    public Boolean getTaxesIncludedInRate() {
        return taxesIncludedInRate;
    }

    public void setTaxesIncludedInRate(Boolean taxesIncludedInRate) {
        this.taxesIncludedInRate = taxesIncludedInRate;
    }

    public String getBarcodeRows() {
        return barcodeRows;
    }

    public void setBarcodeRows(String barcodeRows) {
        this.barcodeRows = barcodeRows;
    }

    public String getBarcodeCols() {
        return barcodeCols;
    }

    public void setBarcodeCols(String barcodeCols) {
        this.barcodeCols = barcodeCols;
    }

    public Boolean getGodownSiteWiseTransactionNo() {
        return godownSiteWiseTransactionNo;
    }

    public void setGodownSiteWiseTransactionNo(Boolean godownSiteWiseTransactionNo) {
        this.godownSiteWiseTransactionNo = godownSiteWiseTransactionNo;
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
