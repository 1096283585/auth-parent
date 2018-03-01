package com.wugeek.auth.web.controller.complex;

import com.wugeek.auth.api.model.vo.PermissionBindApiVo;
import com.wugeek.auth.api.model.vo.RoleBindPermissionVo;
import com.wugeek.auth.api.model.vo.UserBindRoleVo;
import com.wugeek.auth.api.service.BindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.web.service.controller.AbsController;
import pers.web.service.model.vo.MessageVo;

/**
 * Created by guoshixiong on 2017/6/24.
 * <p>
 * version: 1.0
 */
@RestController
@RequestMapping("/api/v1.0/bind/")
public class BindController extends AbsController {

    @Autowired
    BindService bindService;

    @PostMapping("/permission/api")
    public Object permissionBindApi(@RequestBody PermissionBindApiVo permissionBindApiVo) {
        bindService.permissionBindApi(permissionBindApiVo);

        return new MessageVo();
    }

    @PostMapping("/role/permission")
    public Object roleBindPermission(@RequestBody RoleBindPermissionVo roleBindPermissionVo) {
        bindService.roleBindPermission(roleBindPermissionVo);

        return new MessageVo();
    }

    @PostMapping("/user/role")
    public Object roleBindPermission(@RequestBody UserBindRoleVo userBindRoleVo) {
        bindService.userBindRole(userBindRoleVo);

        return new MessageVo();
    }
}
