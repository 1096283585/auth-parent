package com.wugeek.auth.service.service.impl;

import com.wugeek.auth.api.model.po.PermissionAssociateApiPo;
import com.wugeek.auth.api.model.po.RoleAssociatePermissionPo;
import com.wugeek.auth.api.model.po.UserAssociateRolePo;
import com.wugeek.auth.api.model.vo.PermissionBindApiVo;
import com.wugeek.auth.api.model.vo.RoleBindPermissionVo;
import com.wugeek.auth.api.model.vo.UserBindRoleVo;
import com.wugeek.auth.api.service.BindService;
import com.wugeek.auth.service.dao.sub.SimplePermissionAssciateApiDao;
import com.wugeek.auth.service.dao.sub.SimpleRoleAssocicatePermissionDao;
import com.wugeek.auth.service.dao.sub.SimpleUserAssociateRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.web.service.model.vo.ServiceVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoshixiong on 2017/6/24.
 * <p>
 * version: 1.0
 */
@Service
public class BindServiceImpl implements BindService {

    @Autowired
    SimplePermissionAssciateApiDao simplePermissionAssciateApiDao;

    @Autowired
    SimpleRoleAssocicatePermissionDao simpleRoleAssocicatePermissionDao;

    @Autowired
    SimpleUserAssociateRoleDao simpleUserAssociateRoleDao;

    @Override
    public ServiceVo permissionBindApi(PermissionBindApiVo permissionBindApiVo) {
        List<PermissionAssociateApiPo> list = new ArrayList<>();

        int permissionId = permissionBindApiVo.getPermissionId();
        for (int appId : permissionBindApiVo.getApiId()) {
            PermissionAssociateApiPo permissionAssociateApiPo = new PermissionAssociateApiPo();

            permissionAssociateApiPo.setApiId(appId);
            permissionAssociateApiPo.setPermissionId(permissionId);

            list.add(permissionAssociateApiPo);
        }

        simplePermissionAssciateApiDao.deleteByPermissionid(permissionId);

        int code = list.isEmpty() ? 1 : simplePermissionAssciateApiDao.insertAll(list);

        return new ServiceVo(code);
    }

    @Override
    public ServiceVo roleBindPermission(RoleBindPermissionVo roleBindPermissionVo) {
        List<RoleAssociatePermissionPo> list = new ArrayList<>();

        int role_id = roleBindPermissionVo.getRoleId();
        for (int id : roleBindPermissionVo.getPermissionId()) {
            RoleAssociatePermissionPo permissionAssociateApiPo = new RoleAssociatePermissionPo();

            permissionAssociateApiPo.setRoleId(role_id);
            permissionAssociateApiPo.setPermissionId(id);

            list.add(permissionAssociateApiPo);
        }

        simpleRoleAssocicatePermissionDao.deleteByRoleId(role_id);

        int code = list.isEmpty() ? 0 : simpleRoleAssocicatePermissionDao.insertAll(list);

        return new ServiceVo(code);
    }

    @Override
    public ServiceVo userBindRole(UserBindRoleVo userBindRoleVo) {
        List<UserAssociateRolePo> list = new ArrayList<>();

        int userId = userBindRoleVo.getUserId();
        for (int roleId : userBindRoleVo.getRoleId()) {
            UserAssociateRolePo userAssociateRolePo = new UserAssociateRolePo();

            userAssociateRolePo.setUserId(userId);
            userAssociateRolePo.setRoleId(roleId);

            list.add(userAssociateRolePo);
        }

        simpleUserAssociateRoleDao.deleteByUserId(userId);

        int code = list.isEmpty() ? 0 : simpleUserAssociateRoleDao.insertAll(list);

        return new ServiceVo(code);
    }
}
