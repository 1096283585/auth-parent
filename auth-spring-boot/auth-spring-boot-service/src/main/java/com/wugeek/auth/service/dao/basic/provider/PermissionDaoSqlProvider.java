package com.wugeek.auth.service.dao.basic.provider;

import com.wugeek.auth.api.model.po.PermissionPo;
import org.apache.ibatis.jdbc.SQL;

public class PermissionDaoSqlProvider {

    public String insertSelective(PermissionPo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("permission");

        if (record.getPermissionId() != null) {
            sql.VALUES("permission_ID", "#{permissionId,jdbcType=INTEGER}");
        }

        if (record.getPermissionCatagoryId() != null) {
            sql.VALUES("permission_catagory_ID", "#{permissionCatagoryId,jdbcType=INTEGER}");
        }

        if (record.getPermissionIdentity() != null) {
            sql.VALUES("permission_identity", "#{permissionIdentity,jdbcType=VARCHAR}");
        }

        if (record.getPermissionName() != null) {
            sql.VALUES("permission_name", "#{permissionName,jdbcType=VARCHAR}");
        }

        if (record.getPermissionDesc() != null) {
            sql.VALUES("permission_desc", "#{permissionDesc,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PermissionPo record) {
        SQL sql = new SQL();
        sql.UPDATE("permission");

        if (record.getPermissionCatagoryId() != null) {
            sql.SET("permission_catagory_ID = #{permissionCatagoryId,jdbcType=INTEGER}");
        }

        if (record.getPermissionIdentity() != null) {
            sql.SET("permission_identity = #{permissionIdentity,jdbcType=VARCHAR}");
        }

        if (record.getPermissionName() != null) {
            sql.SET("permission_name = #{permissionName,jdbcType=VARCHAR}");
        }

        if (record.getPermissionDesc() != null) {
            sql.SET("permission_desc = #{permissionDesc,jdbcType=VARCHAR}");
        }

        sql.WHERE("permission_ID = #{permissionId,jdbcType=INTEGER}");

        return sql.toString();
    }
}