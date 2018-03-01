package com.wugeek.auth.service.dao.basic.provider;

import com.wugeek.auth.api.model.po.RoleAssociatePermissionPo;
import com.wugeek.auth.api.model.po.UserAssociateRolePo;
import org.apache.ibatis.jdbc.SQL;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class UserAssociateRoleDaoSqlProvider {

    public String insertSelective(UserAssociateRolePo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_associate_role");

        if (record.getRuId() != null) {
            sql.VALUES("ru_ID", "#{ruId,jdbcType=INTEGER}");
        }

        if (record.getUserId() != null) {
            sql.VALUES("user_ID", "#{userId,jdbcType=INTEGER}");
        }

        if (record.getRoleId() != null) {
            sql.VALUES("role_ID", "#{roleId,jdbcType=INTEGER}");
        }

        if (record.getRuDesc() != null) {
            sql.VALUES("ru_desc", "#{ruDesc,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserAssociateRolePo record) {
        SQL sql = new SQL();
        sql.UPDATE("user_associate_role");

        if (record.getUserId() != null) {
            sql.SET("user_ID = #{userId,jdbcType=INTEGER}");
        }

        if (record.getRoleId() != null) {
            sql.SET("role_ID = #{roleId,jdbcType=INTEGER}");
        }

        if (record.getRuDesc() != null) {
            sql.SET("ru_desc = #{ruDesc,jdbcType=VARCHAR}");
        }

        sql.WHERE("ru_ID = #{ruId,jdbcType=INTEGER}");

        return sql.toString();
    }

    public String insertAll(Map map) {
        List<UserAssociateRolePo> list = (List<UserAssociateRolePo>) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO user_associate_role ");
        sb.append("(user_ID, role_ID) ");
        sb.append("VALUES ");
        MessageFormat mf = new MessageFormat("(#'{'list[{0}].userId}, #'{'list[{0}].roleId})");
        for (int i = 0; i < list.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}