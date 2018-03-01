package com.wugeek.auth.service.dao.basic.provider;

import com.wugeek.auth.api.model.po.UserPo;
import org.apache.ibatis.jdbc.SQL;

public class UserDaoSqlProvider {

    public String insertSelective(UserPo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user");

        if (record.getUserId() != null) {
            sql.VALUES("user_ID", "#{userId,jdbcType=INTEGER}");
        }

        if (record.getUserCategoryId() != null) {
            sql.VALUES("user_category_ID", "#{userCategoryId,jdbcType=INTEGER}");
        }

        if (record.getLoginName() != null) {
            sql.VALUES("login_name", "#{loginName,jdbcType=VARCHAR}");
        }

        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }

        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }

        if (record.getUserCode() != null) {
            sql.VALUES("user_code", "#{userCode,jdbcType=VARCHAR}");
        }

        if (record.getUserActive() != null) {
            sql.VALUES("user_active", "#{userActive,jdbcType=BIT}");
        }

        if (record.getUserPosition() != null) {
            sql.VALUES("user_position", "#{userPosition,jdbcType=CHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserPo record) {
        SQL sql = new SQL();
        sql.UPDATE("user");

        if (record.getUserCategoryId() != null) {
            sql.SET("user_category_ID = #{userCategoryId,jdbcType=INTEGER}");
        }

        if (record.getLoginName() != null) {
            sql.SET("login_name = #{loginName,jdbcType=VARCHAR}");
        }

        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }

        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }

        if (record.getUserCode() != null) {
            sql.SET("user_code = #{userCode,jdbcType=VARCHAR}");
        }

        if (record.getUserActive() != null) {
            sql.SET("user_active = #{userActive,jdbcType=BIT}");
        }

        if (record.getUserPosition() != null) {
            sql.SET("user_position = #{userPosition,jdbcType=CHAR}");
        }

        sql.WHERE("user_ID = #{userId,jdbcType=INTEGER}");

        return sql.toString();
    }
}