package com.wugeek.auth.api.model.vo;

import java.io.Serializable;

/**
 * Created by guoshixiong on 2017/6/24.
 * <p>
 * version: 1.0
 */
public class RoleBindPermissionVo implements Serializable {

    private Integer roleId;
    private Integer[] permissionId;

    public RoleBindPermissionVo() {
    }

    public RoleBindPermissionVo(Integer roleId, Integer[] permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer[] getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer[] permissionId) {
        this.permissionId = permissionId;
    }
}
