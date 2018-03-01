package pers.web.service.dao;

import java.util.List;

/**
 * Created by guoshixiong on 2017/6/7.
 * <p>
 * version: 1.0
 */
public interface BasicCRUDDao<R, A> {

    int insert(R record);

    int insertSelective(R record);

    int deleteByPrimaryKey(A id);

    R selectByPrimaryKey(A id);

    List<R> selectAll();

    List<R> selectByPage(Integer offset, Integer count);

    int updateByPrimaryKey(R record);

    int updateByPrimaryKeySelective(R record);
}
