package com.wugeek.auth.service.dao.basic.provider;

import com.wugeek.auth.api.model.po.UserCategoryPo;
import org.apache.ibatis.jdbc.SQL;

public class UserCategoryDaoSqlProvider {

    public String insertSelective(UserCategoryPo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_category");

        if (record.getUserCategoryId() != null) {
            sql.VALUES("user_category_ID", "#{userCategoryId,jdbcType=INTEGER}");
        }

        if (record.getUserCategory() != null) {
            sql.VALUES("user_category", "#{userCategory,jdbcType=CHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserCategoryPo record) {
        SQL sql = new SQL();
        sql.UPDATE("user_category");

        if (record.getUserCategory() != null) {
            sql.SET("user_category = #{userCategory,jdbcType=CHAR}");
        }

        sql.WHERE("user_category_ID = #{userCategoryId,jdbcType=INTEGER}");

        return sql.toString();
    }
}