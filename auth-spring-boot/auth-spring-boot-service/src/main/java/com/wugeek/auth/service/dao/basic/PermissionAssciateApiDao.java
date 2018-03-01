package com.wugeek.auth.service.dao.basic;

import com.wugeek.auth.api.model.po.PermissionAssociateApiPo;
import com.wugeek.auth.service.dao.basic.provider.PermissionAssociateApiDaoSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import pers.web.service.dao.BasicCRUDDao;

public interface PermissionAssciateApiDao extends BasicCRUDDao<PermissionAssociateApiPo, Integer> {
    @Delete({
            "delete from permission_associate_api",
            "where pa_ID = #{paId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer paId);

    @Insert({
            "insert into permission_associate_api (pa_ID, permission_ID, ",
            "api_ID, pa_desc)",
            "values (#{paId,jdbcType=INTEGER}, #{permissionId,jdbcType=INTEGER}, ",
            "#{apiId,jdbcType=INTEGER}, #{paDesc,jdbcType=VARCHAR})"
    })
    int insert(PermissionAssociateApiPo record);

    @InsertProvider(type = PermissionAssociateApiDaoSqlProvider.class, method = "insertSelective")
    int insertSelective(PermissionAssociateApiPo record);

    @Select({
            "select",
            "pa_ID, permission_ID, api_ID, pa_desc",
            "from permission_associate_api",
            "where pa_ID = #{paId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "pa_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "permission_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "api_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "pa_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    PermissionAssociateApiPo selectByPrimaryKey(Integer paId);

    @UpdateProvider(type = PermissionAssociateApiDaoSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PermissionAssociateApiPo record);

    @Update({
            "update permission_associate_api",
            "set permission_ID = #{permissionId,jdbcType=INTEGER},",
            "api_ID = #{apiId,jdbcType=INTEGER},",
            "pa_desc = #{paDesc,jdbcType=VARCHAR}",
            "where pa_ID = #{paId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PermissionAssociateApiPo record);
}