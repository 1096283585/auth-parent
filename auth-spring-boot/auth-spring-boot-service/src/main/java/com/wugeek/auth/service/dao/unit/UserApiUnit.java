package com.wugeek.auth.service.dao.unit;

import com.wugeek.auth.api.model.po.ApiPo;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface UserApiUnit {

    @Select({
            "select",
            "api.API_ID, API_name, API_http_method, API_URL, API_version, API_category, API_programmer, API_desc",
            "from ",
            "user_associate_role,",
            "role_associate_permission,",
            "permission_associate_api,",
            "api",
            "where ",
            "user_associate_role.user_ID = #{userId,jdbcType=INTEGER} and",
            "user_associate_role.role_ID = role_associate_permission.role_ID and",
            "role_associate_permission.permission_ID = permission_associate_api.permission_ID and",
            "permission_associate_api.api_ID = api.API_ID",
            "group by api.API_ID"
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
    List<ApiPo> selectByUserId(Integer userId);
}
