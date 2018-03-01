package com.wugeek.auth.service.service.impl.basic;

import com.wugeek.auth.api.model.po.PermissionPo;
import com.wugeek.auth.api.model.po.RolePo;
import com.wugeek.auth.api.service.basic.RoleService;
import com.wugeek.auth.service.dao.sub.SimpleRoleDao;
import com.wugeek.auth.service.dao.unit.RolePermissionUnit;
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
public class RoleServiceImpl extends BasicCURDServiceImpl<RolePo, Integer> implements RoleService {

    @Autowired
    RolePermissionUnit rolePermissionUnit;

    public RoleServiceImpl(@Autowired SimpleRoleDao simpleRoleDao) {
        setBasicCRUDDao(simpleRoleDao);
    }

    @Override
    public ServiceVo retrievePermission(Integer id) {
        ServiceVo serviceVo = new ServiceVo();

        List<PermissionPo> list = rolePermissionUnit.retrievePermissionByRoleId(id);

        serviceVo.setResults(list);

        return serviceVo;
    }
}
