package com.wugeek.auth.api.model.vo;

import java.io.Serializable;

/**
 * Created by guoshixiong on 2017/6/24.
 * <p>
 * version: 1.0
 */
public class UserBindRoleVo implements Serializable {

    private Integer userId;
    private Integer[] roleId;

    public UserBindRoleVo() {
    }

    public UserBindRoleVo(Integer userId, Integer[] roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer[] getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer[] roleId) {
        this.roleId = roleId;
    }
}
