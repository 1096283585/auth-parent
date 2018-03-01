package com.wugeek.auth.api.model.po;

import java.io.Serializable;
import java.util.Date;

public class TokenPo implements Serializable {

    private Integer tokenId;
    private String tokenName;
    private Date createTime;
    private Integer effectiveMinutes;
    private Integer userId;

    public TokenPo(Integer tokenId, String tokenName, Date createTime, Integer effectiveMinutes, Integer userId) {
        this.tokenId = tokenId;
        this.tokenName = tokenName;
        this.createTime = createTime;
        this.effectiveMinutes = effectiveMinutes;
        this.userId = userId;
    }

    public TokenPo() {
        super();
    }

    public Integer getTokenId() {
        return tokenId;
    }

    public void setTokenId(Integer tokenId) {
        this.tokenId = tokenId;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName == null ? null : tokenName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getEffectiveMinutes() {
        return effectiveMinutes;
    }

    public void setEffectiveMinutes(Integer effectiveMinutes) {
        this.effectiveMinutes = effectiveMinutes;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}