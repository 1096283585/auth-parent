package com.wugeek.auth.service.dao.sub;

import com.wugeek.auth.api.model.po.RoleAssociatePermissionPo;
import com.wugeek.auth.service.dao.basic.RoleAssocicatePermissionDao;
import com.wugeek.auth.service.dao.basic.provider.RoleAssociatePermissionDaoSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by guoshixiong on 2017/6/9.
 * <p>
 * version: 1.0
 */
@Mapper
public interface SimpleRoleAssocicatePermissionDao extends RoleAssocicatePermissionDao {

    @Select({
            "select",
            "rp_ID, role_ID, permission_ID, rp_desc",
            "from role_associate_permission"
    })
    @ConstructorArgs({
            @Arg(column = "rp_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "role_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "permission_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "rp_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<RoleAssociatePermissionPo> selectAll();

    @Select({
            "select",
            "rp_ID, role_ID, permission_ID, rp_desc",
            "from role_associate_permission",
            "limit #{arg0}, #{arg1}"
    })
    @ConstructorArgs({
            @Arg(column = "rp_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "role_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "permission_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "rp_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<RoleAssociatePermissionPo> selectByPage(Integer offset, Integer count);

    @InsertProvider(type = RoleAssociatePermissionDaoSqlProvider.class, method = "insertAll")
    int insertAll(List<RoleAssociatePermissionPo> apiPos);

    @Delete({
            "delete from role_associate_permission",
            "where role_ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByRoleId(Integer id);
}
