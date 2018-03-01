package com.wugeek.auth.api.model.po;

import java.io.Serializable;

public class RoleAssociatePermissionPo implements Serializable {

    private Integer rpId;

    private Integer roleId;

    private Integer permissionId;

    private String rpDesc;

    public RoleAssociatePermissionPo(Integer rpId, Integer roleId, Integer permissionId, String rpDesc) {
        this.rpId = rpId;
        this.roleId = roleId;
        this.permissionId = permissionId;
        this.rpDesc = rpDesc;
    }

    public RoleAssociatePermissionPo() {
        super();
    }

    public Integer getRpId() {
        return rpId;
    }

    public void setRpId(Integer rpId) {
        this.rpId = rpId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getRpDesc() {
        return rpDesc;
    }

    public void setRpDesc(String rpDesc) {
        this.rpDesc = rpDesc == null ? null : rpDesc.trim();
    }
}