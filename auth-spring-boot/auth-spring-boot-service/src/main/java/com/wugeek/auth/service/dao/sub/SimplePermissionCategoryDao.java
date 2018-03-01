package com.wugeek.auth.service.dao.sub;

import com.wugeek.auth.api.model.po.PermissionCategoryPo;
import com.wugeek.auth.service.dao.basic.PermissionCategoryDao;
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
public interface SimplePermissionCategoryDao extends PermissionCategoryDao {

    @Select({
            "select",
            "permission_category_ID, permission_category",
            "from permission_category"
    })
    @ConstructorArgs({
            @Arg(column = "permission_category_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "permission_category", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<PermissionCategoryPo> selectAll();

    @Select({
            "select",
            "permission_category_ID, permission_category",
            "from permission_category",
            "limit #{arg0}, #{arg1}"
    })
    @ConstructorArgs({
            @Arg(column = "permission_category_ID", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "permission_category", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<PermissionCategoryPo> selectByPage(Integer offset, Integer count);
}
