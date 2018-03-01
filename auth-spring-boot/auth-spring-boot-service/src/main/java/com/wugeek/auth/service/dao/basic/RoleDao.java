package com.wugeek.auth.service.dao.basic;

import com.wugeek.auth.api.model.po.RolePo;
import com.wugeek.auth.service.dao.basic.provider.RoleDaoSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import pers.web.service.dao.BasicCRUDDao;

public interface RoleDao extends BasicCRUDDao<RolePo, Integer> {
    @Delete({
            "delete from role",
            "where role_ID = #{roleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer roleId);

    @Insert({
            "insert into role (role_ID, role_name, ",
            "role_description)",
            "values (#{roleId,jdbcType=INTEGER}, #{roleName,jdbcType=VARCHAR}, ",
            "#{roleDescription,jdbcType=VARCHAR})"
    })
    int insert(RolePo record);

    @InsertProvider(type = RoleDaoSqlProvider.class, method = "insertSelective")
    int insertSelective(RolePo record);

    @Select({
            "select",
            "role_ID, role_name, role_description",
            "from role",
            "where role_ID = #{roleId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "role_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "role_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "role_description", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    RolePo selectByPrimaryKey(Integer roleId);

    @UpdateProvider(type = RoleDaoSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RolePo record);

    @Update({
            "update role",
            "set role_name = #{roleName,jdbcType=VARCHAR},",
            "role_description = #{roleDescription,jdbcType=VARCHAR}",
            "where role_ID = #{roleId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RolePo record);
}