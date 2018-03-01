package com.wugeek.auth.service.dao.unit;

import com.wugeek.auth.api.model.po.ApiPo;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by guoshixiong on 2017/6/23.
 * <p>
 * version: 1.0
 */
@Mapper
public interface PermissionApiUnit {

    @Select({
            "select",
            "api.API_ID, API_name, API_http_method, API_URL, API_version, API_category, API_programmer, ",
            "API_desc",
            "from",
            "api, permission_associate_api, permission",
            "where",
            "permission.permission_ID = #{id, jdbcType = INTEGER} and",
            "permission.permission_ID = permission_associate_api.permission_ID and",
            "permission_associate_api.api_ID = api.api_ID"
    })
    @ConstructorArgs({
            @Arg(column = "API_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "API_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "API_http_method", javaType = String.class, jdbcType = JdbcType.CHAR),
            @Arg(column = "API_URL", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "API_version", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "API_category", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "API_programmer", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "API_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<ApiPo> retrieveApi(Integer id);
}
