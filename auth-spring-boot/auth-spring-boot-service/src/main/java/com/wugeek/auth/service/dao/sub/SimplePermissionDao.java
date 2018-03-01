package com.wugeek.auth.service.dao.sub;

import com.wugeek.auth.api.model.po.PermissionPo;
import com.wugeek.auth.service.dao.basic.PermissionDao;
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
public interface SimplePermissionDao extends PermissionDao {

    @Select({
            "select",
            "permission_ID, permission_catagory_ID, permission_identity, permission_name, ",
            "permission_desc",
            "from permission"
    })
    @ConstructorArgs({
            @Arg(column = "permission_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "permission_catagory_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "permission_identity", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "permission_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "permission_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<PermissionPo> selectAll();

    @Select({
            "select",
            "permission_ID, permission_catagory_ID, permission_identity, permission_name, ",
            "permission_desc",
            "from permission",
            "limit #{arg0}, #{arg1}"
    })
    @ConstructorArgs({
            @Arg(column = "permission_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "permission_catagory_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "permission_identity", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "permission_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "permission_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<PermissionPo> selectByPage(Integer offset, Integer count);
}
