package com.wugeek.auth.service.dao.unit;

import com.wugeek.auth.api.model.po.RolePo;
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
public interface UserRoleUnit {

    @Select({
            "select",
            "role.role_ID, role.role_name, role.role_description",
            "from",
            "user, user_associate_role, role",
            "where",
            "user.user_ID = #{id, jdbcType = INTEGER} and",
            "user.user_ID = user_associate_role.user_ID and",
            "user_associate_role.role_ID = role.role_ID"
    })
    @ConstructorArgs({
            @Arg(column = "role_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "role_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "role_description", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<RolePo> selectByUserId(Integer id);
}
