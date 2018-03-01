package com.wugeek.auth.service.dao.basic.provider;

import com.wugeek.auth.api.model.po.RoleAssociatePermissionPo;
import org.apache.ibatis.jdbc.SQL;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class RoleAssociatePermissionDaoSqlProvider {

    public String insertSelective(RoleAssociatePermissionPo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("role_associate_permission");

        if (record.getRpId() != null) {
            sql.VALUES("rp_ID", "#{rpId,jdbcType=INTEGER}");
        }

        if (record.getRoleId() != null) {
            sql.VALUES("role_ID", "#{roleId,jdbcType=INTEGER}");
        }

        if (record.getPermissionId() != null) {
            sql.VALUES("permission_ID", "#{permissionId,jdbcType=INTEGER}");
        }

        if (record.getRpDesc() != null) {
            sql.VALUES("rp_desc", "#{rpDesc,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RoleAssociatePermissionPo record) {
        SQL sql = new SQL();
        sql.UPDATE("role_associate_permission");

        if (record.getRoleId() != null) {
            sql.SET("role_ID = #{roleId,jdbcType=INTEGER}");
        }

        if (record.getPermissionId() != null) {
            sql.SET("permission_ID = #{permissionId,jdbcType=INTEGER}");
        }

        if (record.getRpDesc() != null) {
            sql.SET("rp_desc = #{rpDesc,jdbcType=VARCHAR}");
        }

        sql.WHERE("rp_ID = #{rpId,jdbcType=INTEGER}");

        return sql.toString();
    }

    public String insertAll(Map map) {
        List<RoleAssociatePermissionPo> list = (List<RoleAssociatePermissionPo>) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO role_associate_permission ");
        sb.append("(role_ID, permission_ID) ");
        sb.append("VALUES ");
        MessageFormat mf = new MessageFormat("(#'{'list[{0}].roleId}, #'{'list[{0}].permissionId})");
        for (int i = 0; i < list.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}