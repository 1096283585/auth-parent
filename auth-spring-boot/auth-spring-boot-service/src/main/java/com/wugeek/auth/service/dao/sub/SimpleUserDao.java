package com.wugeek.auth.service.dao.sub;

import com.wugeek.auth.api.model.po.UserPo;
import com.wugeek.auth.service.dao.basic.UserDao;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by guoshixiong on 2017/6/10.
 * <p>
 * version: 1.0
 */
@Mapper
public interface SimpleUserDao extends UserDao {

    @Select({
            "select",
            "user_ID, user_category_ID, login_name, password, user_name, user_code, user_active, ",
            "user_position",
            "from user"
    })
    @ConstructorArgs({
            @Arg(column = "user_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "user_category_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "login_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "password", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "user_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "user_code", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "user_active", javaType = Boolean.class, jdbcType = JdbcType.BIT),
            @Arg(column = "user_position", javaType = String.class, jdbcType = JdbcType.CHAR)
    })
    List<UserPo> selectAll();

    @Select({
            "select",
            "user_ID, user_category_ID, login_name, password, user_name, user_code, user_active, ",
            "user_position",
            "from user",
            "limit #{arg0}, #{arg1}"
    })
    @ConstructorArgs({
            @Arg(column = "user_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "user_category_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "login_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "password", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "user_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "user_code", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "user_active", javaType = Boolean.class, jdbcType = JdbcType.BIT),
            @Arg(column = "user_position", javaType = String.class, jdbcType = JdbcType.CHAR)
    })
    List<UserPo> selectByPage(Integer offset, Integer count);

    @Select({
            "select",
            "*",
            "from user",
            "where login_name = #{loginName, jdbcType = INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "user_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "user_category_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "login_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "password", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "user_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "user_code", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "user_active", javaType = Boolean.class, jdbcType = JdbcType.BIT),
            @Arg(column = "user_position", javaType = String.class, jdbcType = JdbcType.CHAR)
    })
    UserPo selectUserByLoginName(String loginName);

    @Select({
            "select",
            "*",
            "from user, token",
            "where token_name = #{token, jdbcType = VARCHAR} and",
            "user.user_ID = token.user_ID"
    })
    @ConstructorArgs({
            @Arg(column = "user_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "user_category_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "login_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "password", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "user_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "user_code", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "user_active", javaType = Boolean.class, jdbcType = JdbcType.BIT),
            @Arg(column = "user_position", javaType = String.class, jdbcType = JdbcType.CHAR)
    })
    UserPo selectUserByToken(String token);
}
