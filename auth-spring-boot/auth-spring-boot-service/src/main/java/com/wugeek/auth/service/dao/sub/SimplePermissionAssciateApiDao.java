package com.wugeek.auth.service.dao.sub;

import com.wugeek.auth.api.model.po.PermissionAssociateApiPo;
import com.wugeek.auth.service.dao.basic.PermissionAssciateApiDao;
import com.wugeek.auth.service.dao.basic.provider.PermissionAssociateApiDaoSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by guoshixiong on 2017/6/9.
 * <p>
 * version: 1.0
 */
@Mapper
public interface SimplePermissionAssciateApiDao extends PermissionAssciateApiDao {

    @Select({
            "select",
            "pa_ID, permission_ID, api_ID, pa_desc",
            "from permission_associate_api"
    })
    @ConstructorArgs({
            @Arg(column = "pa_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "permission_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "api_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "pa_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<PermissionAssociateApiPo> selectAll();

    @Select({
            "select",
            "pa_ID, permission_ID, api_ID, pa_desc",
            "from permission_associate_api",
            "limit #{arg0}, #{arg1}"
    })
    @ConstructorArgs({
            @Arg(column = "pa_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "permission_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "api_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "pa_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<PermissionAssociateApiPo> selectByPage(Integer offset, Integer count);

    @InsertProvider(type = PermissionAssociateApiDaoSqlProvider.class, method = "insertAll")
    int insertAll(List<PermissionAssociateApiPo> apiPos);

    @Delete({
            "delete from permission_associate_api",
            "where permission_ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPermissionid(Integer id);
}
