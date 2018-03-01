package com.wugeek.auth.service.dao.basic;

import com.wugeek.auth.api.model.po.UserPo;
import com.wugeek.auth.service.dao.basic.provider.UserDaoSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import pers.web.service.dao.BasicCRUDDao;

public interface UserDao extends BasicCRUDDao<UserPo, Integer> {

    @Delete({
            "delete from user",
            "where user_ID = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    @Insert({
            "insert into user (user_ID, user_category_ID, ",
            "login_name, password, ",
            "user_name, user_code, ",
            "user_active, user_position)",
            "values (#{userId,jdbcType=INTEGER}, #{userCategoryId,jdbcType=INTEGER}, ",
            "#{loginName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
            "#{userName,jdbcType=VARCHAR}, #{userCode,jdbcType=VARCHAR}, ",
            "#{userActive,jdbcType=BIT}, #{userPosition,jdbcType=CHAR})"
    })
    int insert(UserPo record);

    @InsertProvider(type = UserDaoSqlProvider.class, method = "insertSelective")
    int insertSelective(UserPo record);

    @Select({
            "select",
            "user_ID, user_category_ID, login_name, password, user_name, user_code, user_active, ",
            "user_position",
            "from user",
            "where user_ID = #{userId,jdbcType=INTEGER}"
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
    UserPo selectByPrimaryKey(Integer userId);

    @UpdateProvider(type = UserDaoSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserPo record);

    @Update({
            "update user",
            "set user_category_ID = #{userCategoryId,jdbcType=INTEGER},",
            "login_name = #{loginName,jdbcType=VARCHAR},",
            "password = #{password,jdbcType=VARCHAR},",
            "user_name = #{userName,jdbcType=VARCHAR},",
            "user_code = #{userCode,jdbcType=VARCHAR},",
            "user_active = #{userActive,jdbcType=BIT},",
            "user_position = #{userPosition,jdbcType=CHAR}",
            "where user_ID = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserPo record);
}