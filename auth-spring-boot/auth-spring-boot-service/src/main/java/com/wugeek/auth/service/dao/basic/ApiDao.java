package com.wugeek.auth.service.dao.basic;

import com.wugeek.auth.api.model.po.ApiPo;
import com.wugeek.auth.service.dao.basic.provider.ApiDaoSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import pers.web.service.dao.BasicCRUDDao;

public interface ApiDao extends BasicCRUDDao<ApiPo, Integer> {

    @Delete({
            "delete from api",
            "where API_ID = #{apiId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer apiId);

    @Insert({
            "insert into api (API_ID, API_name, ",
            "API_http_method, API_URL, ",
            "API_version, API_category, ",
            "API_programmer, API_desc)",
            "values (#{apiId,jdbcType=INTEGER}, #{apiName,jdbcType=VARCHAR}, ",
            "#{apiHttpMethod,jdbcType=CHAR}, #{apiUrl,jdbcType=VARCHAR}, ",
            "#{apiVersion,jdbcType=VARCHAR}, #{apiCategory,jdbcType=VARCHAR}, ",
            "#{apiProgrammer,jdbcType=VARCHAR}, #{apiDesc,jdbcType=VARCHAR})"
    })
    int insert(ApiPo record);

    @InsertProvider(type = ApiDaoSqlProvider.class, method = "insertSelective")
    int insertSelective(ApiPo record);

    @Select({
            "select",
            "API_ID, API_name, API_http_method, API_URL, API_version, API_category, API_programmer, ",
            "API_desc",
            "from api",
            "where API_ID = #{apiId,jdbcType=INTEGER}"
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
    ApiPo selectByPrimaryKey(Integer apiId);

    @UpdateProvider(type = ApiDaoSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ApiPo record);

    @Update({
            "update api",
            "set API_name = #{apiName,jdbcType=VARCHAR},",
            "API_http_method = #{apiHttpMethod,jdbcType=CHAR},",
            "API_URL = #{apiUrl,jdbcType=VARCHAR},",
            "API_version = #{apiVersion,jdbcType=VARCHAR},",
            "API_category = #{apiCategory,jdbcType=VARCHAR},",
            "API_programmer = #{apiProgrammer,jdbcType=VARCHAR},",
            "API_desc = #{apiDesc,jdbcType=VARCHAR}",
            "where API_ID = #{apiId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ApiPo record);
}