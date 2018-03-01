package com.wugeek.auth.service.dao.sub;

import com.wugeek.auth.api.model.po.TokenPo;
import com.wugeek.auth.service.dao.basic.TokenDao;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/**
 * Created by guoshixiong on 2017/6/10.
 * <p>
 * version: 1.0
 */
@Mapper
public interface SimpleTokenDao extends TokenDao {

    @Select({
            "select",
            "token_ID, token_name, create_time, effective_minutes, user_ID",
            "from token"
    })
    @ConstructorArgs({
            @Arg(column = "token_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "token_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "create_time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "effective_minutes", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "user_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER)
    })
    List<TokenPo> selectAll();

    @Select({
            "select",
            "token_ID, token_name, create_time, effective_minutes, user_ID",
            "from token",
            "limit #{arg0}, #{arg1}"
    })
    @ConstructorArgs({
            @Arg(column = "token_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "token_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "create_time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "effective_minutes", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "user_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER)
    })
    List<TokenPo> selectByPage(Integer offset, Integer count);

    @Select({
            "select",
            "*",
            "from token",
            "where token_name = #{token, jdbcType = VARCHAR}"
    })
    @ConstructorArgs({
            @Arg(column = "token_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "token_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "create_time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "effective_minutes", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "user_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER)
    })
    TokenPo selectByToken(String token);

    @Select({
            "select",
            "*",
            "from token",
            "where",
            "user_ID = #{userId, jdbcType = INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "token_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "token_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "create_time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "effective_minutes", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "user_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER)
    })
    TokenPo selectByUserId(Integer userId);

    @Delete({
            "delete from token",
            "where token_name = #{token,jdbcType=VARCHAR}"
    })
    int deleteByToken(String token);

    @Delete({
            "delete from token",
            "where user_ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByUserId(Integer id);
}
