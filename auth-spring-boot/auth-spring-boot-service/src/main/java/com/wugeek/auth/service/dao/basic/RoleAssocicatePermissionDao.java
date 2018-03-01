package com.wugeek.auth.service.dao.basic;

import com.wugeek.auth.api.model.po.RoleAssociatePermissionPo;
import com.wugeek.auth.service.dao.basic.provider.RoleAssociatePermissionDaoSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import pers.web.service.dao.BasicCRUDDao;

public interface RoleAssocicatePermissionDao extends BasicCRUDDao<RoleAssociatePermissionPo, Integer> {
    @Delete({
            "delete from role_associate_permission",
            "where rp_ID = #{rpId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer rpId);

    @Insert({
            "insert into role_associate_permission (rp_ID, role_ID, ",
            "permission_ID, rp_desc)",
            "values (#{rpId,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER}, ",
            "#{permissionId,jdbcType=INTEGER}, #{rpDesc,jdbcType=VARCHAR})"
    })
    int insert(RoleAssociatePermissionPo record);

    @InsertProvider(type = RoleAssociatePermissionDaoSqlProvider.class, method = "insertSelective")
    int insertSelective(RoleAssociatePermissionPo record);

    @Select({
            "select",
            "rp_ID, role_ID, permission_ID, rp_desc",
            "from role_associate_permission",
            "where rp_ID = #{rpId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "rp_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "role_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "permission_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "rp_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    RoleAssociatePermissionPo selectByPrimaryKey(Integer rpId);

    @UpdateProvider(type = RoleAssociatePermissionDaoSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RoleAssociatePermissionPo record);

    @Update({
            "update role_associate_permission",
            "set role_ID = #{roleId,jdbcType=INTEGER},",
            "permission_ID = #{permissionId,jdbcType=INTEGER},",
            "rp_desc = #{rpDesc,jdbcType=VARCHAR}",
            "where rp_ID = #{rpId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RoleAssociatePermissionPo record);
}