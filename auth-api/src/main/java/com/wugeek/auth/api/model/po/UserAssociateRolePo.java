package com.wugeek.auth.api.model.po;

import java.io.Serializable;

public class UserAssociateRolePo implements Serializable {
    private Integer ruId;

    private Integer userId;

    private Integer roleId;

    private String ruDesc;

    public UserAssociateRolePo(Integer ruId, Integer userId, Integer roleId, String ruDesc) {
        this.ruId = ruId;
        this.userId = userId;
        this.roleId = roleId;
        this.ruDesc = ruDesc;
    }

    public UserAssociateRolePo() {
        super();
    }

    public Integer getRuId() {
        return ruId;
    }

    public void setRuId(Integer ruId) {
        this.ruId = ruId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRuDesc() {
        return ruDesc;
    }

    public void setRuDesc(String ruDesc) {
        this.ruDesc = ruDesc == null ? null : ruDesc.trim();
    }
}