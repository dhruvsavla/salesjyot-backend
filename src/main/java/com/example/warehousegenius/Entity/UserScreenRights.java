package com.example.warehousegenius.Entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "user_screen_rights")
public class UserScreenRights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "site_id")
    private SiteMaster site;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "screen")
    private String screen;

    @Column(name = "can_view")
    private boolean canView;

    @Column(name = "can_add")
    private boolean canAdd;

    @Column(name = "can_edit")
    private boolean canEdit;

    @Column(name = "can_delete")
    private boolean canDelete;

    @Column(name = "can_print")
    private boolean canPrint;

    @Column(name = "can_export")
    private boolean canExport;

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

    public UserScreenRights() {
    }


    public UserScreenRights(Long id, SiteMaster site, User user, String screen, boolean canView, boolean canAdd,
            boolean canEdit, boolean canDelete, boolean canPrint, boolean canExport) {
        this.id = id;
        this.site = site;
        this.user = user;
        this.screen = screen;
        this.canView = canView;
        this.canAdd = canAdd;
        this.canEdit = canEdit;
        this.canDelete = canDelete;
        this.canPrint = canPrint;
        this.canExport = canExport;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SiteMaster getSite() {
        return site;
    }

    public void setSite(SiteMaster site) {
        this.site = site;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public boolean isCanView() {
        return canView;
    }

    public void setCanView(boolean canView) {
        this.canView = canView;
    }

    public boolean isCanAdd() {
        return canAdd;
    }

    public void setCanAdd(boolean canAdd) {
        this.canAdd = canAdd;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    public boolean isCanPrint() {
        return canPrint;
    }

    public void setCanPrint(boolean canPrint) {
        this.canPrint = canPrint;
    }

    public boolean isCanExport() {
        return canExport;
    }

    public void setCanExport(boolean canExport) {
        this.canExport = canExport;
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

