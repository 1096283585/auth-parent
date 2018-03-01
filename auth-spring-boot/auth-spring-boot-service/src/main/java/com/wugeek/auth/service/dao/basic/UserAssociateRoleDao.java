package com.wugeek.auth.service.dao.basic;

import com.wugeek.auth.api.model.po.UserAssociateRolePo;
import com.wugeek.auth.service.dao.basic.provider.UserAssociateRoleDaoSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import pers.web.service.dao.BasicCRUDDao;

public interface UserAssociateRoleDao extends BasicCRUDDao<UserAssociateRolePo, Integer> {
    @Delete({
            "delete from user_associate_role",
            "where ru_ID = #{ruId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer ruId);

    @Insert({
            "insert into user_associate_role (ru_ID, user_ID, ",
            "role_ID, ru_desc)",
            "values (#{ruId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
            "#{roleId,jdbcType=INTEGER}, #{ruDesc,jdbcType=VARCHAR})"
    })
    int insert(UserAssociateRolePo record);

    @InsertProvider(type = UserAssociateRoleDaoSqlProvider.class, method = "insertSelective")
    int insertSelective(UserAssociateRolePo record);

    @Select({
            "select",
            "ru_ID, user_ID, role_ID, ru_desc",
            "from user_associate_role",
            "where ru_ID = #{ruId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "ru_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "user_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "role_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "ru_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    UserAssociateRolePo selectByPrimaryKey(Integer ruId);

    @UpdateProvider(type = UserAssociateRoleDaoSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserAssociateRolePo record);

    @Update({
            "update user_associate_role",
            "set user_ID = #{userId,jdbcType=INTEGER},",
            "role_ID = #{roleId,jdbcType=INTEGER},",
            "ru_desc = #{ruDesc,jdbcType=VARCHAR}",
            "where ru_ID = #{ruId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserAssociateRolePo record);
}