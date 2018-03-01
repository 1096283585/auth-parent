package com.wugeek.auth.api.model.po;

import java.io.Serializable;

public class PermissionPo implements Serializable {

    private Integer permissionId;
    private Integer permissionCatagoryId;
    private String permissionIdentity;
    private String permissionName;
    private String permissionDesc;

    public PermissionPo(Integer permissionId, Integer permissionCatagoryId, String permissionIdentity, String permissionName, String permissionDesc) {
        this.permissionId = permissionId;
        this.permissionCatagoryId = permissionCatagoryId;
        this.permissionIdentity = permissionIdentity;
        this.permissionName = permissionName;
        this.permissionDesc = permissionDesc;
    }

    public PermissionPo() {
        super();
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getPermissionCatagoryId() {
        return permissionCatagoryId;
    }

    public void setPermissionCatagoryId(Integer permissionCatagoryId) {
        this.permissionCatagoryId = permissionCatagoryId;
    }

    public String getPermissionIdentity() {
        return permissionIdentity;
    }

    public void setPermissionIdentity(String permissionIdentity) {
        this.permissionIdentity = permissionIdentity == null ? null : permissionIdentity.trim();
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }

    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc == null ? null : permissionDesc.trim();
    }
}