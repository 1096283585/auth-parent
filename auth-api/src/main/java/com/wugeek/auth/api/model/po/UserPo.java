package com.wugeek.auth.api.model.po;

import java.io.Serializable;

public class UserPo implements Serializable {

    private Integer userId;
    private Integer userCategoryId;
    private String loginName;
    private String password;
    private String userName;
    private String userCode;
    private Boolean userActive;
    private String userPosition;

    public UserPo(Integer userId, Integer userCategoryId, String loginName, String password, String userName, String userCode, Boolean userActive, String userPosition) {
        this.userId = userId;
        this.userCategoryId = userCategoryId;
        this.loginName = loginName;
        this.password = password;
        this.userName = userName;
        this.userCode = userCode;
        this.userActive = userActive;
        this.userPosition = userPosition;
    }

    public UserPo() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserCategoryId() {
        return userCategoryId;
    }

    public void setUserCategoryId(Integer userCategoryId) {
        this.userCategoryId = userCategoryId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public Boolean getUserActive() {
        return userActive;
    }

    public void setUserActive(Boolean userActive) {
        this.userActive = userActive;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition == null ? null : userPosition.trim();
    }

    @Override
    public String toString() {
        return "UserPo{" +
               "userId=" + userId +
               ", userCategoryId=" + userCategoryId +
               ", loginName='" + loginName + '\'' +
               ", password='" + password + '\'' +
               ", userName='" + userName + '\'' +
               ", userCode='" + userCode + '\'' +
               ", userActive=" + userActive +
               ", userPosition='" + userPosition + '\'' +
               '}';
    }
}