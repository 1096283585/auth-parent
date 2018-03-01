package com.wugeek.auth.api.model.vo;

import java.io.Serializable;

/**
 * Created by guoshixiong on 2017/6/24.
 * <p>
 * version: 1.0
 */
public class PermissionBindApiVo implements Serializable {

    private Integer permissionId;
    private Integer[] apiId;

    public PermissionBindApiVo() {
    }

    public PermissionBindApiVo(Integer permissionId, Integer[] apiId) {
        this.permissionId = permissionId;
        this.apiId = apiId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer[] getApiId() {
        return apiId;
    }

    public void setApiId(Integer[] apiId) {
        this.apiId = apiId;
    }
}
