package com.wugeek.auth.api.model.po;

import java.io.Serializable;

public class PermissionCategoryPo implements Serializable {
    private Integer permissionCategoryId;

    private String permissionCategory;

    public PermissionCategoryPo(Integer permissionCategoryId, String permissionCategory) {
        this.permissionCategoryId = permissionCategoryId;
        this.permissionCategory = permissionCategory;
    }

    public PermissionCategoryPo() {
        super();
    }

    public Integer getPermissionCategoryId() {
        return permissionCategoryId;
    }

    public void setPermissionCategoryId(Integer permissionCategoryId) {
        this.permissionCategoryId = permissionCategoryId;
    }

    public String getPermissionCategory() {
        return permissionCategory;
    }

    public void setPermissionCategory(String permissionCategory) {
        this.permissionCategory = permissionCategory == null ? null : permissionCategory.trim();
    }
}