package com.wugeek.auth.service.dao.basic.provider;

import com.wugeek.auth.api.model.po.TokenPo;
import org.apache.ibatis.jdbc.SQL;

public class TokenDaoSqlProvider {

    public String insertSelective(TokenPo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("token");

        if (record.getTokenId() != null) {
            sql.VALUES("token_ID", "#{tokenId,jdbcType=INTEGER}");
        }

        if (record.getTokenName() != null) {
            sql.VALUES("token_name", "#{tokenName,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getEffectiveMinutes() != null) {
            sql.VALUES("effective_minutes", "#{effectiveMinutes,jdbcType=INTEGER}");
        }

        if (record.getUserId() != null) {
            sql.VALUES("user_ID", "#{userId,jdbcType=INTEGER}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(TokenPo record) {
        SQL sql = new SQL();
        sql.UPDATE("token");

        if (record.getTokenName() != null) {
            sql.SET("token_name = #{tokenName,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getEffectiveMinutes() != null) {
            sql.SET("effective_minutes = #{effectiveMinutes,jdbcType=INTEGER}");
        }

        if (record.getUserId() != null) {
            sql.SET("user_ID = #{userId,jdbcType=INTEGER}");
        }

        sql.WHERE("token_ID = #{tokenId,jdbcType=INTEGER}");

        return sql.toString();
    }
}