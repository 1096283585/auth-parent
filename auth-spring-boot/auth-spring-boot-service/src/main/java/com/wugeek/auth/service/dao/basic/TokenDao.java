package com.wugeek.auth.service.dao.basic;

import com.wugeek.auth.api.model.po.TokenPo;
import com.wugeek.auth.service.dao.basic.provider.TokenDaoSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import pers.web.service.dao.BasicCRUDDao;

import java.util.Date;

public interface TokenDao extends BasicCRUDDao<TokenPo, Integer> {

    @Delete({
            "delete from token",
            "where token_ID = #{tokenId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tokenId);

    @Insert({
            "insert into token (token_ID, token_name, ",
            "create_time, effective_minutes, ",
            "user_ID)",
            "values (#{tokenId,jdbcType=INTEGER}, #{tokenName,jdbcType=VARCHAR}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{effectiveMinutes,jdbcType=INTEGER}, ",
            "#{userId,jdbcType=INTEGER})"
    })
    int insert(TokenPo record);

    @InsertProvider(type = TokenDaoSqlProvider.class, method = "insertSelective")
    int insertSelective(TokenPo record);

    @Select({
            "select",
            "token_ID, token_name, create_time, effective_minutes, user_ID",
            "from token",
            "where token_ID = #{tokenId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "token_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "token_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "create_time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP),
            @Arg(column = "effective_minutes", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "user_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER)
    })
    TokenPo selectByPrimaryKey(Integer tokenId);

    @UpdateProvider(type = TokenDaoSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TokenPo record);

    @Update({
            "update token",
            "set token_name = #{tokenName,jdbcType=VARCHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "effective_minutes = #{effectiveMinutes,jdbcType=INTEGER},",
            "user_ID = #{userId,jdbcType=INTEGER}",
            "where token_ID = #{tokenId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TokenPo record);
}