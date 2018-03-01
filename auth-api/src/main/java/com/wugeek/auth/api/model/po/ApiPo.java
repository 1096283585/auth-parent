package com.wugeek.auth.api.model.po;

import java.io.Serializable;

public class ApiPo implements Serializable {

    private Integer apiId;

    private String apiName;

    private String apiHttpMethod;

    private String apiUrl;

    private String apiVersion;

    private String apiCategory;

    private String apiProgrammer;

    private String apiDesc;

    public ApiPo(Integer apiId, String apiName, String apiHttpMethod, String apiUrl, String apiVersion, String apiCategory, String apiProgrammer, String apiDesc) {
        this.apiId = apiId;
        this.apiName = apiName;
        this.apiHttpMethod = apiHttpMethod;
        this.apiUrl = apiUrl;
        this.apiVersion = apiVersion;
        this.apiCategory = apiCategory;
        this.apiProgrammer = apiProgrammer;
        this.apiDesc = apiDesc;
    }

    public ApiPo() {
        super();
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName == null ? null : apiName.trim();
    }

    public String getApiHttpMethod() {
        return apiHttpMethod;
    }

    public void setApiHttpMethod(String apiHttpMethod) {
        this.apiHttpMethod = apiHttpMethod == null ? null : apiHttpMethod.trim();
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl == null ? null : apiUrl.trim();
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion == null ? null : apiVersion.trim();
    }

    public String getApiCategory() {
        return apiCategory;
    }

    public void setApiCategory(String apiCategory) {
        this.apiCategory = apiCategory == null ? null : apiCategory.trim();
    }

    public String getApiProgrammer() {
        return apiProgrammer;
    }

    public void setApiProgrammer(String apiProgrammer) {
        this.apiProgrammer = apiProgrammer == null ? null : apiProgrammer.trim();
    }

    public String getApiDesc() {
        return apiDesc;
    }

    public void setApiDesc(String apiDesc) {
        this.apiDesc = apiDesc == null ? null : apiDesc.trim();
    }
}