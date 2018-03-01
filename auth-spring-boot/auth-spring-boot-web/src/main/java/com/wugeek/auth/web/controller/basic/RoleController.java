package com.wugeek.auth.web.controller.basic;

import com.wugeek.auth.api.model.po.RolePo;
import com.wugeek.auth.api.service.basic.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.web.service.controller.BasicCRUDController;
import pers.web.service.model.vo.MessageVo;
import pers.web.service.model.vo.ServiceVo;

/**
 * Created by guoshixiong on 2017/6/22.
 * <p>
 * version: 1.0
 */
@RestController
@RequestMapping("/api/v1.0/role")
public class RoleController extends BasicCRUDController<RolePo, Integer> {

    @Autowired
    RoleService roleService;

    public RoleController(@Autowired RoleService roleService) {
        setBasicCURDService(roleService);
    }

    @GetMapping("/permissions/{id}")
    public Object retrievePermissionByRoleId(@PathVariable Integer id) {
        MessageVo messageVo = new MessageVo();

        ServiceVo serviceVo = roleService.retrievePermission(id);

        messageVo.setResult(serviceVo.getResults());

        return messageVo;
    }
}
