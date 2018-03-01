package com.wugeek.auth.service.dao.basic;

import com.wugeek.auth.api.model.po.PermissionPo;
import com.wugeek.auth.service.dao.basic.provider.PermissionDaoSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import pers.web.service.dao.BasicCRUDDao;

public interface PermissionDao extends BasicCRUDDao<PermissionPo, Integer> {

    @Delete({
            "delete from permission",
            "where permission_ID = #{permissionId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer permissionId);

    @SelectKey(statement = "select uuid()", keyProperty = "permission_identity", before = true, resultType = String.class)
    @Insert({
            "insert into permission (permission_ID, permission_catagory_ID, ",
            "permission_identity, permission_name, ",
            "permission_desc)",
            "values (#{permissionId,jdbcType=INTEGER}, #{permissionCatagoryId,jdbcType=INTEGER}, ",
            "#{permissionIdentity,jdbcType=VARCHAR}, #{permissionName,jdbcType=VARCHAR}, ",
            "#{permissionDesc,jdbcType=VARCHAR})"
    })
    int insert(PermissionPo record);

    @InsertProvider(type = PermissionDaoSqlProvider.class, method = "insertSelective")
    int insertSelective(PermissionPo record);

    @Select({
            "select",
            "permission_ID, permission_catagory_ID, permission_identity, permission_name, ",
            "permission_desc",
            "from permission",
            "where permission_ID = #{permissionId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "permission_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "permission_catagory_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "permission_identity", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "permission_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "permission_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    PermissionPo selectByPrimaryKey(Integer permissionId);

    @UpdateProvider(type = PermissionDaoSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PermissionPo record);

    @Update({
            "update permission",
            "set permission_catagory_ID = #{permissionCatagoryId,jdbcType=INTEGER},",
            "permission_identity = #{permissionIdentity,jdbcType=VARCHAR},",
            "permission_name = #{permissionName,jdbcType=VARCHAR},",
            "permission_desc = #{permissionDesc,jdbcType=VARCHAR}",
            "where permission_ID = #{permissionId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PermissionPo record);
}