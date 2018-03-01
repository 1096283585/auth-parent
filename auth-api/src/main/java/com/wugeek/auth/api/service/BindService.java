package com.wugeek.auth.api.service;

import com.wugeek.auth.api.model.vo.PermissionBindApiVo;
import com.wugeek.auth.api.model.vo.RoleBindPermissionVo;
import com.wugeek.auth.api.model.vo.UserBindRoleVo;
import pers.web.service.model.vo.ServiceVo;

/**
 * Created by guoshixiong on 2017/6/24.
 * <p>
 * version: 1.0
 */
public interface BindService {

    ServiceVo permissionBindApi(PermissionBindApiVo permissionBindApiVo);

    ServiceVo roleBindPermission(RoleBindPermissionVo roleBindPermissionVo);

    ServiceVo userBindRole(UserBindRoleVo userBindRoleVo);
}
