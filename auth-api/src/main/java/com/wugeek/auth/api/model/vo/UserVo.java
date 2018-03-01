package com.wugeek.auth.api.model.vo;

import java.io.Serializable;

/**
 * Created by guoshixiong on 2017/6/20.
 * <p>
 * version: 1.0
 */
public class UserVo implements Serializable {

    private int userId;
    private String userCategory;
    private String loginName;
    private String password;
    private String userCode;
    private String userDescription;

    public UserVo() {
    }

    public UserVo(int userId, String userCategory, String loginName, String password, String userCode, String userDescription) {
        this.userId = userId;
        this.userCategory = userCategory;
        this.loginName = loginName;
        this.password = password;
        this.userCode = userCode;
        this.userDescription = userDescription;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }
}
