package com.wugeek.auth.api.model.po;

import java.io.Serializable;

public class PermissionAssociateApiPo implements Serializable {

    private Integer paId;
    private Integer permissionId;
    private Integer apiId;
    private String paDesc;

    public PermissionAssociateApiPo(Integer paId, Integer permissionId, Integer apiId, String paDesc) {
        this.paId = paId;
        this.permissionId = permissionId;
        this.apiId = apiId;
        this.paDesc = paDesc;
    }

    public PermissionAssociateApiPo() {
        super();
    }

    public Integer getPaId() {
        return paId;
    }

    public void setPaId(Integer paId) {
        this.paId = paId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public String getPaDesc() {
        return paDesc;
    }

    public void setPaDesc(String paDesc) {
        this.paDesc = paDesc == null ? null : paDesc.trim();
    }
}