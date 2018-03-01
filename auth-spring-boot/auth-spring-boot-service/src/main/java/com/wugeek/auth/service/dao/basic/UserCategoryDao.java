package com.wugeek.auth.service.dao.basic;

import com.wugeek.auth.api.model.po.UserCategoryPo;
import com.wugeek.auth.service.dao.basic.provider.UserCategoryDaoSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import pers.web.service.dao.BasicCRUDDao;

@Mapper
public interface UserCategoryDao extends BasicCRUDDao<UserCategoryPo, Integer> {

    @Delete({
            "delete from user_category",
            "where user_category_ID = #{userCategoryId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userCategoryId);

    @Insert({
            "insert into user_category (user_category_ID, user_category)",
            "values (#{userCategoryId,jdbcType=INTEGER}, #{userType,jdbcType=CHAR})"
    })
    int insert(UserCategoryPo record);

    @InsertProvider(type = UserCategoryDaoSqlProvider.class, method = "insertSelective")
    int insertSelective(UserCategoryPo record);

    @Select({
            "select",
            "user_category_ID, user_category",
            "from user_category",
            "where user_category_ID = #{userCategoryId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "user_category_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "user_category", javaType = String.class, jdbcType = JdbcType.CHAR)
    })
    UserCategoryPo selectByPrimaryKey(Integer userCategoryId);

    @UpdateProvider(type = UserCategoryDaoSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserCategoryPo record);

    @Update({
            "update user_category",
            "set user_category = #{userType,jdbcType=CHAR}",
            "where user_category_ID = #{userCategoryId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserCategoryPo record);
}