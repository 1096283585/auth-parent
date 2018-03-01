package com.wugeek.auth.service.dao.basic.provider;

import com.wugeek.auth.api.model.po.PermissionCategoryPo;
import org.apache.ibatis.jdbc.SQL;

public class PermissionCategoryDaoSqlProvider {

    public String insertSelective(PermissionCategoryPo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("permission_category");

        if (record.getPermissionCategoryId() != null) {
            sql.VALUES("permission_category_ID", "#{permissionCategoryId,jdbcType=INTEGER}");
        }

        if (record.getPermissionCategory() != null) {
            sql.VALUES("permission_category", "#{permissionCategory,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PermissionCategoryPo record) {
        SQL sql = new SQL();
        sql.UPDATE("permission_category");

        if (record.getPermissionCategory() != null) {
            sql.SET("permission_category = #{permissionCategory,jdbcType=VARCHAR}");
        }

        sql.WHERE("permission_category_ID = #{permissionCategoryId,jdbcType=INTEGER}");

        return sql.toString();
    }
}