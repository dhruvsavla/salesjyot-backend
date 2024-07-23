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
@Table(name = "user_preferences")
public class UserPreferences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userPreferencesId;

    @Column(name = "view_dashboard_on_start")
    private Boolean viewDashboardOnStart;

    @Column(name = "password_expires_in_days")
    private Integer passwordExpiresInDays;

    @Column(name = "enable_reminders")
    private Boolean enableReminders;

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
    
    public UserPreferences() {
    }

    public UserPreferences(Long userPreferencesId, Boolean viewDashboardOnStart, Integer passwordExpiresInDays,
            Boolean enableReminders) {
        this.userPreferencesId = userPreferencesId;
        this.viewDashboardOnStart = viewDashboardOnStart;
        this.passwordExpiresInDays = passwordExpiresInDays;
        this.enableReminders = enableReminders;
    }

    public Long getUserPreferencesId() {
        return userPreferencesId;
    }

    public void setUserPreferencesId(Long userPreferencesId) {
        this.userPreferencesId = userPreferencesId;
    }

    public Boolean getViewDashboardOnStart() {
        return viewDashboardOnStart;
    }

    public void setViewDashboardOnStart(Boolean viewDashboardOnStart) {
        this.viewDashboardOnStart = viewDashboardOnStart;
    }

    public Integer getPasswordExpiresInDays() {
        return passwordExpiresInDays;
    }

    public void setPasswordExpiresInDays(Integer passwordExpiresInDays) {
        this.passwordExpiresInDays = passwordExpiresInDays;
    }

    public Boolean getEnableReminders() {
        return enableReminders;
    }

    public void setEnableReminders(Boolean enableReminders) {
        this.enableReminders = enableReminders;
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
