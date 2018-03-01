package com.wugeek.auth.service.dao.basic.provider;

import com.wugeek.auth.api.model.po.RolePo;
import org.apache.ibatis.jdbc.SQL;

public class RoleDaoSqlProvider {

    public String insertSelective(RolePo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("role");

        if (record.getRoleId() != null) {
            sql.VALUES("role_ID", "#{roleId,jdbcType=INTEGER}");
        }

        if (record.getRoleName() != null) {
            sql.VALUES("role_name", "#{roleName,jdbcType=VARCHAR}");
        }

        if (record.getRoleDescription() != null) {
            sql.VALUES("role_description", "#{roleDescription,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RolePo record) {
        SQL sql = new SQL();
        sql.UPDATE("role");

        if (record.getRoleName() != null) {
            sql.SET("role_name = #{roleName,jdbcType=VARCHAR}");
        }

        if (record.getRoleDescription() != null) {
            sql.SET("role_description = #{roleDescription,jdbcType=VARCHAR}");
        }

        sql.WHERE("role_ID = #{roleId,jdbcType=INTEGER}");

        return sql.toString();
    }
}