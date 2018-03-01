package com.wugeek.auth.service.dao.basic;

import com.wugeek.auth.api.model.po.PermissionCategoryPo;
import com.wugeek.auth.service.dao.basic.provider.PermissionCategoryDaoSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import pers.web.service.dao.BasicCRUDDao;

@Mapper
public interface PermissionCategoryDao extends BasicCRUDDao<PermissionCategoryPo, Integer> {

    @Delete({
            "delete from permission_category",
            "where permission_category_ID = #{permissionCategoryId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer permissionCategoryId);

    @Insert({
            "insert into permission_category (permission_category_ID, permission_category)",
            "values (#{permissionCategoryId,jdbcType=INTEGER}, #{permissionCatagory,jdbcType=VARCHAR})"
    })
    int insert(PermissionCategoryPo record);

    @InsertProvider(type = PermissionCategoryDaoSqlProvider.class, method = "insertSelective")
    int insertSelective(PermissionCategoryPo record);

    @Select({
            "select",
            "permission_category_ID, permission_category",
            "from permission_category",
            "where permission_category_ID = #{permissionCategoryId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "permission_category_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "permission_category", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    PermissionCategoryPo selectByPrimaryKey(Integer permissionCategoryId);

    @UpdateProvider(type = PermissionCategoryDaoSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PermissionCategoryPo record);

    @Update({
            "update permission_category",
            "set permission_category = #{permissionCatagory,jdbcType=VARCHAR}",
            "where permission_category_ID = #{permissionCategoryId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PermissionCategoryPo record);
}