package com.wugeek.auth.service.dao.basic.provider;

import com.wugeek.auth.api.model.po.PermissionAssociateApiPo;
import org.apache.ibatis.jdbc.SQL;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class PermissionAssociateApiDaoSqlProvider {

    public String insertSelective(PermissionAssociateApiPo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("permission_associate_api");

        if (record.getPaId() != null) {
            sql.VALUES("pa_ID", "#{paId,jdbcType=INTEGER}");
        }

        if (record.getPermissionId() != null) {
            sql.VALUES("permission_ID", "#{permissionId,jdbcType=INTEGER}");
        }

        if (record.getApiId() != null) {
            sql.VALUES("api_ID", "#{apiId,jdbcType=INTEGER}");
        }

        if (record.getPaDesc() != null) {
            sql.VALUES("pa_desc", "#{paDesc,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PermissionAssociateApiPo record) {
        SQL sql = new SQL();
        sql.UPDATE("permission_associate_api");

        if (record.getPermissionId() != null) {
            sql.SET("permission_ID = #{permissionId,jdbcType=INTEGER}");
        }

        if (record.getApiId() != null) {
            sql.SET("api_ID = #{apiId,jdbcType=INTEGER}");
        }

        if (record.getPaDesc() != null) {
            sql.SET("pa_desc = #{paDesc,jdbcType=VARCHAR}");
        }

        sql.WHERE("pa_ID = #{paId,jdbcType=INTEGER}");

        return sql.toString();
    }

    public String insertAll(Map map) {
        List<PermissionAssociateApiPo> list = (List<PermissionAssociateApiPo>) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO permission_associate_api ");
        sb.append("(permission_ID, api_ID) ");
        sb.append("VALUES ");
        MessageFormat mf = new MessageFormat("(#'{'list[{0}].permissionId}, #'{'list[{0}].apiId})");
        for (int i = 0; i < list.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}