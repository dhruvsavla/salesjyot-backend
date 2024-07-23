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
@Table(name = "add_rack")
public class AddRack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addRackId; 
    
    @Column(name = "rack_name")
    private String rackName;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "site_id")
    private SiteMaster site;

    @ManyToOne
    @JoinColumn(name = "edited_by")
    private User editedBy;

    @Column(name = "edited_date")
    private Date editedDate;

    public AddRack() {
    }

    public AddRack(Long addRackId, String rackName) {
        this.addRackId = addRackId;
        this.rackName = rackName;
    }

    public Long getAddRackId() {
        return addRackId;
    }

    public void setAddRackId(Long addRackId) {
        this.addRackId = addRackId;
    }

    public String getRackName() {
        return rackName;
    }

    public void setRackName(String rackName) {
        this.rackName = rackName;
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

    public SiteMaster getSite() {
        return site;
    }

    public void setSite(SiteMaster site) {
        this.site = site;
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
