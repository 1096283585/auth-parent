package com.wugeek.auth.service.dao.unit;

import com.wugeek.auth.api.model.po.PermissionPo;
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
public interface RolePermissionUnit {

    @Select({
            "select",
            "permission.permission_ID, permission_catagory_ID, permission_identity, permission_name, ",
            "permission_desc",
            "from",
            "permission, role_associate_permission, role",
            "where",
            "role.role_ID = #{id, jdbcType = INTEGER} and",
            "role.role_ID = role_associate_permission.role_ID and",
            "role_associate_permission.permission_ID = permission.permission_ID"
    })
    @ConstructorArgs({
            @Arg(column = "permission_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "permission_catagory_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "permission_identity", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "permission_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "permission_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<PermissionPo> retrievePermissionByRoleId(Integer id);
}
