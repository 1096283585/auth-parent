package com.wugeek.auth.service.dao.sub;

import com.wugeek.auth.api.model.po.UserCategoryPo;
import com.wugeek.auth.service.dao.basic.UserCategoryDao;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by guoshixiong on 2017/6/9.
 * <p>
 * version: 1.0
 */
@Mapper
public interface SimpleUserCategoryDao extends UserCategoryDao {

    @Select({
            "select",
            "user_category_ID, user_category",
            "from user_category"
    })
    @ConstructorArgs({
            @Arg(column = "user_category_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "user_category", javaType = String.class, jdbcType = JdbcType.CHAR)
    })
    List<UserCategoryPo> selectAll();

    @Select({
            "select",
            "user_category_ID, user_category",
            "from user_category",
            "limit #{arg0}, #{arg1}"
    })
    @ConstructorArgs({
            @Arg(column = "user_category_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "user_category", javaType = String.class, jdbcType = JdbcType.CHAR)
    })
    List<UserCategoryPo> selectByPage(Integer offset, Integer count);
}
