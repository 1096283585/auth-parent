package com.wugeek.auth.service.dao.basic.provider;

import com.wugeek.auth.api.model.po.ApiPo;
import org.apache.ibatis.jdbc.SQL;

public class ApiDaoSqlProvider {

    public String insertSelective(ApiPo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("api");

        if (record.getApiId() != null) {
            sql.VALUES("API_ID", "#{apiId,jdbcType=INTEGER}");
        }

        if (record.getApiName() != null) {
            sql.VALUES("API_name", "#{apiName,jdbcType=VARCHAR}");
        }

        if (record.getApiHttpMethod() != null) {
            sql.VALUES("API_http_method", "#{apiHttpMethod,jdbcType=CHAR}");
        }

        if (record.getApiUrl() != null) {
            sql.VALUES("API_URL", "#{apiUrl,jdbcType=VARCHAR}");
        }

        if (record.getApiVersion() != null) {
            sql.VALUES("API_version", "#{apiVersion,jdbcType=VARCHAR}");
        }

        if (record.getApiCategory() != null) {
            sql.VALUES("API_category", "#{apiCategory,jdbcType=VARCHAR}");
        }

        if (record.getApiProgrammer() != null) {
            sql.VALUES("API_programmer", "#{apiProgrammer,jdbcType=VARCHAR}");
        }

        if (record.getApiDesc() != null) {
            sql.VALUES("API_desc", "#{apiDesc,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ApiPo record) {
        SQL sql = new SQL();
        sql.UPDATE("api");

        if (record.getApiName() != null) {
            sql.SET("API_name = #{apiName,jdbcType=VARCHAR}");
        }

        if (record.getApiHttpMethod() != null) {
            sql.SET("API_http_method = #{apiHttpMethod,jdbcType=CHAR}");
        }

        if (record.getApiUrl() != null) {
            sql.SET("API_URL = #{apiUrl,jdbcType=VARCHAR}");
        }

        if (record.getApiVersion() != null) {
            sql.SET("API_version = #{apiVersion,jdbcType=VARCHAR}");
        }

        if (record.getApiCategory() != null) {
            sql.SET("API_category = #{apiCategory,jdbcType=VARCHAR}");
        }

        if (record.getApiProgrammer() != null) {
            sql.SET("API_programmer = #{apiProgrammer,jdbcType=VARCHAR}");
        }

        if (record.getApiDesc() != null) {
            sql.SET("API_desc = #{apiDesc,jdbcType=VARCHAR}");
        }

        sql.WHERE("API_ID = #{apiId,jdbcType=INTEGER}");

        return sql.toString();
    }
}