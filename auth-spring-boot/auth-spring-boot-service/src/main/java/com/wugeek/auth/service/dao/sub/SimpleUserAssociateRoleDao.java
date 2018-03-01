package com.wugeek.auth.service.dao.sub;

import com.wugeek.auth.api.model.po.UserAssociateRolePo;
import com.wugeek.auth.service.dao.basic.UserAssociateRoleDao;
import com.wugeek.auth.service.dao.basic.provider.UserAssociateRoleDaoSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by guoshixiong on 2017/6/9.
 * <p>
 * version: 1.0
 */
@Mapper
public interface SimpleUserAssociateRoleDao extends UserAssociateRoleDao {

    @Select({
            "select",
            "ru_ID, user_ID, role_ID, ru_desc",
            "from user_associate_role"
    })
    @ConstructorArgs({
            @Arg(column = "ru_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "user_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "role_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "ru_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<UserAssociateRolePo> selectAll();

    @Select({
            "select",
            "ru_ID, user_ID, role_ID, ru_desc",
            "from user_associate_role",
            "limit #{arg0}, #{arg1}"
    })
    @ConstructorArgs({
            @Arg(column = "ru_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "user_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "role_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "ru_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<UserAssociateRolePo> selectByPage(Integer offset, Integer count);

    @Select({
            "select",
            "ru_ID, user_ID, role_ID, ru_desc",
            "from user_associate_role",
            "where user_ID = #{id, jdbcType=INTEGER}"
    })
    List<UserAssociateRolePo> selectByUserId(Integer id);

    @InsertProvider(type = UserAssociateRoleDaoSqlProvider.class, method = "insertAll")
    int insertAll(List<UserAssociateRolePo> apiPos);

    @Delete({
            "delete from user_associate_role",
            "where user_ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByUserId(Integer id);
}
