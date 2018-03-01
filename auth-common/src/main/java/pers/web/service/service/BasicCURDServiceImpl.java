package pers.web.service.service;

import pers.web.service.dao.BasicCRUDDao;
import pers.web.service.model.vo.ServiceVo;

import java.util.List;

/**
 * Created by guoshixiong on 2017/6/10.
 * <p>
 * version: 1.0
 */
public abstract class BasicCURDServiceImpl<R, T> {

    private BasicCRUDDao<R, T> basicCRUDDao;

    public void setBasicCRUDDao(BasicCRUDDao<R, T> basicCRUDDao) {
        this.basicCRUDDao = basicCRUDDao;
    }

    public ServiceVo create(R record) {
        ServiceVo serviceVo = new ServiceVo();

        int code = basicCRUDDao.insertSelective(record);

        serviceVo.setCode(code);

        return serviceVo;
    }

    public ServiceVo delete(T id) {
        ServiceVo serviceVo = new ServiceVo();

        int code = basicCRUDDao.deleteByPrimaryKey(id);

        serviceVo.setCode(code);

        return serviceVo;
    }

    public ServiceVo retrieve(T id) {
        ServiceVo<R> serviceVo = new ServiceVo();

         R result = basicCRUDDao.selectByPrimaryKey(id);

         serviceVo.setCode(1);
         serviceVo.setResults(result);

        return serviceVo;
    }

    public ServiceVo retrieveAll() {
        ServiceVo<List<R>> serviceVo = new ServiceVo();

        List<R> list = basicCRUDDao.selectAll();

        serviceVo.setCode(1);
        serviceVo.setResults(list);

        return serviceVo;
    }

    public ServiceVo retrieveByPage(Integer page, Integer count) {
        ServiceVo<List<R>> serviceVo = new ServiceVo();

        int offset = (page - 1) * count;
        List<R> list = basicCRUDDao.selectByPage(offset, count);

        serviceVo.setCode(1);
        serviceVo.setResults(list);

        return serviceVo;
    }

    public ServiceVo update(R record) {
        ServiceVo serviceVo = new ServiceVo();

        int code = basicCRUDDao.updateByPrimaryKeySelective(record);

        serviceVo.setCode(code);

        return serviceVo;
    }
}
