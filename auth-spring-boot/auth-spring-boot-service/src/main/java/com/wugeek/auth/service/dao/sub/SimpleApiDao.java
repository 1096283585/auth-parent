package com.wugeek.auth.service.dao.sub;

import com.wugeek.auth.api.model.po.ApiPo;
import com.wugeek.auth.api.model.po.PermissionAssociateApiPo;
import com.wugeek.auth.service.dao.basic.ApiDao;
import com.wugeek.auth.service.dao.basic.provider.ApiDaoSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by guoshixiong on 2017/6/9.
 * <p>
 * version: 1.0
 */
@Mapper
public interface SimpleApiDao extends ApiDao {

    @Select({
            "select",
            "API_ID, API_name, API_http_method, API_URL, API_version, API_category, API_programmer, ",
            "API_desc",
            "from api"
    })
    @ConstructorArgs({
            @Arg(column = "API_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "API_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "API_http_method", javaType = String.class, jdbcType = JdbcType.CHAR),
            @Arg(column = "API_URL", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "API_version", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "API_category", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "API_programmer", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "API_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<ApiPo> selectAll();

    @Select({
            "select",
            "API_ID, API_name, API_http_method, API_URL, API_version, API_category, API_programmer, ",
            "API_desc",
            "from api",
            "limit #{arg0}, #{arg1}"
    })
    @ConstructorArgs({
            @Arg(column = "API_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "API_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "API_http_method", javaType = String.class, jdbcType = JdbcType.CHAR),
            @Arg(column = "API_URL", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "API_version", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "API_category", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "API_programmer", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "API_desc", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<ApiPo> selectByPage(Integer offset, Integer count);
}
