package pers.web.service.service;

import pers.web.service.model.vo.ServiceVo;

import java.util.List;

/**
 * Created by guoshixiong on 2017/6/10.
 * <p>
 * version: 1.0
 */
public interface BasicCURDService<R, T> {

    ServiceVo create(R record);

    ServiceVo delete(T id);

    ServiceVo<R> retrieve(T id);

    ServiceVo<List<R>> retrieveAll();

    ServiceVo<List<R>> retrieveByPage(Integer page, Integer count);

    ServiceVo update(R record);
}
