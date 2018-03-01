package com.wugeek.auth.api.model.po;

import java.io.Serializable;

public class UserCategoryPo implements Serializable {

    private Integer userCategoryId;

    private String userCategory;

    public UserCategoryPo(Integer userCategoryId, String userCategory) {
        this.userCategoryId = userCategoryId;
        this.userCategory = userCategory;
    }

    public UserCategoryPo() {
        super();
    }

    public Integer getUserCategoryId() {
        return userCategoryId;
    }

    public void setUserCategoryId(Integer userCategoryId) {
        this.userCategoryId = userCategoryId;
    }

    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory == null ? null : userCategory.trim();
    }
}