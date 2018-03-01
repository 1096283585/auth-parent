package com.wugeek.auth.service.service.impl.basic;

import com.wugeek.auth.api.model.po.ApiPo;
import com.wugeek.auth.api.model.po.PermissionPo;
import com.wugeek.auth.api.service.basic.PermissionService;
import com.wugeek.auth.service.dao.sub.SimplePermissionAssciateApiDao;
import com.wugeek.auth.service.dao.sub.SimplePermissionDao;
import com.wugeek.auth.service.dao.unit.PermissionApiUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.web.service.model.vo.ServiceVo;
import pers.web.service.service.BasicCURDServiceImpl;

import java.util.List;

/**
 * Created by guoshixiong on 2017/6/20.
 * <p>
 * version: 1.0
 */
@Service
public class PermissionServiceImpl extends BasicCURDServiceImpl<PermissionPo, Integer> implements PermissionService {

    @Autowired
    PermissionApiUnit permissionApiUnit;

    @Autowired
    SimplePermissionAssciateApiDao simplePermissionAssciateApiDao;

    public PermissionServiceImpl(@Autowired SimplePermissionDao simplePermissionDao) {
        setBasicCRUDDao(simplePermissionDao);
    }

    @Override
    public ServiceVo retrieveApiByPermissionId(Integer id) {
        ServiceVo serviceVo = new ServiceVo();

        List<ApiPo> list = permissionApiUnit.retrieveApi(id);

        serviceVo.setResults(list);

        return serviceVo;
    }

    @Override
    public ServiceVo delete(Integer id) {
        simplePermissionAssciateApiDao.deleteByPermissionid(id);
        return super.delete(id);
    }
}
