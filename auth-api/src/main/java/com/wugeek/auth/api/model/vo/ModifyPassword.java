package com.wugeek.auth.api.model.vo;

import java.io.Serializable;

public class ModifyPassword implements Serializable {

    private String loginName;
    private String oldPassword;
    private String newPassword;

    public ModifyPassword() {
    }

    public ModifyPassword(String loginName, String oldPassword, String newPassword) {
        this.loginName = loginName;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
