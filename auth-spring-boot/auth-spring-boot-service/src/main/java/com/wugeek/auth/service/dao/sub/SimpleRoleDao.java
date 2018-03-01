package com.wugeek.auth.service.dao.sub;

import com.wugeek.auth.api.model.po.RolePo;
import com.wugeek.auth.service.dao.basic.RoleDao;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by guoshixiong on 2017/6/9.
 * <p>
 * version: 1.0
 */
@Mapper
public interface SimpleRoleDao extends RoleDao {

    @Select({
            "select",
            "role_ID, role_name, role_description",
            "from role"
    })
    @ConstructorArgs({
            @Arg(column = "role_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "role_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "role_description", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<RolePo> selectAll();

    @Select({
            "select",
            "role_ID, role_name, role_description",
            "from role",
            "limit #{arg0}, #{arg1}"
    })
    @ConstructorArgs({
            @Arg(column = "role_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "role_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "role_description", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<RolePo> selectByPage(Integer offset, Integer count);
}
